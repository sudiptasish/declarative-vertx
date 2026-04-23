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
 *         &lt;element name="cluster-public-host" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cluster-public-port" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="cluster-ping-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="cluster-ping-reply-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="accept-backlog" type="{http://www.w3.org/2001/XMLSchema}Integer"/&gt;
 *         &lt;element name="reconnect-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="reconnect-attempts" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="connect-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="trust-all" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="log-activity" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
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
    "clusterPublicHost",
    "clusterPublicPort",
    "clusterPingInterval",
    "clusterPingReplyInterval",
    "acceptBacklog",
    "reconnectInterval",
    "reconnectAttempts",
    "connectTimeout",
    "trustAll",
    "logActivity"
})
public class EventBusOptions {

    @XmlElement(name = "cluster-public-host", required = true)
    protected String clusterPublicHost;
    
    @XmlElement(name = "cluster-public-port", defaultValue = "0")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer clusterPublicPort;
    
    @XmlElement(name = "cluster-ping-interval", defaultValue = "20000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer clusterPingInterval;
    
    @XmlElement(name = "cluster-ping-reply-interval", defaultValue = "20000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer clusterPingReplyInterval;
    
    @XmlElement(name = "accept-backlog", defaultValue = "-1")
    protected Integer acceptBacklog;
    
    @XmlElement(name = "reconnect-interval", defaultValue = "1000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer reconnectInterval;
    
    @XmlElement(name = "reconnect-attempts", defaultValue = "1")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer reconnectAttempts;
    
    @XmlElement(name = "connect-timeout", defaultValue = "60000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer connectTimeout;
    
    @XmlElement(name = "trust-all", defaultValue = "true")
    protected Boolean trustAll;
    
    @XmlElement(name = "log-activity", defaultValue = "false")
    protected Boolean logActivity;

    /**
     * Gets the value of the clusterPublicHost property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClusterPublicHost() {
        return clusterPublicHost;
    }

    /**
     * Sets the value of the clusterPublicHost property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClusterPublicHost(String value) {
        this.clusterPublicHost = value;
    }

    /**
     * Gets the value of the clusterPublicPort property.
     *
     * @return Integer
     *
     */
    public Integer getClusterPublicPort() {
        return clusterPublicPort;
    }

    /**
     * Sets the value of the clusterPublicPort property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setClusterPublicPort(Integer value) {
        this.clusterPublicPort = value;
    }

    /**
     * Gets the value of the clusterPingInterval property.
     *
     * @return Integer
     *
     */
    public Integer getClusterPingInterval() {
        return clusterPingInterval;
    }

    /**
     * Sets the value of the clusterPingInterval property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setClusterPingInterval(Integer value) {
        this.clusterPingInterval = value;
    }

    /**
     * Gets the value of the clusterPingReplyInterval property.
     *
     * @return Integer
     *
     */
    public Integer getClusterPingReplyInterval() {
        return clusterPingReplyInterval;
    }

    /**
     * Sets the value of the clusterPingReplyInterval property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setClusterPingReplyInterval(Integer value) {
        this.clusterPingReplyInterval = value;
    }

    /**
     * Gets the value of the acceptBacklog property.
     *
     * @return Integer
     *
     */
    public Integer getAcceptBacklog() {
        return acceptBacklog;
    }

    /**
     * Sets the value of the acceptBacklog property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setAcceptBacklog(Integer value) {
        this.acceptBacklog = value;
    }

    /**
     * Gets the value of the reconnectInterval property.
     *
     * @return Integer
     *
     */
    public Integer getReconnectInterval() {
        return reconnectInterval;
    }

    /**
     * Sets the value of the reconnectInterval property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setReconnectInterval(Integer value) {
        this.reconnectInterval = value;
    }

    /**
     * Gets the value of the reconnectAttempts property.
     *
     * @return Integer
     *
     */
    public Integer getReconnectAttempts() {
        return reconnectAttempts;
    }

    /**
     * Sets the value of the reconnectAttempts property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setReconnectAttempts(Integer value) {
        this.reconnectAttempts = value;
    }

    /**
     * Gets the value of the connectTimeout property.
     *
     * @return Integer
     *
     */
    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Sets the value of the connectTimeout property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setConnectTimeout(Integer value) {
        this.connectTimeout = value;
    }

    /**
     * Gets the value of the trustAll property.
     *
     * @return Boolean
     *
     */
    public Boolean isTrustAll() {
        return trustAll;
    }

    /**
     * Sets the value of the trustAll property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setTrustAll(Boolean value) {
        this.trustAll = value;
    }

    /**
     * Gets the value of the logActivity property.
     *
     * @return Boolean
     */
    public Boolean isLogActivity() {
        return logActivity;
    }

    /**
     * Sets the value of the logActivity property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setLogActivity(Boolean value) {
        this.logActivity = value;
    }

}
