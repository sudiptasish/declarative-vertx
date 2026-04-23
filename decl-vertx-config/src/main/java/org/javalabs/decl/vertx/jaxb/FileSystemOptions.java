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
 *         &lt;element name="class-path-resolving-enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="file-caching-enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="file-cache-dir" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "classPathResolvingEnabled",
    "fileCachingEnabled",
    "fileCacheDir"
})
public class FileSystemOptions {

    @XmlElement(name = "class-path-resolving-enabled", defaultValue = "true")
    protected Boolean classPathResolvingEnabled;
    
    @XmlElement(name = "file-caching-enabled", defaultValue = "true")
    protected Boolean fileCachingEnabled;
    
    @XmlElement(name = "file-cache-dir", required = true)
    protected String fileCacheDir;

    /**
     * Gets the value of the classPathResolvingEnabled property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isClassPathResolvingEnabled() {
        return classPathResolvingEnabled;
    }

    /**
     * Sets the value of the classPathResolvingEnabled property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setClassPathResolvingEnabled(Boolean value) {
        this.classPathResolvingEnabled = value;
    }

    /**
     * Gets the value of the fileCachingEnabled property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isFileCachingEnabled() {
        return fileCachingEnabled;
    }

    /**
     * Sets the value of the fileCachingEnabled property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setFileCachingEnabled(Boolean value) {
        this.fileCachingEnabled = value;
    }

    /**
     * Gets the value of the fileCacheDir property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getFileCacheDir() {
        return fileCacheDir;
    }

    /**
     * Sets the value of the fileCacheDir property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setFileCacheDir(String value) {
        this.fileCacheDir = value;
    }

}
