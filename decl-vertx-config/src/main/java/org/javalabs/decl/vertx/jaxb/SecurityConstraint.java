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
 *         &lt;element name="auth-handler" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;xs:element name="jwt-opts" minOccurs="0" maxOccurs="1"&gt;
 *           &lt;xs:complexType&gt;
 *             &lt;xs:sequence&gt;
 *               &lt;xs:element name="algorithm" type="xs:string" minOccurs="0" maxOccurs="1"/&gt;
 *               &lt;xs:element name="issuer" type="xs:string" minOccurs="0" maxOccurs="1"/&gt;
 *               &lt;xs:element name="audience" type="xs:string" minOccurs="0" maxOccurs="1"/&gt;
 *               &lt;xs:element name="expiry" type="xs:unsignedInt" minOccurs="0" maxOccurs="1"/&gt;
 *             &lt;/xs:sequence&gt;
 *           &lt;/xs:complexType&gt;
 *         &lt;/xs:element&gt;
 *         &lt;element name="auth-constraint"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="auth-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="url-patterns"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="url-pattern" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
    "authHandler",
    "jwtOpts",
    "authConstraint"
})
public class SecurityConstraint {

    @XmlElement(name = "auth-handler", required = true)
    protected String authHandler;

    @XmlElement(name = "jwt-opts", required = false)
    protected JwtOpts jwtOpts;
    
    @XmlElement(name = "auth-constraint", required = true)
    protected AuthConstraint authConstraint;

    /**
     * Gets the value of the authHandler property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getAuthHandler() {
        return authHandler;
    }

    /**
     * Sets the value of the authHandler property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setAuthHandler(String value) {
        this.authHandler = value;
    }

    /**
     * Gets the jwt options properties.
     * 
     * @return JwtOpts
     */
    public JwtOpts getJwtOpts() {
        return jwtOpts;
    }

    /**
     * Set the value of jwtOpts property.
     * 
     * @param jwtOpts 
     */
    public void setJwtOpts(JwtOpts jwtOpts) {
        this.jwtOpts = jwtOpts;
    }

    /**
     * Gets the value of the authConstraint property.
     *
     * @return possible object is {@link AuthConstraint }
     *
     */
    public AuthConstraint getAuthConstraint() {
        return authConstraint;
    }

    /**
     * Sets the value of the authConstraint property.
     *
     * @param value allowed object is {@link AuthConstraint }
     *
     */
    public void setAuthConstraint(AuthConstraint value) {
        this.authConstraint = value;
    }
}
