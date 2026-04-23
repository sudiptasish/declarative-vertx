package org.javalabs.decl.vertx.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="uri" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="method" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="api" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="consume" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="produce" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="produces" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="admin" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Mapping {

    @XmlAttribute(name = "uri", required = true)
    protected String uri;
    
    @XmlAttribute(name = "method", required = true)
    protected String method;
    
    @XmlAttribute(name = "api", required = true)
    protected String api;
    
    @XmlAttribute(name = "consume")
    protected String consume;
    
    @XmlAttribute(name = "produce")
    protected String produce;
    
    @XmlAttribute(name = "produces")
    protected String produces;
    
    @XmlAttribute(name = "admin")
    protected Boolean admin;
    
    @XmlAttribute(name = "schema", required = true)
    protected String schema;

    /**
     * Gets the value of the uri property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the method property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Gets the value of the api property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getApi() {
        return api;
    }

    /**
     * Sets the value of the api property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setApi(String value) {
        this.api = value;
    }

    /**
     * Gets the value of the consume property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getConsume() {
        return consume;
    }

    /**
     * Sets the value of the consume property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setConsume(String value) {
        this.consume = value;
    }

    /**
     * Gets the value of the produce property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getProduce() {
        return produce;
    }

    /**
     * Sets the value of the produce property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setProduce(String value) {
        this.produce = value;
    }

    /**
     * Gets the value of the produces property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getProduces() {
        return produces;
    }

    /**
     * Sets the value of the produces property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setProduces(String value) {
        this.produces = value;
    }

    /**
     * Gets the value of the admin property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isAdmin() {
        return admin;
    }

    /**
     * Sets the value of the admin property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setAdmin(Boolean value) {
        this.admin = value;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

}
