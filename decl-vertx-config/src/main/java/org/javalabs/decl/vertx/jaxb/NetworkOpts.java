package org.javalabs.decl.vertx.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="send-buffer-size" type="{http://www.w3.org/2001/XMLSchema}Integer"/&gt;
 *         &lt;element name="receive-buffer-size" type="{http://www.w3.org/2001/XMLSchema}Integer"/&gt;
 *         &lt;element name="reuse-address" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="traffic-class" type="{http://www.w3.org/2001/XMLSchema}Integer"/&gt;
 *         &lt;element name="log-activity" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="reuse-port" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
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
    "sendBufferSize",
    "receiveBufferSize",
    "reuseAddress",
    "trafficClass",
    "logActivity",
    "reusePort"
})
public class NetworkOpts {

    @XmlElement(name = "send-buffer-size", defaultValue = "-1")
    protected Integer sendBufferSize;
    
    @XmlElement(name = "receive-buffer-size", defaultValue = "-1")
    protected Integer receiveBufferSize;
    
    @XmlElement(name = "reuse-address", defaultValue = "true")
    protected Boolean reuseAddress;
    
    @XmlElement(name = "traffic-class", defaultValue = "-1")
    protected Integer trafficClass;
    
    @XmlElement(name = "log-activity", defaultValue = "false")
    protected Boolean logActivity;
    
    @XmlElement(name = "reuse-port", defaultValue = "false")
    protected Boolean reusePort;

    /**
     * Gets the value of the sendBufferSize property.
     *
     */
    public Integer getSendBufferSize() {
        return sendBufferSize;
    }

    /**
     * Sets the value of the sendBufferSize property.
     *
     */
    public void setSendBufferSize(Integer value) {
        this.sendBufferSize = value;
    }

    /**
     * Gets the value of the receiveBufferSize property.
     *
     */
    public Integer getReceiveBufferSize() {
        return receiveBufferSize;
    }

    /**
     * Sets the value of the receiveBufferSize property.
     *
     */
    public void setReceiveBufferSize(Integer value) {
        this.receiveBufferSize = value;
    }

    /**
     * Gets the value of the reuseAddress property.
     *
     */
    public Boolean isReuseAddress() {
        return reuseAddress;
    }

    /**
     * Sets the value of the reuseAddress property.
     *
     */
    public void setReuseAddress(Boolean value) {
        this.reuseAddress = value;
    }

    /**
     * Gets the value of the trafficClass property.
     *
     */
    public Integer getTrafficClass() {
        return trafficClass;
    }

    /**
     * Sets the value of the trafficClass property.
     *
     */
    public void setTrafficClass(Integer value) {
        this.trafficClass = value;
    }

    /**
     * Gets the value of the logActivity property.
     *
     */
    public Boolean isLogActivity() {
        return logActivity;
    }

    /**
     * Sets the value of the logActivity property.
     *
     */
    public void setLogActivity(Boolean value) {
        this.logActivity = value;
    }

    /**
     * Gets the value of the reusePort property.
     *
     */
    public Boolean isReusePort() {
        return reusePort;
    }

    /**
     * Sets the value of the reusePort property.
     *
     */
    public void setReusePort(Boolean value) {
        this.reusePort = value;
    }

}
