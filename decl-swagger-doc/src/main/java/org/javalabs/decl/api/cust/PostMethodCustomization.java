package org.javalabs.decl.api.cust;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;
import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.gen.CodeGenSupport;
import org.javalabs.decl.gen.JavaAnnotation;
import org.javalabs.decl.gen.JavaClass;
import org.javalabs.decl.gen.JavaVariable;
import org.javalabs.decl.util.CharUtil;

/**
 * Customization layer for a post api call.
 *
 * @author schan280
 */
public class PostMethodCustomization extends AbstractCustomization {

    private static final String THROW_TEMPLATE = "throw new {0}({1})";

    public PostMethodCustomization() {
    }

    @Override
    public Result handlerEntry(Project project, JavaClass model) {
        final StringBuilder buff = new StringBuilder(256);
        return new Result(buff.toString());
    }
    
    @Override
    public Result boEntry(Project project, JavaClass model) {
        final StringBuilder buff = new StringBuilder(256);
        
        try {
            JavaVariable idVar = null;
            JavaVariable createDateVar = null;

            for (JavaVariable jVar : model.variables()) {
                if (jVar.idField()) {
                    // Primary key field cannot be updated.
                    idVar = jVar;
                } else if ((jVar.type() == Date.class || jVar.type() == java.sql.Date.class || jVar.type() == Timestamp.class || jVar.type() == Time.class)
                        && (jVar.name().toLowerCase().contains("create"))) {

                    // Created date will be updated separately by taking the current sys timestamp.
                    createDateVar = jVar;
                    break;
                }
            }
            String nextTab = "";
            if (idVar != null) {
                String idGetter = "get" + Character.toUpperCase(idVar.name().charAt(0)) + idVar.name().substring(1);
                // if (employee.getEmployeeId() != null) {
                //     throw new IllegalArgumentException("Should not specify id. It is auto-generated");
                // }
                for (JavaAnnotation jAnn : idVar.annotations()) {
                    if (jAnn.type().getName().equals("jakarta.persistence.GeneratedValue")) {
                        String errMsg = new StringBuilder(50)
                                .append("\"")
                                .append("Should not specify id. It is auto-generated")
                                .append("\"")
                                .toString();

                        nextTab = CodeGenSupport.TAB.concat(CodeGenSupport.TAB);
                        buff.append("if")
                                .append(CodeGenSupport.SPACE)
                                .append("(")
                                .append(CharUtil.toCamelCase(model.name()))
                                .append(".")
                                .append(idGetter)
                                .append("()")
                                .append(CodeGenSupport.SPACE)
                                .append(CodeGenSupport.NOT)
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
                                .append(MessageFormat.format(THROW_TEMPLATE, "IllegalArgumentException", errMsg)) // Alternate: java.util.NoSuchElementException
                                .append(CodeGenSupport.SEMICOLON)
                                .append(CodeGenSupport.NEW_LINE)
                                .append(CodeGenSupport.TAB)
                                .append(CodeGenSupport.TAB)
                                .append("}")
                                .append(CodeGenSupport.NEW_LINE);
                    }
                }
            }
            // if (employee.getCreatedDate() == null) {
            //     employee.setCreatedDate(new Timestamp(DateUtil.currentUTCDate().getTime()));
            // }
            if (createDateVar != null) {
                String setter = "set" + Character.toUpperCase(createDateVar.name().charAt(0)) + createDateVar.name().substring(1);
                String getter = "get" + Character.toUpperCase(createDateVar.name().charAt(0)) + createDateVar.name().substring(1);

                String dateTimeApi = "DateUtil.currentUTCDate()";
                if (createDateVar.type() == Timestamp.class) {
                    dateTimeApi = "new Timestamp(DateUtil.currentUTCDate().getTime())";
                }

                buff.append(nextTab)
                        .append(CodeGenSupport.TAB)
                        .append(CodeGenSupport.TAB)
                        .append("if")
                        .append(CodeGenSupport.SPACE)
                        .append("(")
                        .append(CharUtil.toCamelCase(model.name()))
                        .append(".")
                        .append(getter)
                        .append("()")
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
                        .append(CharUtil.toCamelCase(model.name()))
                        .append(".")
                        .append(setter)
                        .append("(")
                        .append(dateTimeApi)
                        .append(")")
                        .append(CodeGenSupport.SEMICOLON)
                        .append(CodeGenSupport.NEW_LINE)
                        .append(CodeGenSupport.TAB)
                        .append(CodeGenSupport.TAB)
                        .append("}")
                        .append(CodeGenSupport.NEW_LINE);
            }
            return new Result(buff.toString());
        } finally {
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

            JavaVariable var = idField(project.model());
            String getter = getter(var.name());

            // if (element.getId() != null) {
            //     throw new IllegalArgumentException("Should not specify id. It is auto-generated");
            // }
            buff.append("\n\t\t\t")
                    .append("if ").append("(").append("element").append(".").append(getter).append("()")
                    .append(" != ").append("null").append(")").append("{")
                    .append("\n\t\t\t\t").append("throw new IllegalArgumentException(\"Should not specify id. It is auto-generated\")").append(";")
                    .append("\n\t\t\t").append("}");

            String setter = setter(var.name());

            // element.setId(COUNTER.incrementAndGet());
            buff.append("\n\t\t\t")
                    .append("element").append(".").append(setter)
                    .append("(")
                    .append(var.type() == String.class ? "String.valueOf(" : "")
                    .append("COUNTER.incrementAndGet()")
                    .append(var.type() == String.class ? ")" : "")
                    .append(")")
                    .append(";");

            // element.setCreatedOn(new Date());
            String cg = createdOnSetter(project.model());
            if (cg != null) {
                buff.append("\n\t\t\t")
                        .append("element").append(".").append(cg).append("(")
                        .append("new Date()")
                        .append(")")
                        .append(";");
            }

            // store.put(element.getId(), element);
            buff.append("\n\n\t\t\t").append("// Keep it in the in-memory store.");
            buff.append("\n\t\t\t")
                    .append("store.put").append("(")
                    .append(Number.class.isAssignableFrom(var.type()) ? "String.valueOf(" : "")
                    .append("element").append(".").append(getter).append("()")
                    .append(Number.class.isAssignableFrom(var.type()) ? ")" : "")
                    .append(", ")
                    .append("element")
                    .append(")")
                    .append(";");

            // element.setCanonicalLink(ctx.normalizedPath() + "/" + element.getId());
            buff.append("\n\n\t\t\t").append("// Add the canonical link.");
            buff.append("\n\t\t\t")
                    .append("element.setCanonicalLink").append("(")
                    .append("\"api/v1\"").append(" + \"/\" + ").append("\"").append(project.inputResource().resource().toLowerCase()).append("s\"")
                    .append(" + ").append("\"/\"")
                    .append(" + ").append("element").append(".").append(getter).append("()")
                    .append(")")
                    .append(";");

            // return element;
            buff.append("\n\t\t\t").append("return element").append(";");
            return new Result(buff.toString());
        } finally {
            buff.delete(0, buff.length());
        }
    }

    @Override
    public Result exit(Project project) {
        // Do Nothing.
        return null;
    }

}
