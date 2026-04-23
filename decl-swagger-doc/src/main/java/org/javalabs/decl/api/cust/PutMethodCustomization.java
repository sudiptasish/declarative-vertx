package org.javalabs.decl.api.cust;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.gen.CodeGenSupport;
import org.javalabs.decl.gen.JavaClass;
import org.javalabs.decl.gen.JavaVariable;
import org.javalabs.decl.util.CharUtil;

/**
 * Customization layer for a put api call.
 *
 * @author schan280
 */
public class PutMethodCustomization extends AbstractCustomization {
    
    private static final String THROW_TEMPLATE = "throw new {0}({1})";
    
    public PutMethodCustomization() {}
    
    @Override
    public Result handlerEntry(Project project, JavaClass model) {
        final StringBuilder buff = new StringBuilder(256);
        
        try {
            JavaVariable idVar = null;
            String idSetter = "";
            for (JavaVariable jVar : model.variables()) {
                if (jVar.idField()) {
                    idVar = jVar;
                    idSetter = "set" + Character.toUpperCase(jVar.name().charAt(0)) + jVar.name().substring(1);
                    break;
                }
            }
            if (idVar != null) {
                buff.append(CharUtil.toCamelCase(model.name()))
                        .append(".")
                        .append(idSetter)
                        .append("(")
                        .append(idVar.type() == String.class ? "id" : (idVar.type().getSimpleName() + ".valueOf(id)"))
                        .append(")")
                        .append(CodeGenSupport.SEMICOLON)
                        .append(CodeGenSupport.NEW_LINE);
            }
            return new Result(buff.toString());
        }
        finally {
            buff.delete(0, buff.length());
        }
    }
    
    @Override
    public Result boEntry(Project project, JavaClass model) {
        final StringBuilder buff = new StringBuilder(256);
        
        try {
            // Find the method for the primary key.
            String idGetter = "";
            for (JavaVariable jVar : model.variables()) {
                if (jVar.idField()) {
                    idGetter = "get" + Character.toUpperCase(jVar.name().charAt(0)) + jVar.name().substring(1);
                    break;
                }
            }
            // Employee existing = employeeDAO.find(new Employee.EmployeePK(employee.getEmployeeId()));
            buff.append(model.name())
                    .append(CodeGenSupport.SPACE)
                    .append("existing")
                    .append(CodeGenSupport.SPACE)
                    .append(CodeGenSupport.EQUALS)
                    .append(CodeGenSupport.SPACE)
                    .append(CharUtil.toCamelCase(model.name())).append("DAO")
                    .append(".")
                    .append("find")
                    .append("(")
                    .append("new")
                    .append(CodeGenSupport.SPACE)
                    .append(model.name())
                    .append(".")
                    .append(model.name()).append("PK")
                    .append("(")
                    .append(CharUtil.toCamelCase(model.name()))
                    .append(".")
                    .append(idGetter)
                    .append("()")
                    .append(")")
                    .append(")")
                    .append(CodeGenSupport.SEMICOLON)
                    .append(CodeGenSupport.NEW_LINE);

            //  if (existing == null) {
            //      throw new IllegalArgumentException("No employee found for id: " + employee.getEmployeeId());
            //  }
            String errMsg = new StringBuilder(50)
                    .append("\"")
                    .append("No")
                    .append(CodeGenSupport.SPACE)
                    .append(CharUtil.toCamelCase(model.name()))
                    .append(CodeGenSupport.SPACE)
                    .append("found")
                    .append(CodeGenSupport.SPACE)
                    .append("for")
                    .append(CodeGenSupport.SPACE)
                    .append("identifier")
                    .append(CodeGenSupport.COLON)
                    .append(CodeGenSupport.SPACE)
                    .append("\"")
                    .append(CodeGenSupport.SPACE)
                    .append("+")
                    .append(CodeGenSupport.SPACE)
                    .append(CharUtil.toCamelCase(model.name()))
                    .append(".")
                    .append(idGetter)
                    .append("()")
                    .toString();

            buff.append(CodeGenSupport.TAB)
                    .append(CodeGenSupport.TAB)
                    .append("if")
                    .append(CodeGenSupport.SPACE)
                    .append("(")
                    .append("existing")
                    .append(CodeGenSupport.SPACE)
                    .append(CodeGenSupport.EQUALS)
                    .append(CodeGenSupport.EQUALS)
                    .append(CodeGenSupport.SPACE)
                    .append(CodeGenSupport.NULL)
                    .append(")")
                    .append(CodeGenSupport.SPACE)
                    .append("{")
                    .append(CodeGenSupport.NEW_LINE)
                    .append(CodeGenSupport.TAB)
                    .append(CodeGenSupport.TAB)
                    .append(CodeGenSupport.TAB)
                    .append(MessageFormat.format(THROW_TEMPLATE, "IllegalArgumentException", errMsg))   // Alternate: java.util.NoSuchElementException
                    .append(CodeGenSupport.SEMICOLON)
                    .append(CodeGenSupport.NEW_LINE)
                    .append(CodeGenSupport.TAB)
                    .append(CodeGenSupport.TAB)
                    .append("}")
                    .append(CodeGenSupport.NEW_LINE);

            // Update attributes of existing record
            buff.append(CodeGenSupport.TAB)
                    .append(CodeGenSupport.TAB)
                    .append("// Update attributes of existing record")
                    .append(CodeGenSupport.NEW_LINE);

            JavaVariable lastUpdateVar = null;
            for (JavaVariable jVar : model.variables()) {
                if (jVar.idField()) {
                    // Primary key field cannot be updated.
                    continue;
                }
                if ((jVar.type() == Date.class || jVar.type() == java.sql.Date.class || jVar.type() == Timestamp.class || jVar.type() == Time.class)
                    && (jVar.name().toLowerCase().contains("update") || jVar.name().toLowerCase().contains("last"))) {

                    // Last updated date will be updated separately by taking the current sys timestamp.
                    lastUpdateVar = jVar;
                    continue;
                }
                if ((jVar.type() == Date.class || jVar.type() == java.sql.Date.class || jVar.type() == Timestamp.class || jVar.type() == Time.class)
                    && (jVar.name().toLowerCase().contains("create"))) {

                    // Created date should not be updated again !
                    continue;
                }
                String setter = "set" + Character.toUpperCase(jVar.name().charAt(0)) + jVar.name().substring(1);
                String getter = "get" + Character.toUpperCase(jVar.name().charAt(0)) + jVar.name().substring(1);

                // existing.setLocation(employee.getLocation());
                // existing.setSalary(employee.getSalary());
                // etc ...
                buff.append(CodeGenSupport.TAB)
                        .append(CodeGenSupport.TAB)
                        .append("existing")
                        .append(".")
                        .append(setter)
                        .append("(")
                        .append(CharUtil.toCamelCase(model.name()))
                        .append(".")
                        .append(getter)
                        .append("()")
                        .append(")")
                        .append(CodeGenSupport.SEMICOLON)
                        .append(CodeGenSupport.NEW_LINE);
            }
            // Finally, update the last updated timestamp.
            if (lastUpdateVar != null) {
                // existing.setUpdatedDate(new Timestamp(DateUtil.currentUTCDate().getTime()));
                String updMethod = "set" + Character.toUpperCase(lastUpdateVar.name().charAt(0)) + lastUpdateVar.name().substring(1);
                String dateTimeApi = "DateUtil.currentUTCDate()";
                if (lastUpdateVar.type() == Timestamp.class) {
                    dateTimeApi = "new Timestamp(DateUtil.currentUTCDate().getTime())";
                }
                if (lastUpdateVar.type() == Date.class) {
                    buff.append(CodeGenSupport.TAB)
                            .append(CodeGenSupport.TAB)
                            .append("existing")
                            .append(".")
                            .append(updMethod)
                            .append("(")
                            .append(dateTimeApi)
                            .append(")")
                            .append(CodeGenSupport.SEMICOLON)
                            .append(CodeGenSupport.NEW_LINE);
                }
            }
            return new Result(buff.toString());
        }
        finally {
            buff.delete(0, buff.length());
        }
    }

    @Override
    public Result entry(Project project) {
        final StringBuilder buff = new StringBuilder(256);
        
        try {
            // Employee element = Json.decodeValue(ctx.body().buffer(), Employee.class);
            // buff.append("\n\t\t\t")
            //         .append(project.resource()).append(" ").append("element")
            //         .append(" = ")
            //         .append("Json.decodeValue")
            //         .append("(")
            //             .append("ctx.body().buffer()").append(", ")
            //             .append(project.resource()).append(".class")
            //         .append(")")
            //         .append(";");
            
            // Employee current = store.get(id);
            buff.append("\n\n\t\t\t").append("// Fetch the existing employee from the in-memory store.");
            buff.append("\n\t\t\t")
                    .append(project.inputResource().resource()).append(" ").append("current").append(" = ").append("store.get(id)")
                    .append(";");
            
            // if (current == null) {
            //     throw new NoSuchElementException("No element found for id: " + id);
            // }
            buff.append("\n\t\t\t")
                    .append("if ").append("(").append("current").append(" == ").append("null").append(")").append("{")
                    .append("\n\t\t\t\t").append("throw new NoSuchElementException(\"No element found for id: \" + id)").append(";")
                    .append("\n\t\t\t")
                    .append("}");
            
            // Update all attributes.
            // current.setName(element.getName());
            // current.setLocation(element.getLocation());
            // current.setSalary(element.getSalary());
            buff.append("\n\t\t\t").append("// Update all attributes.");
            for (JavaVariable var : updatableFields(project.model())) {
                buff.append("\n\t\t\t").append("current").append(".").append(setter(var.name()))
                        .append("(").append("element").append(".").append(getter(var.name())).append("()").append(")").append(";");
            }
            // current.setUpdatedOn(new Date());
            buff.append("\n\t\t\t").append("current").append(".").append(updatedOnSetter(project.model()))
                        .append("(").append("new Date()").append(")").append(";");
            
            // Map<String, String> msg = new HashMap<>();
            // msg.put("code", "employee_modified");
            // msg.put("message", "{RESOURCE} modified successfully");
            // return msg;
            buff.append("\n\n\t\t\t").append("Map<String, String> msg = new HashMap<>()").append(";");
            buff.append("\n\t\t\t").append("msg.put(\"code\", \"").append(project.inputResource().resource().toLowerCase()).append("_modified\")").append(";");
            buff.append("\n\t\t\t").append("msg.put(\"message\", \"").append(project.inputResource().resource()).append(" modified successfully\")").append(";");
            buff.append("\n\t\t\t").append("return msg").append(";");
            
            return new Result(buff.toString());
        }
        finally {
            buff.delete(0, buff.length());
        }
    }

    @Override
    public Result exit(Project project) {
        // Do Nothing.
        return null;
    }
    
}
