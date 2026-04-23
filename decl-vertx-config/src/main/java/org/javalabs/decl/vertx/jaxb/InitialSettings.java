package org.javalabs.decl.vertx.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="header-table-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="push-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="max-concurrent-streams" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="initial-window-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-frame-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-header-list-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
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
    "headerTableSize",
    "pushEnabled",
    "maxConcurrentStreams",
    "initialWindowSize",
    "maxFrameSize",
    "maxHeaderListSize"
})
public class InitialSettings {

    @XmlElement(name = "header-table-size", defaultValue = "4096")
    @XmlSchemaType(name = "unsignedShort")
    protected int headerTableSize;
    @XmlElement(name = "push-enabled", defaultValue = "true")
    protected boolean pushEnabled;
    @XmlElement(name = "max-concurrent-streams", defaultValue = "4294967295")
    @XmlSchemaType(name = "unsignedInt")
    protected long maxConcurrentStreams;
    @XmlElement(name = "initial-window-size", defaultValue = "65535")
    @XmlSchemaType(name = "unsignedShort")
    protected int initialWindowSize;
    @XmlElement(name = "max-frame-size", defaultValue = "16384")
    @XmlSchemaType(name = "unsignedShort")
    protected int maxFrameSize;
    @XmlElement(name = "max-header-list-size", defaultValue = "8192")
    @XmlSchemaType(name = "unsignedShort")
    protected int maxHeaderListSize;

    /**
     * Gets the value of the headerTableSize property.
     *
     */
    public int getHeaderTableSize() {
        return headerTableSize;
    }

    /**
     * Sets the value of the headerTableSize property.
     *
     */
    public void setHeaderTableSize(int value) {
        this.headerTableSize = value;
    }

    /**
     * Gets the value of the pushEnabled property.
     *
     */
    public boolean isPushEnabled() {
        return pushEnabled;
    }

    /**
     * Sets the value of the pushEnabled property.
     *
     */
    public void setPushEnabled(boolean value) {
        this.pushEnabled = value;
    }

    /**
     * Gets the value of the maxConcurrentStreams property.
     *
     */
    public long getMaxConcurrentStreams() {
        return maxConcurrentStreams;
    }

    /**
     * Sets the value of the maxConcurrentStreams property.
     *
     */
    public void setMaxConcurrentStreams(long value) {
        this.maxConcurrentStreams = value;
    }

    /**
     * Gets the value of the initialWindowSize property.
     *
     */
    public int getInitialWindowSize() {
        return initialWindowSize;
    }

    /**
     * Sets the value of the initialWindowSize property.
     *
     */
    public void setInitialWindowSize(int value) {
        this.initialWindowSize = value;
    }

    /**
     * Gets the value of the maxFrameSize property.
     *
     */
    public int getMaxFrameSize() {
        return maxFrameSize;
    }

    /**
     * Sets the value of the maxFrameSize property.
     *
     */
    public void setMaxFrameSize(int value) {
        this.maxFrameSize = value;
    }

    /**
     * Gets the value of the maxHeaderListSize property.
     *
     */
    public int getMaxHeaderListSize() {
        return maxHeaderListSize;
    }

    /**
     * Sets the value of the maxHeaderListSize property.
     *
     */
    public void setMaxHeaderListSize(int value) {
        this.maxHeaderListSize = value;
    }

}
