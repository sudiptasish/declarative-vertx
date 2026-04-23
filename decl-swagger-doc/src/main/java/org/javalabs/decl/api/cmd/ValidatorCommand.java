package org.javalabs.decl.api.cmd;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.javalabs.decl.api.project.DataType;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.util.ConsoleWriter;
import org.javalabs.decl.workflow.Command;
import static org.javalabs.decl.workflow.Command.CONTINUE;
import org.javalabs.decl.workflow.Context;

/**
 * Command to validate the input.
 *
 * @author schan280
 */
public class ValidatorCommand implements Command {
    
    private final String name;
    
    public ValidatorCommand(String name) {
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
            if (project.unparsedResource() != null && project.unparsedResource().trim().length() > 0) {
                validate(project.unparsedResource());
            }
            if (project.verbose() <= 2) {
                ConsoleWriter.println("Validation complete");
            }
            return CompletableFuture.completedFuture(CONTINUE);
        }
        catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
    
    private void validate(String resource) {
        int startIdx = resource.indexOf("(");
        int endIdx = resource.indexOf(")");
        
        if (startIdx > 0) {
            if (endIdx == resource.length() - 1) {
                String parts = resource.substring(startIdx, endIdx);
                String[] fields = parts.split(",");
                for (int i = 0; i < fields.length; i ++) {
                    fields[i] = fields[i].trim();
                    String[] tmp = fields[i].split("#");
                    
                    if (tmp.length > 2) {
                        throw new IllegalArgumentException("Invalid syntax. Data type must be specified like name::str");
                    }
                    if (tmp.length == 2) {
                        try {
                            DataType dtype = Enum.valueOf(DataType.class, tmp[1].toUpperCase());
                        }
                        catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Invalid data type " + tmp[1]
                                + ". Supported types are: " + Arrays.toString(DataType.values()));
                        }
                    }
                }
            }
            else {
                throw new IllegalArgumentException("Syntax error."
                        + " Try \"project -c -d /tmp -n example-rest -r Employee(name, location, salary#float)\"");
            }
        }
        else {
            if (startIdx == 0) {
                throw new IllegalArgumentException("Syntax error."
                        + " Try \"project -c -d /tmp -n example-rest -r Employee(name, location, salary#float)\"");
            }
            else {
                if (endIdx != -1) {
                    throw new IllegalArgumentException("Syntax error."
                            + " Try \"project -c -d /tmp -n example-rest -r Employee(name, location, salary#float)\"");
                }
                // No parenthesis
                // Use the default set of fields.
            }
        }
    }

    @Override
    public void backtrack(Context ctx) {
        // Do Nothing
    }
}
