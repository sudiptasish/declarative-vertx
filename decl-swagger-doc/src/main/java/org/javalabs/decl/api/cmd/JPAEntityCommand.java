package org.javalabs.decl.api.cmd;

import org.javalabs.jpa.entity.EntityGenerator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.gen.JaxbJpaConverterBridge;
import org.javalabs.decl.util.ConsoleWriter;
import org.javalabs.decl.workflow.Command;
import static org.javalabs.decl.workflow.Command.CONTINUE;
import org.javalabs.decl.workflow.Context;

/**
 *
 * @author schan280
 */
public class JPAEntityCommand implements Command {
    
    private final String name;
    private final JaxbJpaConverterBridge bridge;
    
    public JPAEntityCommand(String name) {
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
            
            Map<String, Object> params = new HashMap<>();
            params.put("model.gen", "true");
            params.put("jpa-lite.dialect", "postgres");
            params.put("jpa-lite.entity.package", project.modelPkg());
            params.put("javax.persistence.jdbc.host", "localhost");
            params.put("javax.persistence.jdbc.port", "5432");
            params.put("javax.persistence.jdbc.db", "testdb");
            params.put("javax.persistence.jdbc.schema", "public");
            params.put("javax.persistence.jdbc.user", "test");
            params.put("javax.persistence.jdbc.password", "test123");
            
            // params.put("sample.table.name", "fk_");
            params.put("exclude.entity.name.prefix", "fk_");
            params.put("verbose.log", "N");
            
            String ormXml = EntityGenerator.extract(projectRoot.getAbsolutePath(), params);
            Map<String, String> classMapping = bridge.toRawClass(ormXml);
            ctx.add("resource.name", classMapping.keySet());
            
            write(project, classMapping);
            
            if (project.verbose() <= 2) {
                ConsoleWriter.timingPrintln("Generated " + classMapping.size() + " jpa entities from remote db" + ConsoleWriter.ANSI_RESET);
            }
            return CompletableFuture.completedFuture(CONTINUE);
        }
        catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
    
    public void write(Project project, Map<String, String> classMapping) throws IOException {
        for (Map.Entry<String, String> me : classMapping.entrySet()) {
            Files.write(
                    Paths.get(project.dir()
                            , project.srcDir()
                                    + File.separator + project.modelPkg().replace('.', File.separatorChar)
                                    + File.separator + me.getKey() + ".java")
                    , me.getValue().getBytes()
                    , StandardOpenOption.CREATE_NEW);
        }
    }

    @Override
    public void backtrack(Context ctx) {
        // Do Nothing
    }
}
