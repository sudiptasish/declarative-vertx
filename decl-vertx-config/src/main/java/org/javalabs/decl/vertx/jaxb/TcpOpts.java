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
 *         &lt;element name="tcp-no-delay" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="tcp-keep-alive" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="so-linger" type="{http://www.w3.org/2001/XMLSchema}Integer"/&gt;
 *         &lt;element name="idle-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="read-idle-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="write-idle-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="ssl" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="tcp-fast-open" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="tcp-cork" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="tcp-quick-ack" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="tcp-user-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;xs:element name="ssl-opts" minOccurs="0" maxOccurs="1"&gt;
 *           &lt;xs:complexType&gt;
 *             &lt;xs:sequence&gt;
 *               &lt;xs:element name="ssl-handshake-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *               &lt;xs:element name="key-cert-options" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;xs:element name="trust-options" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;xs:element name="enabled-cipher-suites" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;xs:element name="crl-paths" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;xs:element name="crl-values" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;xs:element name="use-alpn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *               &lt;xs:element name="enabled-secure-transport-protocols" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *             &lt;/xs:sequence&gt;
 *           &lt;/xs:complexType&gt;
 *         &lt;/xs:element&gt;
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
    "tcpNoDelay",
    "tcpKeepAlive",
    "soLinger",
    "idleTimeout",
    "readIdleTimeout",
    "writeIdleTimeout",
    "ssl",
    "tcpFastOpen",
    "tcpCork",
    "tcpQuickAck",
    "tcpUserTimeout",
    "sslOpts"
})
public class TcpOpts {

    @XmlElement(name = "tcp-no-delay", defaultValue = "true")
    protected Boolean tcpNoDelay;
    
    @XmlElement(name = "tcp-keep-alive", defaultValue = "false")
    protected Boolean tcpKeepAlive;
    
    @XmlElement(name = "so-linger", defaultValue = "-1")
    protected Integer soLinger;
    
    @XmlElement(name = "idle-timeout", defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected Integer idleTimeout;
    
    @XmlElement(name = "read-idle-timeout", defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected Integer readIdleTimeout;
    
    @XmlElement(name = "write-idle-timeout", defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected Integer writeIdleTimeout;
    
    @XmlElement(name = "ssl", defaultValue = "false")
    protected Boolean ssl;
    
    @XmlElement(name = "tcp-fast-open", defaultValue = "false")
    protected Boolean tcpFastOpen;
    
    @XmlElement(name = "tcp-cork", defaultValue = "false")
    protected Boolean tcpCork;
    
    @XmlElement(name = "tcp-quick-ack", defaultValue = "false")
    protected Boolean tcpQuickAck;
    
    @XmlElement(name = "tcp-user-timeout", defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected Integer tcpUserTimeout;
    
    @XmlElement(name = "ssl-opts")
    protected SslOpts sslOpts;

    /**
     * Gets the value of the tcpNoDelay property.
     *
     */
    public Boolean isTcpNoDelay() {
        return tcpNoDelay;
    }

    /**
     * Sets the value of the tcpNoDelay property.
     *
     */
    public void setTcpNoDelay(Boolean value) {
        this.tcpNoDelay = value;
    }

    /**
     * Gets the value of the tcpKeepAlive property.
     *
     */
    public Boolean isTcpKeepAlive() {
        return tcpKeepAlive;
    }

    /**
     * Sets the value of the tcpKeepAlive property.
     *
     */
    public void setTcpKeepAlive(Boolean value) {
        this.tcpKeepAlive = value;
    }

    /**
     * Gets the value of the soLinger property.
     *
     */
    public Integer getSoLinger() {
        return soLinger;
    }

    /**
     * Sets the value of the soLinger property.
     *
     */
    public void setSoLinger(Integer value) {
        this.soLinger = value;
    }

    /**
     * Gets the value of the idleTimeout property.
     *
     */
    public Integer getIdleTimeout() {
        return idleTimeout;
    }

    /**
     * Sets the value of the idleTimeout property.
     *
     */
    public void setIdleTimeout(Integer value) {
        this.idleTimeout = value;
    }

    /**
     * Gets the value of the readIdleTimeout property.
     *
     */
    public Integer getReadIdleTimeout() {
        return readIdleTimeout;
    }

    /**
     * Sets the value of the readIdleTimeout property.
     *
     */
    public void setReadIdleTimeout(Integer value) {
        this.readIdleTimeout = value;
    }

    /**
     * Gets the value of the writeIdleTimeout property.
     *
     */
    public Integer getWriteIdleTimeout() {
        return writeIdleTimeout;
    }

    /**
     * Sets the value of the writeIdleTimeout property.
     *
     */
    public void setWriteIdleTimeout(Integer value) {
        this.writeIdleTimeout = value;
    }

    /**
     * 
     * @return 
     */
    public Boolean isSsl() {
        return ssl;
    }

    /**
     * 
     * @param value 
     */
    public void setSsl(Boolean value) {
        this.ssl = value;
    }

    /**
     * Gets the value of the tcpFastOpen property.
     *
     */
    public Boolean isTcpFastOpen() {
        return tcpFastOpen;
    }

    /**
     * Sets the value of the tcpFastOpen property.
     *
     */
    public void setTcpFastOpen(Boolean value) {
        this.tcpFastOpen = value;
    }

    /**
     * Gets the value of the tcpCork property.
     *
     */
    public Boolean isTcpCork() {
        return tcpCork;
    }

    /**
     * Sets the value of the tcpCork property.
     *
     */
    public void setTcpCork(Boolean value) {
        this.tcpCork = value;
    }

    /**
     * Gets the value of the tcpQuickAck property.
     *
     */
    public Boolean isTcpQuickAck() {
        return tcpQuickAck;
    }

    /**
     * Sets the value of the tcpQuickAck property.
     *
     */
    public void setTcpQuickAck(Boolean value) {
        this.tcpQuickAck = value;
    }

    /**
     * Gets the value of the tcpUserTimeout property.
     *
     */
    public Integer getTcpUserTimeout() {
        return tcpUserTimeout;
    }

    /**
     * Sets the value of the tcpUserTimeout property.
     *
     */
    public void setTcpUserTimeout(Integer value) {
        this.tcpUserTimeout = value;
    }

    public SslOpts getSslOpts() {
        return sslOpts;
    }

    public void setSslOpts(SslOpts sslOpts) {
        this.sslOpts = sslOpts;
    }

}
