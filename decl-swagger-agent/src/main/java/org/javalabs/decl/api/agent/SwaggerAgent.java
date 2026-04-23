package org.javalabs.decl.api.agent;

/**
 * Swagger agent.
 *
 * @author schan280
 */
public abstract class SwaggerAgent {
    
    public abstract void crawl(String packageName, String outputFile);
}
