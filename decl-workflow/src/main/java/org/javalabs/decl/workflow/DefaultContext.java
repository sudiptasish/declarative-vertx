package org.javalabs.decl.workflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

/**
 * Workflow context object.
 * 
 * It will be used by the command to put some contextual data, that might be
 * useful by the next command(s) on the chain.
 *
 * @author Sudiptasish Chanda
 */

public class DefaultContext implements Context, Cloneable {
    
    private final AbstractChain chain;
    
    private Map<String, Object> data = new HashMap<>();
    private String ctxMessage = "";
    private Boolean valid = true;
    private String execId;
    
    public DefaultContext(AbstractChain chain) {
        this.chain = chain;
        this.execId = UUID.randomUUID().toString();
    }

    @Override
    public Boolean isBacktrackingEnabled() {
        return Boolean.TRUE;
    }

    @Override
    public String message() {
        return ctxMessage;
    }

    @Override
    public void add(String key, Object value) {
        data.put(key, value);
    }

    @Override
    public Object get(String key) {
        return data.get(key);
    }

    @Override
    public Object remove(String key) {
        return data.remove(key);
    }
    
    public void setMessage(String ctxMessage) {
        this.ctxMessage = ctxMessage;
    }

    @Override
    public Boolean isValid() {
        return valid;
    }

    /**
     * Mark this context as invalid.
     */
    public void markInvalid() {
        valid = false;
    }

    @Override
    public Properties workflowConfig() {
        return new Properties();
    }

    @Override
    public void addCtxMessaage(String message) {
        this.ctxMessage = message;
    }

    @Override
    public Boolean isAsync() {
        return false;
    }

    @Override
    public Chain currentChain() {
        return chain;
    }

    @Override
    public String executionId() {
        return execId;
    }

    @Override
    public Context cloneIt() {
        try {
            DefaultContext ctx = (DefaultContext)super.clone();
            ctx.data = new HashMap<>(this.data);
            return ctx;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
