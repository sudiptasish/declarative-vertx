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
 *         &lt;element name="auth-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="url-patterns"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="url-pattern" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
    "authType",
    "urlPatterns"
})
public class AuthConstraint {

    @XmlElement(name = "auth-type", required = true)
    protected String authType;
    
    @XmlElement(name = "url-patterns", required = true)
    protected UrlPatterns urlPatterns;

    /**
     * Gets the value of the authType property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * Sets the value of the authType property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setAuthType(String value) {
        this.authType = value;
    }

    /**
     * Gets the value of the urlPatterns property.
     *
     * @return possible object is {@link UrlPatterns }
     *
     */
    public UrlPatterns getUrlPatterns() {
        return urlPatterns;
    }

    /**
     * Sets the value of the urlPatterns property.
     *
     * @param value allowed object is {@link UrlPatterns }
     *
     */
    public void setUrlPatterns(UrlPatterns value) {
        this.urlPatterns = value;
    }

}
