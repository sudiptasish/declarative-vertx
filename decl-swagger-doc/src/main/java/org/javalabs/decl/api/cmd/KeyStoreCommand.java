package org.javalabs.decl.api.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.security.auth.x500.X500Principal;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.util.ConsoleWriter;
import org.javalabs.decl.workflow.Command;
import static org.javalabs.decl.workflow.Command.CONTINUE;
import org.javalabs.decl.workflow.Context;

/**
 *
 * @author schan280
 */
public class KeyStoreCommand implements Command {
    
    private final String name;
    private final Executor executor = Executors.newFixedThreadPool(1);
    
    public KeyStoreCommand(String name) {
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
            String keyStoreFile = projectRoot.getAbsolutePath()
                    + File.separator
                    + project.srcResourceDir()
                    + File.separator
                    + project.keyStore();
            
            if (Boolean.TRUE) {
                generateCmdLine(project, keyStoreFile);
            }
            
            if (project.verbose() <= 2) {
                ConsoleWriter.timingPrintln("Generated key store: " + ConsoleWriter.ANSI_GREEN + keyStoreFile + ConsoleWriter.ANSI_RESET);
            }
            return CompletableFuture.completedFuture(CONTINUE);
        }
        catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
    
    private void generateCmdLine(Project project, String keyStoreFile) throws Exception {
        String template = "keytool -genkey -alias RS256 -keyalg RSA -sigalg SHA256withRSA -dname \"CN=REST Test, OU=EA, O=American Express, L=Kolkata, ST=WB, C=IN\" -keystore {0} -keysize 2048 -validity {1} -storepass {2}";
        String cmd = MessageFormat.format(template, keyStoreFile, project.validityDays(), project.storePass());
        
        String[] commands = {
            "/bin/bash",
            "-c",
            cmd
        };
        
        ProcessBuilder pb = new ProcessBuilder()
            .directory(new File(System.getProperty("user.dir")))
            .command(commands)
            .redirectErrorStream(true);
        
        Process process = pb.start();   // Start the process
        
        StreamReader reader = new StreamReader(project, process.getInputStream());
        executor.execute(reader);
        
        Boolean exited = process.waitFor(1, TimeUnit.MINUTES);
        if (! exited) {
            throw new RuntimeException("Unable to generate key store file");
        }
    }
    
    private void generateManually(Project project, String keyStoreFile) throws Exception {
        File projectRoot = new File(project.dir(), project.name());

        // Initialize KeyPairGenerator for RSA algorithm
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        // Initialize with a key size of 2048 bits and a SecureRandom instance
        SecureRandom secureRandom = new SecureRandom();
        keyPairGenerator.initialize(2048, secureRandom);

        // Generate the KeyPair (containing public and private keys)
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get the Public Key
        PublicKey publicKey = keyPair.getPublic();
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());

        // Get the Private Key
        PrivateKey privateKey = keyPair.getPrivate();
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        KeyStore ks = KeyStore.getInstance("PKCS12");
        char[] pwdArray = "secret".toCharArray();
        ks.load(null, pwdArray);

        Principal principal = new X500Principal("CN=Vertx REST"
                + ", OU=EA"
                + ", O=American Express"
                + ", L=Bangalore"
                + ", ST=Karnataka"
                + ", C=IN");

        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        Certificate cert = factory.generateCertificate(null);
        
        // TODO: Find out how to generate the certificate.
    }

    private class StreamReader implements Runnable {
        private final Project project;
        private final InputStream in;
        private final List<String> lines = new ArrayList<>();
        
        StreamReader(Project project, InputStream in) {
            this.project = project;
            this.in = in;
        }

        @Override
        public void run() {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(in));

                for (String line = br.readLine(); line != null
                        && !Thread.currentThread().isInterrupted();
                     line = br.readLine()) {

                    lines.add(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                stop();
            }
            if (project.verbose() <= 1) {
                ConsoleWriter.println("Sub-Process log:\n" + String.join("\n", lines.toArray(new String[lines.size()])));
            }
        }

        void stop() {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void backtrack(Context ctx) {
        // Do Nothing
    }
}
