package org.javalabs.decl.workflow;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.javalabs.decl.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract workflow chain to encapsulate the common functionalities of a chain.
 *
 * @author Sudiptasish Chanda
 */
@JsonSerialize(using = ChainSerializer.class)
public abstract class AbstractChain implements Chain {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractChain.class);
    
    private static final boolean IDLE = false;
    private static final boolean RUNNING = true;
    
    private final ChainConfig cc;
    protected final List<Command> commands = new ArrayList<>();
    
    private boolean initialized = false;
    
    private final AtomicBoolean running = new AtomicBoolean(IDLE);
    
    public AbstractChain(ChainConfig cc) {
        this.cc = cc;
    }

    @Override
    public String name() {
        return cc.getName();
    }
    
    public Boolean async() {
        return cc.getAsync();
    }
    
    public Integer maxRetry() {
        return cc.getMaxRetry();
    }

    /**
     * Check if this workflow chain has been initialized.
     * @return Boolean
     */
    public Boolean isInitialized() {
        return initialized;
    }

    /**
     * Mark this workflow chain as initialized.
     */
    public void markInitialized() {
        this.initialized = Boolean.TRUE;
    }

    @Override
    public boolean active() {
        return running.get();
    }

    @Override
    public void add(Command command) {
        commands.add(command);
    }

    @Override
    public Command[] commands() {
        return commands.toArray(new Command[commands.size()]);
    }

    @Override
    public Command command(String name) {
        for (Command cmd : commands) {
            if (cmd.name().equals(name)) {
                return cmd;
            }
        }
        throw new IllegalArgumentException("No command " + name + " exist in workflow chain " + name());
    }

    @Override
    public void init() {
        markInitialized();
    }

    @Override
    public void start(Context ctx) {
        if (! isInitialized()) {
            throw new IllegalStateException("Workflow chain " + name() + " is not initialized");
        }
        boolean success = true;
        try {
            success = running.compareAndSet(IDLE, RUNNING);
            if (! success) {
                LOGGER.warn("Workflow chain {} is already running."
                    + " Any new attempt to rerun it, will be ignored", name());
                return;
            }
            Objects.requireNonNull(ctx, "Workflow context cannot be null");

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Starting {} workflow chain."
                    + " Total number of command(s): {}", name(), commands.size());
            }
            execute(ctx);
        }
        finally {
            if (success) {
                complete();
            }
        }
    }

    /**
     * Entry point for command execution.
     * 
     * The implementing class must override this method to give their own implementation
     * of command execution (sync or async).
     * @param ctx
     */
    protected void execute(Context ctx) {
        try {
            int start = 0;
            StopWatch timer = StopWatch.newTimer();
            timer.start();

            Command command = null;
            for (; start < commands.size(); start ++) {
                command = commands.get(start);

                if (! ctx.isValid()) {
                    break;
                }
                Future<?> future = command.execute(ctx);
                if (future.isCancelled()
                        || (future instanceof CompletableFuture && ((CompletableFuture)future).isCompletedExceptionally())
                        || "No.Job".equals(future.get())) {
                    
                    // Call the handleError method and pass the exception.
                    // Leave it to the caller as to how to respond to it.
                    Object val = ctx.get("notify.error");
                    if (val != null && Boolean.parseBoolean(val.toString()) && future instanceof CompletableFuture) {
                        WorkflowError wError = (WorkflowError)ctx.get("workflow.error");

                        try {
                            future.get();
                        }
                        catch (ExecutionException e) {
                            if (wError != null) {
                                wError.setError(e);
                            }
                            handleError(e);
                        }
                    }
                    break;
                }
                if (future.isDone()) {
                    // Do nothing, the current command is successfully completed.
                    // Go to next command.
                }
            }
            timer.stop();

            // Check if all the commands have been executed.
            if (start > 0 && start < commands.size()) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("{} workflow chain is incomplete. Command {} has failed."
                        + " Reason: {}. Elapsed time(ms): {}"
                        , name()
                        , command != null ? command.name() : "unknown"
                        , ctx.message()
                        , timer.elapsedTimeMillis());
                }
                if (ctx.isBacktrackingEnabled()) {
                    for ( ; -- start >= 0; ) {
                        command = commands.get(start);
                        command.backtrack(ctx);
                    }
                }
            }
            else {
                // Workflow chain completed successfully !
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("{} workflow chain completed. Elapsed time(ms): {}"
                        , name(), timer.elapsedTimeMillis());
                }
            }
        }
        catch (ExecutionException | InterruptedException e) {
            // Do Nothing.
        }
    }
    
    protected void handleError(Throwable error) {
        // Do Nothing
    }
    
    /**
     * Mark the chain as complete.
     * This method is used for asynchronous workflow execution.
     */
    protected void complete() {
        running.set(IDLE);
    }

    @Override
    public void terminate() {
        // No-Op
    }
}
