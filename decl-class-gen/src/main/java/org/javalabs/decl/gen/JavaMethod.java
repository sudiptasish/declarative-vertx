package org.javalabs.decl.gen;

import org.javalabs.decl.visitor.ClassVisitor;
import org.javalabs.decl.visitor.Element;

/**
 * Representation of a java method.
 * 
 * <p>
 * A java method contains the following attributes:
 * <ul>
 *   <li>Access specifier</li>
 *   <li>Static access specifier</li>
 *   <li>Return type</li>
 *   <li>Method name</li>
 *   <li>Argument types</li>
 *   <li>Argument names</li>
 *   <li>Exception list</li>
 *   <li>Method body</li>
 * </ul>
 *
 * @author schan280
 */
public class JavaMethod implements CodeGenSupport, Element {
    
    private final JavaClass jClass;
    
    private String accessSpecifier = "public";
    private Boolean isStatic = Boolean.FALSE;
    private String returnType = "void";
    private String name;
    private String[] argNames;
    private Class<?>[] argTypes;
    private Throwable[] errors;
    private String body;

    private JavaAnnotation[] anns;
    
    public JavaMethod(JavaClass jClass) {
        this.jClass = jClass;
    }
    
    public JavaMethod accessSpecifier(String accessSpecifier) {
        this.accessSpecifier = accessSpecifier;
        return this;
    }
    
    public JavaMethod isStatic(Boolean isStatic) {
        this.isStatic = isStatic;
        return this;
    }

    public JavaMethod returnType(String returnType) {
        this.returnType = returnType;
        return this;
    }

    public JavaMethod name(String name) {
        this.name = name;
        return this;
    }

    public JavaMethod annotations(JavaAnnotation... anns) {
        this.anns = anns;
        return this;
    }

    public JavaMethod argTypes(Class... args) {
        this.argTypes = args;
        return this;
    }

    public JavaMethod argNames(String... args) {
        this.argNames = args;
        return this;
    }
    
    public JavaMethod errors(Throwable... errors) {
        this.errors = errors;
        return this;
    }

    public JavaMethod body(String body) {
        this.body = body;
        return this;
    }
    
    @Override
    public String snippet() {
        StringBuilder buff = new StringBuilder(512);
        
        if (anns != null) {
            for (JavaAnnotation ann : anns) {
                buff.append(jClass.decorator().methodIndent())
                        .append(ann.snippet())
                        .append(NEW_LINE);
            }
        }
        buff.append(jClass.decorator().methodIndent())
                .append(accessSpecifier)
                .append(SPACE)
                .append(isStatic ? "static " : "")
                .append(returnType)
                .append(SPACE)
                .append(name);
        
        if (argTypes == null) {
            buff.append("()");
        }
        else {
            buff.append("(");
            for (int i = 0; i < argTypes.length; i ++) {
                Class<?> argType = argTypes[i];
                String argName = argNames[i];
                
                if (argName == null) {
                    String tmp = argType.getSimpleName();
                    char ch = Character.toLowerCase(tmp.charAt(0));
                    argName = ch + tmp.substring(1);
                }
                buff.append(argType.getSimpleName())
                        .append(SPACE)
                        .append(argName);
                
                if (i < argTypes.length - 1) {
                    buff.append(COMMA).append(SPACE);
                }
            }
            buff.append(")");
        }
        if (errors != null) {
            buff.append("throws").append(SPACE);
            for (int i = 0; i < errors.length; i ++) {
                buff.append(errors[i]);
                if (i < errors.length - 1) {
                    buff.append(COMMA).append(SPACE);
                }
            }
        }
        buff.append(SPACE).append("{");
        if (body != null) {
            buff.append(NEW_LINE);
            buff.append(body);
            buff.append(NEW_LINE);
        }
        buff.append(jClass.decorator().methodIndent()).append("}");
        
        return buff.toString();
    }
    
    public static JavaMethod setter(JavaClass jClass, JavaVariable jVar) {
        String setter = "set" + Character.toUpperCase(jVar.name().charAt(0)) + jVar.name().substring(1);
        
        JavaMethod jMethod = new JavaMethod(jClass);
        jMethod.accessSpecifier(PUBLIC)
                .returnType(VOID)
                .name(setter)
                .argTypes(jVar.type())
                .argNames(jVar.name())
                .body(jClass.decorator().bodyIndent()
                        .concat("this")
                        .concat(".")
                        .concat(jVar.name())
                        .concat(SPACE)
                        .concat("=")
                        .concat(SPACE)
                        .concat(jVar.name())
                        .concat(SEMICOLON));
        
        return jMethod;
    }
    
    public static JavaMethod getter(JavaClass jClass, JavaVariable jVar) {
        String getter = "get" + Character.toUpperCase(jVar.name().charAt(0)) + jVar.name().substring(1);
        
        JavaMethod jMethod = new JavaMethod(jClass);
        jMethod.accessSpecifier(PUBLIC)
                .returnType(jVar.type().getSimpleName())
                .name(getter)
                .body(jClass.decorator().bodyIndent()
                        .concat("return")
                        .concat(SPACE)
                        .concat("this")
                        .concat(".")
                        .concat(jVar.name())
                        .concat(SEMICOLON));
        
        return jMethod;
    }

    @Override
    public void accept(ClassVisitor visitor) {
        visitor.visit(this);
    }
}
