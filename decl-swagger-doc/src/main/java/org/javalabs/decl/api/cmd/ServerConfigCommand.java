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
 *
 * @author schan280
 */
public class ServerConfigCommand implements Command {
    
    private static final String SERVER_TEMPLATE = "server.template";
    private static final String SERVER_FILE   = "server.xml";
    
    private final String name;
    
    public ServerConfigCommand(String name) {
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
            // Generate pom.xml file
            String template = "template" + File.separator
                    + project.platform().name().toLowerCase() + File.separator
                    + project.stack().name().toLowerCase() + File.separator
                    + "xml" + File.separator
                    + SERVER_TEMPLATE;
                    
            byte[] buff = FileHandlerUtil.read(template);
            String content = new String(buff);
            content = content.replace("{APP}", project.name());
            
            File serverConfigFile = new File(project.dir() + File.separator + project.name() + File.separator + project.srcResourceDir(), SERVER_FILE);
            ClassWriter.write(serverConfigFile, content, project.verbose());
            
            if (project.verbose() <= 2) {
                ConsoleWriter.timingPrintln("Created " + ConsoleWriter.ANSI_GREEN + serverConfigFile + ConsoleWriter.ANSI_RESET);
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
