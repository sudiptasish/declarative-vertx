package org.javalabs.decl.compile;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author schan280
 */
public class CompiledClassHolder {
    
    private final Map<String, JavaCompiledClass> compiledClasses = new HashMap<>();

    public void compiledClasses(Map<String, JavaCompiledClass> compiledClasses) {
        this.compiledClasses.putAll(compiledClasses);
    }
    
    public byte[] classBytes(String className) {
        JavaCompiledClass compiledClass = compiledClasses.get(className);
        if (compiledClass != null) {
            return compiledClass.compiled();
        }
        return null;
    }
}
