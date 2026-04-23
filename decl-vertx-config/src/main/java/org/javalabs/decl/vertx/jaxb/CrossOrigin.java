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
 *         &lt;element name="allowedHeader" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
    "allowedHeaders",
    "allowedMethods"
})
public class CrossOrigin {
    
    @XmlElement(name = "allowed-headers")
    protected AllowedHeaders allowedHeaders;
    
    @XmlElement(name = "allowed-methods")
    protected AllowedMethods allowedMethods;

    /**
     * Gets the value of the allowedHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link AllowedHeaders }
     *     
     */
    public AllowedHeaders getAllowedHeaders() {
        return allowedHeaders;
    }

    /**
     * Sets the value of the allowedHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedHeaders }
     *     
     */
    public void setAllowedHeaders(AllowedHeaders value) {
        this.allowedHeaders = value;
    }

    /**
     * Gets the value of the allowedMethods property.
     * 
     * @return
     *     possible object is
     *     {@link AllowedMethods }
     *     
     */
    public AllowedMethods getAllowedMethods() {
        return allowedMethods;
    }

    /**
     * Sets the value of the allowedMethods property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedMethods }
     *     
     */
    public void setAllowedMethods(AllowedMethods value) {
        this.allowedMethods = value;
    }

}
