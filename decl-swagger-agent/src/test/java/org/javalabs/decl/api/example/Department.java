package org.javalabs.decl.api.example;

/**
 *
 * @author schan280
 */
public class Department {
    
    private Integer deptId;
    private String name;
    private Boolean active;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
