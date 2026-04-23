package org.javalabs.decl.vertx.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="worker" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="threading-model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isolation-group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ha" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="extra-classpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="instances" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="worker-pool-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="worker-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/&gt;
 *         &lt;element name="max-worker-execute-time" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "worker",
    "threadingModel",
    "isolationGroup",
    "ha",
    "extraClasspath",
    "instances",
    "workerPoolName",
    "workerPoolSize",
    "maxWorkerExecuteTime",
})
public class DeployOptions {

    @XmlElement(name = "worker", defaultValue = "false")
    protected Boolean worker;
    
    @XmlElement(name = "threading-model", defaultValue = "EVENT_LOOP")
    protected String threadingModel;
    
    @XmlElement(name = "isolation-group")
    protected String isolationGroup;
    
    @XmlElement(name = "ha", defaultValue = "false")
    protected Boolean ha;
    
    @XmlElement(name = "extra-classpath")
    protected String extraClasspath;
    
    @XmlElement(name = "instances", defaultValue = "1")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer instances;
    
    @XmlElement(name = "worker-pool-name")
    protected String workerPoolName;
    
    @XmlElement(name = "worker-pool-size", defaultValue = "20")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer workerPoolSize;
    
    @XmlElement(name = "max-worker-execute-time", defaultValue = "60000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxWorkerExecuteTime;

    /**
     * Gets the value of the worker property.
     *
     */
    public Boolean isWorker() {
        return worker;
    }

    /**
     * Sets the value of the worker property.
     *
     */
    public void setWorker(Boolean value) {
        this.worker = value;
    }

    /**
     * Gets the value of the threadingModel property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getThreadingModel() {
        return threadingModel;
    }

    /**
     * Sets the value of the threadingModel property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setThreadingModel(String value) {
        this.threadingModel = value;
    }

    /**
     * Gets the value of the isolationGroup property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getIsolationGroup() {
        return isolationGroup;
    }

    /**
     * Sets the value of the isolationGroup property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setIsolationGroup(String value) {
        this.isolationGroup = value;
    }

    /**
     * Gets the value of the ha property.
     *
     * @return 
     */
    public Boolean isHa() {
        return ha;
    }

    /**
     * Sets the value of the ha property.
     *
     * @param value
     */
    public void setHa(Boolean value) {
        this.ha = value;
    }

    /**
     * Gets the value of the extraClasspath property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getExtraClasspath() {
        return extraClasspath;
    }

    /**
     * Sets the value of the extraClasspath property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setExtraClasspath(String value) {
        this.extraClasspath = value;
    }

    /**
     * Gets the value of the instances property.
     *
     * @return Integer
     */
    public Integer getInstances() {
        return instances;
    }

    /**
     * Sets the value of the instances property.
     *
     * @param value
     */
    public void setInstances(Integer value) {
        this.instances = value;
    }

    /**
     * Gets the value of the workerPoolName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getWorkerPoolName() {
        return workerPoolName;
    }

    /**
     * Sets the value of the workerPoolName property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setWorkerPoolName(String value) {
        this.workerPoolName = value;
    }

    /**
     * Gets the value of the workerPoolSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getWorkerPoolSize() {
        return workerPoolSize;
    }

    /**
     * Sets the value of the workerPoolSize property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setWorkerPoolSize(Integer value) {
        this.workerPoolSize = value;
    }

    /**
     * Gets the value of the maxWorkerExecuteTime property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxWorkerExecuteTime() {
        return maxWorkerExecuteTime;
    }

    /**
     * Sets the value of the maxWorkerExecuteTime property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxWorkerExecuteTime(Integer value) {
        this.maxWorkerExecuteTime = value;
    }

}
