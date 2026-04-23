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
 *         &lt;element name="compression-supported" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="compression-level" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="max-web-socket-frame-size" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="max-web-socket-message-size" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="handle-100-continue-automatically" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="max-chunk-size" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="max-initial-line-length" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-header-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-form-attribute-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-form-fields" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-form-buffered-bytes" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="initial-settings"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="header-table-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="push-enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *                   &lt;element name="max-concurrent-streams" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                   &lt;element name="initial-window-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-frame-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="max-header-list-size" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="alpn-versions" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="http2-clear-text-enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="http2-connection-window-size" type="{http://www.w3.org/2001/XMLSchema}Integer"/&gt;
 *         &lt;element name="decompression-supported" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="accept-unmasked-frames" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="decoder-initial-buffer-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="per-frame-web-socket-compression-supported" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="per-message-web-socket-compression-supported" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="web-socket-compression-level" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="web-socket-preferred-client-no-context" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="web-socket-allow-server-no-context" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="web-socket-closing-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="tracing-policy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="register-web-socket-write-handlers" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="http2-rst-flood-max-rst-frame-per-window" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="http2-rst-flood-window-duration" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
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
    "compressionSupported",
    "compressionLevel",
    "maxWebSocketFrameSize",
    "maxWebSocketMessageSize",
    "handle100ContinueAutomatically",
    "maxChunkSize",
    "maxInitialLineLength",
    "maxHeaderSize",
    "maxFormAttributeSize",
    "maxFormFields",
    "maxFormBufferedBytes",
    "initialSettings",
    "alpnVersions",
    "http2ClearTextEnabled",
    "http2ConnectionWindowSize",
    "decompressionSupported",
    "acceptUnmaskedFrames",
    "decoderInitialBufferSize",
    "perFrameWebSocketCompressionSupported",
    "perMessageWebSocketCompressionSupported",
    "webSocketCompressionLevel",
    "webSocketPreferredClientNoContext",
    "webSocketAllowServerNoContext",
    "webSocketClosingTimeout",
    "tracingPolicy",
    "registerWebSocketWriteHandlers",
    "http2RstFloodMaxRstFramePerWindow",
    "http2RstFloodWindowDuration"
})
public class HttpOpts {

    @XmlElement(name = "compression-supported", defaultValue = "false")
    protected Boolean compressionSupported;
    
    @XmlElement(name = "compression-level", defaultValue = "6")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer compressionLevel;
    
    @XmlElement(name = "max-web-socket-frame-size", defaultValue = "65536")
    @XmlSchemaType(name = "unsignedInt")
    protected Integer maxWebSocketFrameSize;
    
    @XmlElement(name = "max-web-socket-message-size", defaultValue = "262144")
    @XmlSchemaType(name = "unsignedInt")
    protected Integer maxWebSocketMessageSize;
    
    @XmlElement(name = "handle-100-continue-automatically", defaultValue = "false")
    protected Boolean handle100ContinueAutomatically;
    
    @XmlElement(name = "max-chunk-size", defaultValue = "8192")
    @XmlSchemaType(name = "unsignedInt")
    protected Integer maxChunkSize;
    
    @XmlElement(name = "max-initial-line-length", defaultValue = "4096")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxInitialLineLength;
    
    @XmlElement(name = "max-header-size", defaultValue = "8192")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxHeaderSize;
    
    @XmlElement(name = "max-form-attribute-size", defaultValue = "8192")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxFormAttributeSize;
    
    @XmlElement(name = "max-form-fields", defaultValue = "256")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxFormFields;
    
    @XmlElement(name = "max-form-buffered-bytes", defaultValue = "1024")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxFormBufferedBytes;
    
    @XmlElement(name = "initial-settings", required = true)
    protected InitialSettings initialSettings;
    
    @XmlElement(name = "alpn-versions", required = true, defaultValue = "HTTP_2,HTTP_1_1")
    protected String alpnVersions;
    
    @XmlElement(name = "http2-clear-text-enabled", defaultValue = "true")
    protected Boolean http2ClearTextEnabled;
    
    @XmlElement(name = "http2-connection-window-size", defaultValue = "-1")
    protected Integer http2ConnectionWindowSize;
    
    @XmlElement(name = "decompression-supported", defaultValue = "false")
    protected Boolean decompressionSupported;
    
    @XmlElement(name = "accept-unmasked-frames", defaultValue = "false")
    protected Boolean acceptUnmaskedFrames;
    
    @XmlElement(name = "decoder-initial-buffer-size", defaultValue = "128")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer decoderInitialBufferSize;
    
    @XmlElement(name = "per-frame-web-socket-compression-supported", defaultValue = "true")
    protected Boolean perFrameWebSocketCompressionSupported;
    
    @XmlElement(name = "per-message-web-socket-compression-supported", defaultValue = "true")
    protected Boolean perMessageWebSocketCompressionSupported;
    
    @XmlElement(name = "web-socket-compression-level", defaultValue = "6")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer webSocketCompressionLevel;
    
    @XmlElement(name = "web-socket-preferred-client-no-context", defaultValue = "false")
    protected Boolean webSocketPreferredClientNoContext;
    
    @XmlElement(name = "web-socket-allow-server-no-context", defaultValue = "false")
    protected Boolean webSocketAllowServerNoContext;
    
    @XmlElement(name = "web-socket-closing-timeout", defaultValue = "10000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer webSocketClosingTimeout;
    
    @XmlElement(name = "tracing-policy", required = true, defaultValue = "ALWAYS")
    protected String tracingPolicy;
    
    @XmlElement(name = "register-web-socket-write-handlers", defaultValue = "false")
    protected Boolean registerWebSocketWriteHandlers;
    
    @XmlElement(name = "http2-rst-flood-max-rst-frame-per-window", defaultValue = "200")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer http2RstFloodMaxRstFramePerWindow;
    
    @XmlElement(name = "http2-rst-flood-window-duration", defaultValue = "30000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer http2RstFloodWindowDuration;

    /**
     * Gets the value of the compressionSupported property.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isCompressionSupported() {
        return compressionSupported;
    }

    /**
     * Sets the value of the compressionSupported property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setCompressionSupported(Boolean value) {
        this.compressionSupported = value;
    }

    /**
     * Gets the value of the compressionLevel property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getCompressionLevel() {
        return compressionLevel;
    }

    /**
     * Sets the value of the compressionLevel property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setCompressionLevel(Integer value) {
        this.compressionLevel = value;
    }

    /**
     * Gets the value of the maxWebSocketFrameSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxWebSocketFrameSize() {
        return maxWebSocketFrameSize;
    }

    /**
     * Sets the value of the maxWebSocketFrameSize property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxWebSocketFrameSize(Integer value) {
        this.maxWebSocketFrameSize = value;
    }

    /**
     * Gets the value of the maxWebSocketMessageSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxWebSocketMessageSize() {
        return maxWebSocketMessageSize;
    }

    /**
     * Sets the value of the maxWebSocketMessageSize property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxWebSocketMessageSize(Integer value) {
        this.maxWebSocketMessageSize = value;
    }

    /**
     * Gets the value of the handle100ContinueAutomatically property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isHandle100ContinueAutomatically() {
        return handle100ContinueAutomatically;
    }

    /**
     * Sets the value of the handle100ContinueAutomatically property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setHandle100ContinueAutomatically(Boolean value) {
        this.handle100ContinueAutomatically = value;
    }

    /**
     * Gets the value of the maxChunkSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxChunkSize() {
        return maxChunkSize;
    }

    /**
     * Sets the value of the maxChunkSize property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxChunkSize(Integer value) {
        this.maxChunkSize = value;
    }

    /**
     * Gets the value of the maxInitialLineLength property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxInitialLineLength() {
        return maxInitialLineLength;
    }

    /**
     * Sets the value of the maxInitialLineLength property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxInitialLineLength(Integer value) {
        this.maxInitialLineLength = value;
    }

    /**
     * Gets the value of the maxHeaderSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxHeaderSize() {
        return maxHeaderSize;
    }

    /**
     * Sets the value of the maxHeaderSize property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxHeaderSize(Integer value) {
        this.maxHeaderSize = value;
    }

    /**
     * Gets the value of the maxFormAttributeSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxFormAttributeSize() {
        return maxFormAttributeSize;
    }

    /**
     * Sets the value of the maxFormAttributeSize property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxFormAttributeSize(Integer value) {
        this.maxFormAttributeSize = value;
    }

    /**
     * Gets the value of the maxFormFields property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxFormFields() {
        return maxFormFields;
    }

    /**
     * Sets the value of the maxFormFields property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxFormFields(Integer value) {
        this.maxFormFields = value;
    }

    /**
     * Gets the value of the maxFormBufferedBytes property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getMaxFormBufferedBytes() {
        return maxFormBufferedBytes;
    }

    /**
     * Sets the value of the maxFormBufferedBytes property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxFormBufferedBytes(Integer value) {
        this.maxFormBufferedBytes = value;
    }

    /**
     * Gets the value of the initialSettings property.
     *
     * @return possible object is {@link InitialSettings }
     *
     */
    public InitialSettings getInitialSettings() {
        return initialSettings;
    }

    /**
     * Sets the value of the initialSettings property.
     *
     * @param value allowed object is {@link InitialSettings }
     *
     */
    public void setInitialSettings(InitialSettings value) {
        this.initialSettings = value;
    }

    /**
     * Gets the value of the alpnVersions property.
     *
     * @return possible object is {@link Object }
     *
     */
    public String getAlpnVersions() {
        return alpnVersions;
    }

    /**
     * Sets the value of the alpnVersions property.
     *
     * @param value allowed object is {@link Object }
     *
     */
    public void setAlpnVersions(String value) {
        this.alpnVersions = value;
    }

    /**
     * Gets the value of the http2ClearTextEnabled property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isHttp2ClearTextEnabled() {
        return http2ClearTextEnabled;
    }

    /**
     * Sets the value of the http2ClearTextEnabled property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setHttp2ClearTextEnabled(Boolean value) {
        this.http2ClearTextEnabled = value;
    }

    /**
     * Gets the value of the http2ConnectionWindowSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getHttp2ConnectionWindowSize() {
        return http2ConnectionWindowSize;
    }

    /**
     * Sets the value of the http2ConnectionWindowSize property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setHttp2ConnectionWindowSize(Integer value) {
        this.http2ConnectionWindowSize = value;
    }

    /**
     * Gets the value of the decompressionSupported property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isDecompressionSupported() {
        return decompressionSupported;
    }

    /**
     * Sets the value of the decompressionSupported property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setDecompressionSupported(Boolean value) {
        this.decompressionSupported = value;
    }

    /**
     * Gets the value of the acceptUnmaskedFrames property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isAcceptUnmaskedFrames() {
        return acceptUnmaskedFrames;
    }

    /**
     * Sets the value of the acceptUnmaskedFrames property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setAcceptUnmaskedFrames(Boolean value) {
        this.acceptUnmaskedFrames = value;
    }

    /**
     * Gets the value of the decoderInitialBufferSize property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getDecoderInitialBufferSize() {
        return decoderInitialBufferSize;
    }

    /**
     * Sets the value of the decoderInitialBufferSize property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setDecoderInitialBufferSize(Integer value) {
        this.decoderInitialBufferSize = value;
    }

    /**
     * Gets the value of the perFrameWebSocketCompressionSupported property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isPerFrameWebSocketCompressionSupported() {
        return perFrameWebSocketCompressionSupported;
    }

    /**
     * Sets the value of the perFrameWebSocketCompressionSupported property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setPerFrameWebSocketCompressionSupported(Boolean value) {
        this.perFrameWebSocketCompressionSupported = value;
    }

    /**
     * Gets the value of the perMessageWebSocketCompressionSupported property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isPerMessageWebSocketCompressionSupported() {
        return perMessageWebSocketCompressionSupported;
    }

    /**
     * Sets the value of the perMessageWebSocketCompressionSupported property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setPerMessageWebSocketCompressionSupported(Boolean value) {
        this.perMessageWebSocketCompressionSupported = value;
    }

    /**
     * Gets the value of the webSocketCompressionLevel property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getWebSocketCompressionLevel() {
        return webSocketCompressionLevel;
    }

    /**
     * Sets the value of the webSocketCompressionLevel property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setWebSocketCompressionLevel(Integer value) {
        this.webSocketCompressionLevel = value;
    }

    /**
     * Gets the value of the webSocketPreferredClientNoContext property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isWebSocketPreferredClientNoContext() {
        return webSocketPreferredClientNoContext;
    }

    /**
     * Sets the value of the webSocketPreferredClientNoContext property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setWebSocketPreferredClientNoContext(Boolean value) {
        this.webSocketPreferredClientNoContext = value;
    }

    /**
     * Gets the value of the webSocketAllowServerNoContext property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isWebSocketAllowServerNoContext() {
        return webSocketAllowServerNoContext;
    }

    /**
     * Sets the value of the webSocketAllowServerNoContext property.
     * 
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setWebSocketAllowServerNoContext(Boolean value) {
        this.webSocketAllowServerNoContext = value;
    }

    /**
     * Gets the value of the webSocketClosingTimeout property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getWebSocketClosingTimeout() {
        return webSocketClosingTimeout;
    }

    /**
     * Sets the value of the webSocketClosingTimeout property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setWebSocketClosingTimeout(Integer value) {
        this.webSocketClosingTimeout = value;
    }

    /**
     * Gets the value of the tracingPolicy property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTracingPolicy() {
        return tracingPolicy;
    }

    /**
     * Sets the value of the tracingPolicy property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTracingPolicy(String value) {
        this.tracingPolicy = value;
    }

    /**
     * Gets the value of the registerWebSocketWriteHandlers property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isRegisterWebSocketWriteHandlers() {
        return registerWebSocketWriteHandlers;
    }

    /**
     * Sets the value of the registerWebSocketWriteHandlers property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setRegisterWebSocketWriteHandlers(Boolean value) {
        this.registerWebSocketWriteHandlers = value;
    }

    /**
     * Gets the value of the http2RstFloodMaxRstFramePerWindow property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getHttp2RstFloodMaxRstFramePerWindow() {
        return http2RstFloodMaxRstFramePerWindow;
    }

    /**
     * Sets the value of the http2RstFloodMaxRstFramePerWindow property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setHttp2RstFloodMaxRstFramePerWindow(Integer value) {
        this.http2RstFloodMaxRstFramePerWindow = value;
    }

    /**
     * Gets the value of the http2RstFloodWindowDuration property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getHttp2RstFloodWindowDuration() {
        return http2RstFloodWindowDuration;
    }

    /**
     * Sets the value of the http2RstFloodWindowDuration property.
     * 
     * @param value allowed object is {@link Integer }
     *
     */
    public void setHttp2RstFloodWindowDuration(Integer value) {
        this.http2RstFloodWindowDuration = value;
    }
}
