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
 *         &lt;element name="log-format" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="route" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "logFormat",
    "route"
})
public class AccessLog {

    @XmlElement(name = "log-format", required = true)
    protected String logFormat;
    
    @XmlElement(required = true)
    protected String route;

    /**
     * Gets the value of the logFormat property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * Sets the value of the logFormat property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setLogFormat(String value) {
        this.logFormat = value;
    }

    /**
     * Gets the value of the route property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRoute(String value) {
        this.route = value;
    }

}
