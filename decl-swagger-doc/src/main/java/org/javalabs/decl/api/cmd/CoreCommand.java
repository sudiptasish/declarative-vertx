package org.javalabs.decl.api.cmd;

import java.io.File;
import java.io.IOException;
import java.util.Map;
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
public class CoreCommand implements Command {
    
    private final Map<String, String> templateMapping = Map.of(
            "AppContainer.java", "app_container.template",
            "AppHttpServer.java", "app_httpserver.template",
            "AppProcessor.java", "app_processor.template",
            "DefaultTimer.java", "app_timer.template"
    );
    
    private final String name;
    
    public CoreCommand(String name) {
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
            File projectRoot = new File(project.dir(), project.name());
            String destDir = projectRoot.getAbsolutePath()
                    + File.separator
                    + project.srcDir()
                    + File.separator
                    + project.corePkg().replace('.', '/');
            
            String coreDir = "template" + File.separator
                    + project.platform().name().toLowerCase() + File.separator
                    + project.stack().name().toLowerCase() + File.separator
                    + "core";
            
            for (Map.Entry<String, String> me : templateMapping.entrySet()) {
                String template = coreDir + File.separator + me.getValue();
                write(project, destDir, template, me.getKey().substring(0, me.getKey().indexOf(".")));
            }
            return CompletableFuture.completedFuture(CONTINUE);
        }
        catch (IOException e) {
            return CompletableFuture.failedFuture(e);
        }
    }
    
    private void write(Project project, String destDir, String template, String className) throws IOException {
        byte[] buff = FileHandlerUtil.read(template);
            
        // Now, look for the following customizer sequentially and start replacing the code
        String content = new String(buff);
        content = content.replace("{PACKAGE}", project.corePkg());
        content = content.replace("{CONFIG_PACKAGE}", project.configPkg());
        content = content.replace("{PU_NAME}", project.name().toLowerCase() + "-" + "pu");

        File file = new File(destDir + File.separator + className + ".java");
        
        ClassWriter.write(file, content, project.verbose());
        if (project.verbose() <= 2) {
            ConsoleWriter.timingPrintln("Created container related file: " + ConsoleWriter.ANSI_GREEN + file.getAbsolutePath() + ConsoleWriter.ANSI_RESET);
        }
    }

    @Override
    public void backtrack(Context ctx) {
        // Do Nothing
    }
}
