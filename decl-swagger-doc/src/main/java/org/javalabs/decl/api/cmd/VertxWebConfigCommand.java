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
public class VertxWebConfigCommand implements Command {
    
    private static final String V_WEB_TEMPLATE = "vertx-web.template";
    private static final String V_WEB_FILE   = "vertx-web.xml";
    
    private final String name;
    
    public VertxWebConfigCommand(String name) {
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
                    + V_WEB_TEMPLATE;
                    
            byte[] buff = FileHandlerUtil.read(template);
            String tmp = new String(buff);
            tmp = tmp.replace("{PACKAGE}", project.corePkg());
            
            File serverConfigFile = new File(project.dir() + File.separator + project.name() + File.separator + project.srcResourceDir(), V_WEB_FILE);
            ClassWriter.write(serverConfigFile, tmp, project.verbose());
            
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
