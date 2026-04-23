package org.javalabs.decl.api.model;

/**
 *
 * @author schan280
 */
public class Reference {
    
    private String $ref;
    
    public Reference() {}

    public Reference(String $ref) {
        this.$ref = $ref;
    }

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
    }
}
