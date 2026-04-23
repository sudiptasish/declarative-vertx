package org.javalabs.decl.api.agent;

import java.lang.instrument.Instrumentation;

/**
 *
 * @author schan280
 */
public interface Startup {
    
    /**
     * 
     * @param _inst
     * @param args 
     */
    void start(Instrumentation _inst, String[] args);
}
