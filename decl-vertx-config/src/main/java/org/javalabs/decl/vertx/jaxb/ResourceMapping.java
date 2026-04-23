package org.javalabs.decl.vertx.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

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
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="mapping" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="uri" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="method" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="api" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="consume" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="produce" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="produces" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="admin" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="path" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="failure" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="resource" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="provider" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="accessor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="arg" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mapping"
})
public class ResourceMapping {

    protected List<Mapping> mapping;
    
    @XmlAttribute(name = "name", required = true)
    protected String name;
    
    @XmlAttribute(name = "path", required = true)
    protected String path;
    
    @XmlAttribute(name = "failure")
    protected Boolean failure;
    
    @XmlAttribute(name = "resource", required = true)
    protected String resource;
    
    @XmlAttribute(name = "schema", required = true)
    protected String schema;
    
    @XmlAttribute(name = "provider")
    protected Boolean provider;
    
    @XmlAttribute(name = "accessor")
    protected String accessor;
    
    @XmlAttribute(name = "arg")
    protected String arg;
    
    @XmlAttribute(name = "construct")
    protected String construct;

    /**
     * Gets the value of the mapping property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the Jakarta XML Binding object. This is why there is not a
     * <CODE>set</CODE> method for the mapping property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapping().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Mapping }
     *
     *
     * @return List List of mappings.
     */
    public List<Mapping> getMapping() {
        if (mapping == null) {
            mapping = new ArrayList<Mapping>();
        }
        return this.mapping;
    }

    public void setMapping(List<Mapping> mapping) {
        this.mapping = mapping;
    }

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
     * Gets the value of the path property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the failure property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isFailure() {
        return failure;
    }

    /**
     * Sets the value of the failure property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setFailure(Boolean value) {
        this.failure = value;
    }

    /**
     * Gets the value of the resource property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setResource(String value) {
        this.resource = value;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * Gets the value of the provider property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setProvider(Boolean value) {
        this.provider = value;
    }

    /**
     * Gets the value of the accessor property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getAccessor() {
        return accessor;
    }

    /**
     * Sets the value of the accessor property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setAccessor(String value) {
        this.accessor = value;
    }

    /**
     * Gets the value of the arg property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getArg() {
        return arg;
    }

    /**
     * Sets the value of the arg property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setArg(String value) {
        this.arg = value;
    }

    /**
     * Gets the value of the construct property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getConstruct() {
        return construct;
    }

    /**
     * Sets the value of the construct property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setConstruct(String value) {
        this.construct = value;
    }

}
