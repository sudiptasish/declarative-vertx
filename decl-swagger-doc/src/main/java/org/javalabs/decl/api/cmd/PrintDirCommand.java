package org.javalabs.decl.api.cmd;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.util.ConsoleWriter;
import org.javalabs.decl.workflow.Command;
import static org.javalabs.decl.workflow.Command.CONTINUE;
import org.javalabs.decl.workflow.Context;

/**
 *
 * @author schan280
 */
public class PrintDirCommand implements Command {
    
    private final String name;
    
    public PrintDirCommand(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Future<?> execute(Context ctx) {
        Project project = (Project)ctx.get("project.work");
        
        try {
            if (project.verbose() <= 2) {
                ConsoleWriter.timingPrintln("\nProject hierarchy:\n");
                hierarchy(new File(project.dir() + File.separator + project.name()), "");
                ConsoleWriter.println("");
            }
            return CompletableFuture.completedFuture(CONTINUE);
        }
        catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
    
    public void hierarchy(File directory, String indent) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            ConsoleWriter.timingPrintln(indent + "+-- " + ConsoleWriter.ANSI_GREEN + file.getName() + ConsoleWriter.ANSI_RESET);
            if (file.isDirectory()) {
                hierarchy(file, indent + "|  ");
            }
        }
    }

    @Override
    public void backtrack(Context ctx) {
        // Do Nothing
    }
    
}
