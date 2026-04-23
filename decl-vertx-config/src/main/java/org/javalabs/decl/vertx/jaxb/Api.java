package org.javalabs.decl.vertx.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

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
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="basePath" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="produce" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="consume" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Api {

    @XmlAttribute(name = "version", required = true)
    protected String version;
    
    @XmlAttribute(name = "basePath", required = true)
    protected String basePath;
    
    @XmlAttribute(name = "produce", required = true)
    protected String produce;
    
    @XmlAttribute(name = "consume", required = true)
    protected String consume;

    /**
     * Gets the value of the version property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the basePath property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * Sets the value of the basePath property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setBasePath(String value) {
        this.basePath = value;
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

}
