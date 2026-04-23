package org.javalabs.decl.workflow;

import java.util.Properties;

/**
 * A Context object represents the state information that is accessed and manipulated
 * by the execution of a workflow command.
 * 
 * <p>
 * In a workflow chain there are multiple commands that will be working towards
 * completing a workflow. The output of one command will be fed to the next command
 * in the chain. The {@link Context} object is the one which carries the contextual
 * info from one command to the subsequent command in the chain.
 *
 * @author Sudiptasish Chanda
 */
public interface Context {
    
    /**
     * Current execution id.
     * @return String
     */
    String executionId();
    
    /**
     * Return the name of the workflow chain currently being executed.
     * @return Chain
     */
    Chain currentChain();

    /**
     * If a command fails, then the workflow engine may decide to rollback the
     * entire flow (only if the flow is transactional).
     * 
     * If backtracking is enabled, then the entire transaction can be rolled back.
     * 
     * @return Boolean
     */
    Boolean isBacktrackingEnabled();
    
    void addCtxMessaage(String message);
    
    String message();
    
    /**
     * Workflow configuration.
     * @return JsonObject
     */
    Properties workflowConfig();
    
    /**
     * If a command as part of it's execution wants to add some contextual info,
     * then it can make use of this api.
     * Because the context object is passed from one commaand to other, therefore
     * the output/state of one command can be fed as an input to subsequent command
     * in the chain.
     * 
     * @param key   Context key
     * @param value COntext value.
     */
    void add(String key, Object value);
    
    /**
     * Return the context data for this given key.
     * 
     * @param key       Key whocse value to be retrieved.
     * @return Object
     */
    Object get(String key);
    
    /**
     * Remove and return the context object.
     * @param key
     * @return Object
     */
    Object remove(String key);
    
    /**
     * Check if this context is still valid.
     * A context can be marked as invalid, once a chain is terminated.
     * 
     * @return Boolean
     */
    Boolean isValid();
    
    /**
     * Indicate whether this context is being used in an async workflow.
     * @return Boolean
     */
    Boolean isAsync();
    
    /**
     * Clone this context object.
     * @return  The cloned object.
     */
    Context cloneIt();
}
