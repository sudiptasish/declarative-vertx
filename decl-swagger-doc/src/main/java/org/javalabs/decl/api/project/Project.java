package org.javalabs.decl.api.project;

import java.io.File;
import java.util.List;
import java.util.Properties;
import org.javalabs.decl.gen.JavaClass;

/**
 * The project class that encapsulates the attributes/hints to setup a workspace.
 *
 * @author schan280
 */
public class Project {
    
    private Boolean e2e = Boolean.FALSE; 
    private String name;
    private String dir = System.getProperty("user.dir");
    
    private Platform platform = Platform.JAVA;
    private TechStack stack = TechStack.VERTX;
    private BuildTool buildTool = BuildTool.MAVEN;
    
    // 2: Level two logging (print only summary)
    // 1: Level one logging (print class file and config file along with summary)
    private Integer verbose = 2;        // Default: Level 2 logging 

    private String srcDir = "src/main/java";
    private String srcResourceDir = "src/main/resources";
    private String testDir = "src/test/java";
    private String testResourceDir = "src/test/resources";
    private String targetDir = "target";
    private String generated = "generated";
    
    private String basePkg = "io.opns.app";
    private String corePkg = basePkg + "." + "core";
    private String utilPkg = basePkg + "." + "util";
    private String handlerPkg = basePkg + "." + "handler";
    private String boPkg = basePkg + "." + "bo";
    private String daoPkg = basePkg + "." + "dao";
    private String modelPkg = basePkg + "." + "model";
    private String authPkg = basePkg + "." + "auth";
    private String configPkg = basePkg + "." + "config";
    private String mainPkg = basePkg + "." + "main";
    
    private String docDir = "docs";
    private String dbDir = srcResourceDir + File.separator + "db";
    
    private final Properties dbProps = new Properties();
    
    private String keyStore = "server.pkcs";
    private String storePass = "secret";
    private Integer validityDays = 360;
    
    private String unparsedResource;
    private InputResource inputResource;
    
    private JavaClass model;
    
    public String name() {
        return name;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }
    
    public Boolean e2e() {
        return e2e;
    }

    public Project e2e(Boolean e2e) {
        this.e2e = e2e;
        return this;
    }

    public String dir() {
        return dir;
    }

    public Project dir(String dir) {
        this.dir = dir;
        return this;
    }

    public Platform platform() {
        return platform;
    }

    public Project platform(Platform platform) {
        this.platform = platform;
        return this;
    }

    public TechStack stack() {
        return stack;
    }

    public Project stack(TechStack stack) {
        this.stack = stack;
        return this;
    }

    public BuildTool buildTool() {
        return buildTool;
    }

    public Project buildTool(BuildTool buildTool) {
        this.buildTool = buildTool;
        return this;
    }

    public Integer verbose() {
        return verbose;
    }

    public Project verbose(Integer verbose) {
        this.verbose = verbose;
        return this;
    }

    public String srcDir() {
        return srcDir;
    }

    public Project srcDir(String srcDir) {
        this.srcDir = srcDir;
        return this;
    }

    public String srcResourceDir() {
        return srcResourceDir;
    }

    public Project srcResourceDir(String srcResourceDir) {
        this.srcResourceDir = srcResourceDir;
        return this;
    }

    public String testDir() {
        return testDir;
    }

    public Project testDir(String testDir) {
        this.testDir = testDir;
        return this;
    }

    public String testResourceDir() {
        return testResourceDir;
    }

    public Project testResourceDir(String testResourceDir) {
        this.testResourceDir = testResourceDir;
        return this;
    }

    public String targetDir() {
        return targetDir;
    }

    public Project targetDir(String targetDir) {
        this.targetDir = targetDir;
        return this;
    }

    public String generated() {
        return generated;
    }

    public void generated(String generated) {
        this.generated = generated;
    }

    public String basePkg() {
        return basePkg;
    }

    public Project basePkg(String basePkg) {
        this.basePkg = basePkg;
        return this;
    }

    public String handlerPkg() {
        return handlerPkg;
    }

    public Project handlerPkg(String handlerPkg) {
        this.handlerPkg = handlerPkg;
        return this;
    }

    public String utilPkg() {
        return utilPkg;
    }

    public Project utilPkg(String utilPkg) {
        this.utilPkg = utilPkg;
        return this;
    }

    public String boPkg() {
        return boPkg;
    }

    public Project boPkg(String boPkg) {
        this.boPkg = boPkg;
        return this;
    }

    public String daoPkg() {
        return daoPkg;
    }

    public Project daoPkg(String daoPkg) {
        this.daoPkg = daoPkg;
        return this;
    }

    public String modelPkg() {
        return modelPkg;
    }

    public Project modelPkg(String modelPkg) {
        this.modelPkg = modelPkg;
        return this;
    }

    public String authPkg() {
        return authPkg;
    }

    public Project authPkg(String authPkg) {
        this.authPkg = authPkg;
        return this;
    }

    public String configPkg() {
        return configPkg;
    }

    public Project configPkg(String configPkg) {
        this.configPkg = configPkg;
        return this;
    }

    public String corePkg() {
        return corePkg;
    }

    public Project corePkg(String corePkg) {
        this.corePkg = corePkg;
        return this;
    }

    public String mainPkg() {
        return mainPkg;
    }

    public Project mainPkg(String mainPkg) {
        this.mainPkg = mainPkg;
        return this;
    }

    public String unparsedResource() {
        return unparsedResource;
    }

    public Project unparsedResource(String unparsedResource) {
        this.unparsedResource = unparsedResource;
        return this;
    }

    public JavaClass model() {
        return model;
    }

    public void model(JavaClass model) {
        this.model = model;
    }

    public String docDir() {
        return docDir;
    }

    public void docDir(String docDir) {
        this.docDir = docDir;
    }

    public String dbDir() {
        return dbDir;
    }

    public void dbDir(String dbDir) {
        this.dbDir = dbDir;
    }

    public String keyStore() {
        return keyStore;
    }

    public void keyStore(String keyStore) {
        this.keyStore = keyStore;
    }

    public String storePass() {
        return storePass;
    }

    public void storePass(String storePass) {
        this.storePass = storePass;
    }

    public Integer validityDays() {
        return validityDays;
    }

    public void validityDays(Integer validityDays) {
        this.validityDays = validityDays;
    }
    
    public void addDbProps(String key, String val) {
        dbProps.setProperty(key, val);
    }
    
    public String dbProps(String key, String defaultVal) {
        return dbProps.getProperty(key, defaultVal);
    }

    public InputResource inputResource() {
        return inputResource;
    }

    public void inputResource(InputResource inputResource) {
        this.inputResource = inputResource;
    }
    
    public static class InputResource {
        
        private String table;
        private String resource;
        private List<String> fields;
        private List<Class<?>> dateTypes;
        
        public String table() {
            return table;
        }

        public InputResource table(String table) {
            this.table = table;
            return this;
        }

        public String resource() {
            return resource;
        }

        public InputResource resource(String resource) {
            this.resource = resource;
            return this;
        }

        public List<String> fields() {
            return fields;
        }

        public InputResource fields(List<String> fields) {
            this.fields = fields;
            return this;
        }

        public List<Class<?>> dateTypes() {
            return dateTypes;
        }

        public InputResource dateTypes(List<Class<?>> dateTypes) {
            this.dateTypes = dateTypes;
            return this;
        }
        
    }
}
