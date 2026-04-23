package org.javalabs.decl.api.main;

import org.javalabs.decl.api.project.BuildTool;
import org.javalabs.decl.api.project.Platform;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.api.project.ProjectTemplate;
import org.javalabs.decl.api.project.TechStack;
import java.util.Arrays;
import java.util.List;

/**
 * Project workspace executor.
 *
 * @author schan280
 */
public class ProjectExecutor implements ExecutorBase {
    
    private final String name = "project";
    private final String description = "Generate sample vert.x project with api documentation";
    private final List<String> longOptions = Arrays.asList("--create", "--platform", "--tech-stack", "--build-tool", "--dir", "--name", "--resource", "--verbose", "--e2e", "--jpa");
    private final List<String> shortOptions = Arrays.asList("-c", "-p", "-t", "-b", "-d", "-n", "-r", "-v", "-a", "-j");
    
    public ProjectExecutor() {}

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }
    
    @Override
    public void start(String[] options) throws Exception {
        Project project = prepare(options);
        
        ProjectTemplate template = ProjectTemplate.get(project);
        Boolean status = template.setup(project);
        
        if (status) {
            // Do Something later
        }
    }
    
    private Project prepare(String[] options) {
        Boolean create = Boolean.FALSE;
        Integer verbose = 2;
        Boolean e2e = Boolean.FALSE;
        Platform platform = Platform.JAVA;
        TechStack stack = TechStack.VERTX;
        BuildTool tool = BuildTool.MAVEN;
        
        String dir = "./";
        String name = "example-rest";
        String resource = null;
        
        for (int i = 0; i < options.length; i ++) {
            if (options[i].equals("-c") || options[i].equals("--create")) {
                create = Boolean.TRUE;
            }
            else if (options[i].equals("-p") || options[i].equals("--platform")) {
                try {
                    verifyArg(options[i], options[i + 1]);
                    platform = Enum.valueOf(Platform.class, options[i + 1].toUpperCase());
                }
                catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid platform " + options[i + 1]
                            + ". Valid values are: " + Arrays.toString(Platform.values()));
                }
            }
            else if (options[i].equals("-t") || options[i].equals("--tech-stack")) {
                try {
                    verifyArg(options[i], options[i + 1]);
                    stack = Enum.valueOf(TechStack.class, options[i + 1].toUpperCase());
                }
                catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid tech-stack " + options[i + 1]
                            + ". Valid values are: " + Arrays.toString(TechStack.values()));
                }
            }
            else if (options[i].equals("-b") || options[i].equals("--build-tool")) {
                try {
                    verifyArg(options[i], options[i + 1]);
                    tool = Enum.valueOf(BuildTool.class, options[i + 1].toUpperCase());
                }
                catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid build-tool " + options[i + 1]
                            + ". Valid values are: " + Arrays.toString(BuildTool.values()));
                }
            }
            else if (options[i].equals("-d") || options[i].equals("--dir")) {
                verifyArg(options[i], options[i + 1]);
                dir = options[i + 1];
            }
            else if (options[i].equals("-n") || options[i].equals("--name")) {
                verifyArg(options[i], options[i + 1]);
                name = options[i + 1];
            }
            else if (options[i].equals("-r") || options[i].equals("--resource")) {
                String rTmp = options[i + 1];
                if (rTmp.contains("(") && ! rTmp.endsWith(")")) {
                    // Take all string entries until we encounter )
                    for (int k = i + 2; ; k ++) {
                        rTmp += options[k];
                        if (options[k].endsWith(")")) {
                            // Found the end
                            i = k;
                            break;
                        }
                    }
                }
                else {
                    verifyArg(options[i], rTmp);
                }
                resource = rTmp;
            }
            else if (options[i].equals("-v") || options[i].equals("--verbose")) {
                verifyArg(options[i], options[i + 1]);
                verbose = Integer.valueOf(options[i + 1]);
            }
            else if (options[i].equals("-a") || options[i].equals("--e2e")) {
                e2e = Boolean.TRUE;
            }
        }
        if (! create) {
            throw new IllegalArgumentException("Did you miss the -c [--create] flag?");
        }
        if (!e2e && resource == null) {
            throw new IllegalArgumentException("Must provide the resource name [E.g., Employee, Bank, Student, etc]");
        }
        // Make resource captilaized.
        if (resource != null && Character.isLowerCase(resource.charAt(0))) {
            resource = Character.toUpperCase(resource.charAt(0)) + resource.substring(1);
        }
        return new Project()
                .e2e(e2e)
                .dir(dir)
                .name(name)
                .platform(platform)
                .stack(stack)
                .buildTool(tool)
                .verbose(verbose)
                .unparsedResource(resource);
    }
    
    private void verifyArg(String param, String val) {
        if (longOptions.contains(val) || shortOptions.contains(val)) {
            throw new IllegalArgumentException("Missing value for option [" + param + "]");
        }
    }
}
