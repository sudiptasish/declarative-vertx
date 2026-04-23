package org.javalabs.decl.api.agent;

/**
 *
 * @author schan280
 */
public abstract class AgentJDI {
    
    protected AgentJDI() {}
    
    public abstract void debug(String host, String port);
}
