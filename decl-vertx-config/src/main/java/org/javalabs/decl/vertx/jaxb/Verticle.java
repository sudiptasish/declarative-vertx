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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="config" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "name",
    "clazz",
    "config",
    "deployOptions"
})
public class Verticle {

    @XmlElement(required = true)
    protected String name;
    
    @XmlElement(name = "class", required = true)
    protected String clazz;
    
    protected String config;
    
    @XmlElement(name = "deploy-options")
    protected DeployOptions deployOptions;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the clazz property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the config property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setConfig(String value) {
        this.config = value;
    }

    /**
     * Return the deploy options.
     * @return 
     */
    public DeployOptions getDeployOptions() {
        return deployOptions;
    }

    /**
     * Deployment options to be set.
     * @param value 
     */
    public void setDeployOptions(DeployOptions value) {
        this.deployOptions = value;
    }

}
