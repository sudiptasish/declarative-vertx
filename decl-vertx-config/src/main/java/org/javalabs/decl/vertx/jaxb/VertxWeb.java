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
 *         &lt;element name="context-listener" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="context-params"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="eventloop-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="worker-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="blocked-thread-check-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-event-loop-execute-time" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-worker-execute-time" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="internal-blocking-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="cluster-manager" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="ha-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="quorum-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="ha-group" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="file-system-options"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="class-path-resolving-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="file-caching-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="file-cache-dir" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="metrics-options"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="factory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tracing-options"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="factory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="warning-exception-time" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="prefer-native-transport" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="disable-tccl" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="use-daemon-thread" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="event-bus-options"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="cluster-public-host" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="cluster-public-port" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                             &lt;element name="cluster-ping-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                             &lt;element name="cluster-ping-reply-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                             &lt;element name="accept-backlog" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                             &lt;element name="reconnect-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                             &lt;element name="reconnect-attempts" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                             &lt;element name="connect-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                             &lt;element name="trust-all" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="log-activity" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="address-resolver-options"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="search-domains" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="dns-server" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="error-handler" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="metric-class" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="verticles"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="verticle" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="worker" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="threading-model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="isolation-group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="ha" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="extra-classpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="instances" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                             &lt;element name="worker-pool-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="worker-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/&gt;
 *                             &lt;element name="max-worker-execute-time" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/&gt;
 *                             &lt;element name="config" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "contextListener",
    "contextParams",
    "verticles"
})
@XmlRootElement(name = "vertx-web")
public class VertxWeb {

    @XmlElement(name = "context-listener", required = true)
    protected Object contextListener;
    
    @XmlElement(name = "context-params", required = true)
    protected ContextParams contextParams;
    
    @XmlElement(name = "verticles", required = true)
    protected Verticles verticles;

    /**
     * Gets the value of the contextListener property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getContextListener() {
        return contextListener;
    }

    /**
     * Sets the value of the contextListener property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setContextListener(Object value) {
        this.contextListener = value;
    }

    /**
     * Gets the value of the contextParams property.
     * 
     * @return
     *     possible object is
     *     {@link ContextParams }
     *     
     */
    public ContextParams getContextParams() {
        return contextParams;
    }

    /**
     * Sets the value of the contextParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextParams }
     *     
     */
    public void setContextParams(ContextParams value) {
        this.contextParams = value;
    }

    /**
     * Gets the value of the verticles property.
     * 
     * @return
     *     possible object is
     *     {@link Verticles }
     *     
     */
    public Verticles getVerticles() {
        return verticles;
    }

    /**
     * Sets the value of the verticles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Verticles }
     *     
     */
    public void setVerticles(Verticles value) {
        this.verticles = value;
    }

}
