package org.javalabs.decl.compile;

import org.javalabs.decl.util.ConsoleWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 *
 * @author schan280
 */
public final class InMemoryCompiler {

    // Java system compiler.
    private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    
    /**
     * Compile a Java source file in memory.
     *
     * @param javaFiles     Java file name, e.g. "Test.java". It need not be present on the disc.
     * @param contents      The content of the java file as String.
     * @param holder        Compiled class holder.
     * @return Boolean      If compilation is successful !
     * @throws IOException If compile error.
     */
    public static Boolean compile(String[] javaFiles, String[] contents, CompiledClassHolder holder) throws IOException {
        final StandardJavaFileManager stdManager = compiler.getStandardFileManager(null, null, null);
        final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        
        try (InMemoryFileManager manager = new InMemoryFileManager(stdManager)) {
            
            List<JavaFileObject> objects = new ArrayList<>(javaFiles.length);
            for (int i = 0; i < javaFiles.length; i ++) {
                JavaFileObject object = manager.make(javaFiles[i], contents[i]);
                objects.add(object);
            }
            
            CompilationTask task = compiler.getTask(
                    null
                    , manager
                    , diagnostics
                    , null
                    , null
                    , objects);
            
            // Perform compilation
            Boolean result = task.call();
            
            if (! result) {
                StringBuilder buff = new StringBuilder(64);
                diagnostics.getDiagnostics()
                    .forEach(d -> buff.append(String.valueOf(d)).append("\n"));
                
                ConsoleWriter.timingPrintln("Unable to compile model classes. Error: " + buff.toString());
                throw new RuntimeException(buff.toString());
            }
            holder.compiledClasses(manager.compiledClasses());
        }
        return Boolean.TRUE;
    }
}
