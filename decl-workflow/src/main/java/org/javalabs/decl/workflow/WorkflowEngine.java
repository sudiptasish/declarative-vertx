package org.javalabs.decl.workflow;

import java.util.Iterator;
import java.util.Map;
import org.javalabs.decl.util.ObjectCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class that represents a workflow engine.
 * 
 * <p>
 * A workflow engine is a component designed to help carry out a series of recurring
 * tasks that make up a business process.
 * It is the orchestrator in workflow and typically makes use of some persistent
 * storage to store the result of intermediate step. It facilitates the flow of 
 * information, tasks, and events.
 * 
 * <p>
 * Before a workflow engine is started, it first identifies the {@link Chain} that
 * needs to be executed and accordingly query the {@link Catalog} to fetch the
 * relevant {@link Command} and assemble them on the {@link Chain}. Once the chain
 * is ready, it kick-start the process.
 *
 * @author Sudiptasish Chanda
 */
public abstract class WorkflowEngine {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkflowEngine.class);

    private static volatile WorkflowEngine engine;
    
    private boolean initialized = false;
    
    protected WorkflowEngine() {}
    
    /**
     * Set the default workflow engine.
     * @param engine 
     */
    static void set(WorkflowEngine engine) {
        WorkflowEngine.engine = engine;
    }
    
    /**
     * Return the default platform workflow engine.
     * @return WorkflowEngine
     */
    public static WorkflowEngine getDefault() {
        return engine;
    }
    
    /**
     * Initialize the workflow engine.
     */
    public void init() {
        markInitialized();
    }

    /**
     * Check if the platform workflow engine is initialized.
     * @return boolean
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Mark the platform workflow engine as initialized.
     */
    public void markInitialized() {
        this.initialized = true;
    }
    
    /**
     * Start the workflow engine.
     * @param args  Input to the workflow engine.
     */
    public void start(EngineArgs args) {
        if (! isInitialized()) {
            throw new IllegalStateException("Platform workflow engine is not initialized");
        }
        // Initialize the workflow context.
        Chain chain = SystemCatalog.get().get(args.getWorkflowChain());
        if (chain == null) {
            LOGGER.warn("Invalid workflow name {} specified. Cannot start workflow", args.getWorkflowChain());
            return;
        }
        if (chain.active()) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Workflow chain {} is still running", chain.name());
            }
            return;
        }
        Context ctx = initContext(args.getWorkflowContext(), chain);
        ctx.add("job.name", args.getJob());
        
        // Add the baggage item(s).
        for (Iterator<Map.Entry<String, Object>> itr = args.baggages(); itr.hasNext(); ) {
            Map.Entry<String, Object> me = itr.next();
            ctx.add(me.getKey(), me.getValue());
        }
        chain.start(ctx);
    }

    private Context initContext(String workflowContext, Chain chain) {
        Context context = ObjectCreator.create(workflowContext
            , new Class[] {AbstractChain.class}
            , new Object[] {chain});
        
        return context;
    }
    
    /**
     * Shutdown this engine.
     */
    public void shutdown() {
        for (Chain chain : SystemCatalog.get().getAll()) {
            if (chain.active()) {
                chain.terminate();
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn("Chain {} is terminated", chain.name());
                }
            }
        }
    }
}
