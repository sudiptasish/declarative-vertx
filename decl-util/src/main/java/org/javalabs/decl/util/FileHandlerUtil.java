package org.javalabs.decl.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Utility class for handling file operation.
 *
 * @author schan280
 */
public final class FileHandlerUtil {
    
    /**
     * Read the file and return a handle {@link InputStream} to this file.
     * If the file is not found in the specific directory or in the classpath, then
     * this API will return <code>null</code>.
     * 
     * @param filename
     * @return InputStream
     * @throws FileNotFoundException 
     */
    public static InputStream stream(final String filename) throws FileNotFoundException {
        // File input stream for the file to be read
        InputStream in = null;

        File file = new File(filename);
        if (file.exists()) {
            in = new FileInputStream(file);
        }
        else {
            in = FileHandlerUtil.class.getClassLoader().getResourceAsStream(filename);
            if (in != null) {

            }
            else {
                URL url = Thread.currentThread().getContextClassLoader().getResource(filename);
                if (url != null) {
                    String urlFile = url.getFile();
                    urlFile = urlFile.replaceAll("%20", " ");
                    file = new File(urlFile);
                    if (! file.exists()) {
                        // Read using loader
                        in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
                    }
                    else {
                        in = new FileInputStream(new File(urlFile));
                    }
                }
            }
        }
        return in;
    }
    
    /**
     * Read the content of a file in a byte array.
     * 
     * @param filename
     * @return byte[]
     * @throws IOException 
     */
    public static byte[] read(final String filename) throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream(8192);
        byte[] buff = new byte[8192];
        int read = -1;
        
        try (InputStream in = stream(filename)) {
            if (in != null) {
                while ((read = in.read(buff)) != -1) {
                    bOut.write(buff, 0, read);
                }
            }
            bOut.close();
        };
        return bOut.toByteArray();
    }
    
    /**
     * Write the content to the file.
     * If the file is already present, it will override the file.
     * 
     * @param filename
     * @param buff
     * @throws IOException 
     */
    public static void write(final String filename, byte[] buff) throws IOException {
        try (FileOutputStream out = new FileOutputStream(filename)) {
            out.write(buff);
        }
    }
}
