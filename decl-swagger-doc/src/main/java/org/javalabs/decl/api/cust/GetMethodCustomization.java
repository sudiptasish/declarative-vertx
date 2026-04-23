package org.javalabs.decl.api.cust;

import org.javalabs.decl.api.project.Project;
import org.javalabs.decl.gen.CodeGenSupport;
import org.javalabs.decl.gen.JavaClass;
import org.javalabs.decl.gen.JavaVariable;
import org.javalabs.decl.util.CharUtil;

/**
 * Customization layer for a get api call.
 *
 * @author schan280
 */
public class GetMethodCustomization extends AbstractCustomization {
    
    public GetMethodCustomization() {}
    
    @Override
    public Result handlerEntry(Project project, JavaClass model) {
        final StringBuilder buff = new StringBuilder(256);
        
        try {
            JavaVariable idVar = null;
            for (JavaVariable jVar : model.variables()) {
                if (jVar.idField()) {
                    idVar = jVar;
                    break;
                }
            }
            if (idVar != null) {
                // Employee employee = employeeBO.view(user(ctx), Integer.valueOf(id));
                buff.append(model.name())
                        .append(CodeGenSupport.SPACE)
                        .append(CharUtil.toCamelCase(model.name()))
                        .append(CodeGenSupport.SPACE)
                        .append(CodeGenSupport.EQUALS)
                        .append(CodeGenSupport.SPACE)
                        .append(CharUtil.toCamelCase(model.name()))
                        .append("BO")
                        .append(".")
                        .append("view")
                        .append("(")
                        .append("user(ctx)")
                        .append(CodeGenSupport.COMMA)
                        .append(CodeGenSupport.SPACE)
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
        return new Result(buff.toString());
    }

    @Override
    public Result entry(Project project) {
        final StringBuilder buff = new StringBuilder(256);
        
        try {
            // Employee current = store.get(id);
            buff.append("// Fetch the existing employee from the in-memory store.");
            buff.append("\n\t\t\t")
                    .append(project.inputResource().resource()).append(" ").append("element").append(" = ").append("store.get(id)")
                    .append(";");
            
            // if (current == null) {
            //     throw new NoSuchElementException("No element found for id: " + id);
            // }
            buff.append("\n\t\t\t")
                    .append("if ").append("(").append("element").append(" == ").append("null").append(")").append("{")
                    .append("\n\t\t\t\t").append("throw new NoSuchElementException(\"No element found for id: \" + id)").append(";")
                    .append("\n\t\t\t")
                    .append("}");
            
            // return current;
            buff.append("\n\t\t\t").append("return element").append(";");
            
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
