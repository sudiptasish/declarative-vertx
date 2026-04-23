package org.javalabs.decl.compile;

/**
 *
 * @author schan280
 */
public class MemoryClassLoader extends ClassLoader {
    
    private final CompiledClassHolder holder;

    public MemoryClassLoader(ClassLoader parent, CompiledClassHolder holder) {
        super(parent);
        this.holder = holder;
    }

    @Override
    public Class findClass(String className) throws ClassNotFoundException {
        byte[] buff = loadClassFromArray(className);
        return defineClass(className, buff, 0, buff.length);
    }

    private byte[] loadClassFromArray(String className) {
        byte[] buffer = holder.classBytes(className);
        return buffer;
    }
}
