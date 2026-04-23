package org.javalabs.decl.compile;

import org.javalabs.decl.util.ConsoleWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 *
 * @author schan280
 */
public final class DiscCompiler {
    
    public static void compile(String generatedDir
            , String pkgName
            , String className
            , String modelFile) throws IOException, ClassNotFoundException {
        
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        
        try (StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null)) {
            Iterable<? extends JavaFileObject> unit
                    = manager.getJavaFileObjectsFromFiles(
                            Arrays.asList(new File(modelFile)));
            
            Boolean result = compiler.getTask(null
                    , manager
                    , diagnostics
                    , Arrays.asList("-d", generatedDir)
                    , null
                    , unit).call();
            
            if (result) {
                // Compilation is successful
                File outDir = new File("generated");
                URL[] urls = new URL[1];

                if (! outDir.exists()) {
                    throw new IllegalArgumentException("Generated directory " + outDir + " does not exist");
                }
                urls[0] = outDir.toURI().toURL();
                URLClassLoader loader = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
                Thread.currentThread().setContextClassLoader(loader);
                
                Class<?> clazz = loader.loadClass(pkgName + "." + className);
                ConsoleWriter.timingPrintln("Loaded model class " + clazz.getName() + " into memory");
            }
            else {
                ConsoleWriter.timingPrintln("Unable to load model class " + pkgName + "." + className);
                
                StringBuilder buff = new StringBuilder(64);
                diagnostics.getDiagnostics()
                    .forEach(d -> buff.append(String.valueOf(d)).append("\n"));
                 
                throw new RuntimeException(buff.toString());
            }
        }
    }
}
