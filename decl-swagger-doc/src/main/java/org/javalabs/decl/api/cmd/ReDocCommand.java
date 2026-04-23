package org.javalabs.decl.api.cmd;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.util.ConsoleWriter;
import org.javalabs.decl.util.FileHandlerUtil;
import org.javalabs.decl.workflow.Command;
import static org.javalabs.decl.workflow.Command.CONTINUE;
import org.javalabs.decl.workflow.Context;
import org.javalabs.decl.writer.ClassWriter;

/**
 * Command to generate the redoc html.
 *
 * @author schan280
 */
public class ReDocCommand implements Command {
    
    private static final String REDOC_TEMPLATE = "index_html.template";
    private static final String REDOC_NAME  = "index.html";
    
    private final String name;
    
    public ReDocCommand(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Future<?> execute(Context ctx) {
        Project project = (Project)ctx.get("project.work");
        
        File projectRoot = new File(project.dir(), project.name());
        
        try {
            String template = "template" + File.separator
                    + project.platform().name().toLowerCase() + File.separator
                    + REDOC_TEMPLATE;
                    
            byte[] buff = FileHandlerUtil.read(template);
            
            String destDir = projectRoot.getAbsolutePath()
                    + File.separator
                    + project.docDir();
            
            File file = new File(destDir + File.separator + REDOC_NAME);
            ClassWriter.write(file, new String(buff), project.verbose());
            
            if (project.verbose() <= 2) {
                ConsoleWriter.timingPrintln("Created redoc file: " + ConsoleWriter.ANSI_GREEN + file.getAbsolutePath() + ConsoleWriter.ANSI_RESET);
            }
            return CompletableFuture.completedFuture(CONTINUE);
        }
        catch (IOException e) {
            return CompletableFuture.failedFuture(e);
        }
    }

    @Override
    public void backtrack(Context ctx) {
        // Do Nothing
    }
}
