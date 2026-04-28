package org.javalabs.decl.api.cmd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.gen.JavaClass;
import org.javalabs.decl.gen.JaxbJpaConverterBridge;
import org.javalabs.decl.util.ConsoleWriter;
import org.javalabs.decl.util.FileHandlerUtil;
import org.javalabs.decl.workflow.Command;
import static org.javalabs.decl.workflow.Command.CONTINUE;
import org.javalabs.decl.workflow.Context;

/**
 *
 * @author schan280
 */
public class OrmEntityModelCommand implements Command {
    
    private static final String ORM_XML = "orm.xml";
    private final String name;
    private final JaxbJpaConverterBridge bridge;
    
    public OrmEntityModelCommand(String name) {
        this.name = name;
        this.bridge = new JaxbJpaConverterBridge();
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
                    + project.modelPkg().replace('.', '/');

            String ormXml = readOrmXml(ctx, project);
            
            Map<String, JavaClass> classes = bridge.toJavaClass(ormXml);
            ctx.add("resource.names", classes);
            
            LinkedHashMap<String, String> rawContents = new LinkedHashMap<>();
            for (Map.Entry<String, JavaClass> me : classes.entrySet()) {
                String raw = bridge.serialize(me.getValue());
                rawContents.put(me.getKey(), raw);
            }
            write(project, destDir, rawContents);
            
            if (project.verbose() <= 2) {
                ConsoleWriter.timingPrintln("Generated " + rawContents.size() + " jpa entities from orm.xml" + ConsoleWriter.ANSI_RESET);
            }
            return CompletableFuture.completedFuture(CONTINUE);
        }
        catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
    
    public void write(Project project, String destDir, Map<String, String> classMapping) throws IOException {
        for (Map.Entry<String, String> me : classMapping.entrySet()) {
            Files.write(
                    Paths.get(destDir + File.separator + me.getKey() + ".java")
                    , me.getValue().getBytes()
                    , StandardOpenOption.CREATE_NEW);
        }
    }
    
    private String readOrmXml(Context ctx, Project project) throws IOException {
        String ormXml = (String)ctx.get("orm.xml");
        if (ormXml == null) {
            // Generate routing-config.xml file
            String template = "template" + File.separator
                    + project.platform().name().toLowerCase() + File.separator
                    + "common" + File.separator
                    + ORM_XML;
            
            byte[] buff = FileHandlerUtil.read(template);
            ormXml = new String(buff);
            ormXml = ormXml.replace("{MODEL_PACKAGE}", project.modelPkg());
        }
        return ormXml;
    }

    @Override
    public void backtrack(Context ctx) {
        // Do Nothing
    }
}
