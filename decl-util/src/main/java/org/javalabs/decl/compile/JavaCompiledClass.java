package org.javalabs.decl.compile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import javax.tools.SimpleJavaFileObject;

/**
 *
 * @author schan280
 */
public class JavaCompiledClass extends SimpleJavaFileObject {
    
    private final String name;
    private CompiledOutputStream out;
    
    private byte[] compiled;

    public JavaCompiledClass(String name) {
        super(URI.create("string:///" + name), Kind.CLASS);
        this.name = name;
    }
    
    public byte[] compiled() {
        return compiled;
    }
    
    void compiled(byte[] compiled) {
        this.compiled = compiled;
    }

    @Override
    public OutputStream openOutputStream() {
        // At the time of writing the compiled (generated) class bytes, this method will be called.
        // The call is originated from InMemoryFileManager.getJavaFileForOutput()
        if (out == null) {
            out = new CompiledOutputStream(this);
        }
        return out;
    }
    
    public static class CompiledOutputStream extends ByteArrayOutputStream {
        
        private final JavaCompiledClass jc;
        
        public CompiledOutputStream(JavaCompiledClass jc) {
            super();
            this.jc = jc;
        }

        @Override
        public void close() throws IOException {
            // Once the entire compiled class bytes have been written to the OutputStream "out",
            // The close method will be called.
            // The compiled class bytes is preserved in the private byte array variable.
            super.close();
            jc.compiled(super.toByteArray());
        }
    }
}
