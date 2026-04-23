package org.javalabs.decl.workflow;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.javalabs.decl.util.DateUtil;

/**
 * Used as an argument for workflow engine.
 *
 * @author Sudiptasish Chanda
 */
public final class EngineArgs {
    
    public static final String DEFAULT_WF_CTX = "org.javalabs.decl.workflow.DefaultContext";
    
    private String workflowContext = DEFAULT_WF_CTX;
    private Date start;
    private String job;
    private String workflowChain;
    private boolean asyncChain = false;
    private boolean schedule = true;
    private Map<String, Object> baggages = new HashMap<>();
    
    public EngineArgs() {
        this.start = DateUtil.currentUTCDate();
    }

    public EngineArgs(String workflowChain
        , String workflowContext) {
        
        this.workflowChain = workflowChain;
        this.workflowContext = workflowContext;
        this.start = DateUtil.currentUTCDate();
    }

    public String getWorkflowChain() {
        return workflowChain;
    }

    public void setWorkflowChain(String workflowChain) {
        this.workflowChain = workflowChain;
    }

    public String getWorkflowContext() {
        return workflowContext;
    }

    public void setWorkflowContext(String workflowContext) {
        this.workflowContext = workflowContext;
    }

    public boolean isAsyncChain() {
        return asyncChain;
    }

    public void setAsyncChain(boolean asyncChain) {
        this.asyncChain = asyncChain;
    }

    public boolean shouldSchedule() {
        return schedule;
    }

    public void setSchedule(boolean schedule) {
        this.schedule = schedule;
    }

    /**
     * Return the job name for which this workflow chain is triggered.
     * @return String
     */
    
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
    public void addBaggage(String key, Object value) {
        baggages.put(key, value);
    }
    
    public Iterator<Map.Entry<String, Object>> baggages() {
        return baggages.entrySet().iterator();
    }

    public Date getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "[Chain: " + workflowChain + ". Context: " + workflowContext + ". Baggage(s): " + baggages + "]";
    }
}
