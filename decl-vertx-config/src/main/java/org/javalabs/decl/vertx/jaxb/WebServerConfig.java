package org.javalabs.decl.vertx.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="server-opts"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ssl" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="accept-backlog" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                   &lt;element name="client-auth" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="sni" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="use-proxy-protocol" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="proxy-protocol-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="register-write-handler" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tcp-opts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tcp-no-delay" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="tcp-keep-alive" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="so-linger" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                   &lt;element name="idle-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                   &lt;element name="read-idle-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                   &lt;element name="write-idle-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                   &lt;element name="tcp-fast-open" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="tcp-cork" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="tcp-quick-ack" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="tcp-user-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="network-opts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="send-buffer-size" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="receive-buffer-size" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="reuse-address" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="traffic-class" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                   &lt;element name="log-activity" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="reuse-port" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="http-opts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="compression-supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="compression-level" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="max-web-socket-frame-size" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                   &lt;element name="max-web-socket-message-size" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                   &lt;element name="handle-100-continue-automatically" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="max-chunk-size" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                   &lt;element name="max-initial-line-length" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-header-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-form-attribute-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-form-fields" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-form-buffered-bytes" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="initial-settings"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="header-table-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                             &lt;element name="push-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="max-concurrent-streams" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                             &lt;element name="initial-window-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                             &lt;element name="max-frame-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                             &lt;element name="max-header-list-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="alpn-versions" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                   &lt;element name="http2-clear-text-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="http2-connection-window-size" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="decompression-supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="accept-unmasked-frames" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="decoder-initial-buffer-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="per-frame-web-socket-compression-supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="per-message-web-socket-compression-supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="web-socket-compression-level" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="web-socket-preferred-client-no-context" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="web-socket-allow-server-no-context" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="web-socket-closing-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="tracing-policy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="register-web-socket-write-handlers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="http2-rst-flood-max-rst-frame-per-window" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="http2-rst-flood-window-duration" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="allowed-headers" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="allowed-header" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="allowed-methods" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="allowed-method" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="keystore-config" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="store-name" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                   &lt;element name="store-password" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="truststore-config" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="store-name" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                   &lt;element name="store-password" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="context-root" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="access-log" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="log-format" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="route" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="security-constraint" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="auth-handler" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                   &lt;element name="auth-constraint"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="auth-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="url-patterns"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="url-pattern" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="routing-config" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "serverOpts",
    "tcpOpts",
    "networkOpts",
    "httpOpts",
    "crossOrigin",
    "keystoreConfig",
    "truststoreConfig",
    "contextRoot",
    "accessLog",
    "securityConstraint",
    "routingConfig"
})
@XmlRootElement(name = "server-config")
public class WebServerConfig {

    @XmlElement(name = "server-opts", required = true)
    protected ServerOpts serverOpts;
    
    @XmlElement(name = "tcp-opts")
    protected TcpOpts tcpOpts;
    
    @XmlElement(name = "network-opts")
    protected NetworkOpts networkOpts;
    
    @XmlElement(name = "http-opts")
    protected HttpOpts httpOpts;
    
    @XmlElement(name = "cross-origin")
    protected CrossOrigin crossOrigin;
    
    @XmlElement(name = "keystore-config")
    protected KeystoreConfig keystoreConfig;
    
    @XmlElement(name = "truststore-config")
    protected TruststoreConfig truststoreConfig;
    
    @XmlElement(name = "context-root", required = true)
    protected String contextRoot;
    
    @XmlElement(name = "access-log")
    protected AccessLog accessLog;
    
    @XmlElement(name = "security-constraint")
    protected SecurityConstraint securityConstraint;
    
    @XmlElement(name = "routing-config", required = true, defaultValue = "routing-config.xml")
    protected String routingConfig;

    /**
     * Gets the value of the serverOpts property.
     * 
     * @return
     *     possible object is
     *     {@link ServerOpts }
     *     
     */
    public ServerOpts getServerOpts() {
        return serverOpts;
    }

    /**
     * Sets the value of the serverOpts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServerOpts }
     *     
     */
    public void setServerOpts(ServerOpts value) {
        this.serverOpts = value;
    }

    /**
     * Gets the value of the tcpOpts property.
     * 
     * @return
     *     possible object is
     *     {@link TcpOpts }
     *     
     */
    public TcpOpts getTcpOpts() {
        return tcpOpts;
    }

    /**
     * Sets the value of the tcpOpts property.
     * 
     * @param value
     *     allowed object is
     *     {@link TcpOpts }
     *     
     */
    public void setTcpOpts(TcpOpts value) {
        this.tcpOpts = value;
    }

    /**
     * Gets the value of the networkOpts property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkOpts }
     *     
     */
    public NetworkOpts getNetworkOpts() {
        return networkOpts;
    }

    /**
     * Sets the value of the networkOpts property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkOpts }
     *     
     */
    public void setNetworkOpts(NetworkOpts value) {
        this.networkOpts = value;
    }

    /**
     * Gets the value of the httpOpts property.
     * 
     * @return
     *     possible object is
     *     {@link HttpOpts }
     *     
     */
    public HttpOpts getHttpOpts() {
        return httpOpts;
    }

    /**
     * Sets the value of the httpOpts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HttpOpts }
     *     
     */
    public void setHttpOpts(HttpOpts value) {
        this.httpOpts = value;
    }
    
    /**
     * Return the cross origin property.
     * @return CrossOrigin
     */
    public CrossOrigin getCrossOrigin() {
        return crossOrigin;
    }

    /**
     * Sets the cross origin property.
     * @param crossOrigin 
     */
    public void setCrossOrigin(CrossOrigin crossOrigin) {
        this.crossOrigin = crossOrigin;
    }

    /**
     * Gets the value of the keystoreConfig property.
     * 
     * @return
     *     possible object is
     *     {@link KeystoreConfig }
     *     
     */
    public KeystoreConfig getKeystoreConfig() {
        return keystoreConfig;
    }

    /**
     * Sets the value of the keystoreConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeystoreConfig }
     *     
     */
    public void setKeystoreConfig(KeystoreConfig value) {
        this.keystoreConfig = value;
    }

    /**
     * Gets the value of the truststoreConfig property.
     * 
     * @return
     *     possible object is
     *     {@link TruststoreConfig }
     *     
     */
    public TruststoreConfig getTruststoreConfig() {
        return truststoreConfig;
    }

    /**
     * Sets the value of the truststoreConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link TruststoreConfig }
     *     
     */
    public void setTruststoreConfig(TruststoreConfig value) {
        this.truststoreConfig = value;
    }

    /**
     * Gets the value of the contextRoot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextRoot() {
        return contextRoot;
    }

    /**
     * Sets the value of the contextRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextRoot(String value) {
        this.contextRoot = value;
    }

    /**
     * Gets the value of the accessLog property.
     * 
     * @return
     *     possible object is
     *     {@link AccessLog }
     *     
     */
    public AccessLog getAccessLog() {
        return accessLog;
    }

    /**
     * Sets the value of the accessLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessLog }
     *     
     */
    public void setAccessLog(AccessLog value) {
        this.accessLog = value;
    }

    /**
     * Gets the value of the securityConstraint property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityConstraint }
     *     
     */
    public SecurityConstraint getSecurityConstraint() {
        return securityConstraint;
    }

    /**
     * Sets the value of the securityConstraint property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityConstraint }
     *     
     */
    public void setSecurityConstraint(SecurityConstraint value) {
        this.securityConstraint = value;
    }

    /**
     * Gets the value of the routingConfig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutingConfig() {
        return routingConfig;
    }

    /**
     * Sets the value of the routingConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutingConfig(String value) {
        this.routingConfig = value;
    }

}
