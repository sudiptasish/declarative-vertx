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
 *         &lt;element name="ssl-handshake-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="key-cert-options" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="trust-options" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="enabled-cipher-suites" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="crl-paths" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="crl-values" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="use-alpn" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="enabled-secure-transport-protocols" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "sslHandshakeTimeout",
    "keyCertOptions",
    "trustOptions",
    "enabledCipherSuites",
    "crlPaths",
    "crlValues",
    "useAlpn",
    "enabledSecureTransportProtocols",
})
public class SslOpts {

    @XmlElement(name = "ssl-handshake-timeout", defaultValue = "10000")
    protected Integer sslHandshakeTimeout;
    
    @XmlElement(name = "key-cert-options")
    protected String keyCertOptions;
    
    @XmlElement(name = "trust-options")
    protected String trustOptions;
    
    @XmlElement(name = "enabled-cipher-suites")
    protected String enabledCipherSuites;
    
    @XmlElement(name = "crl-paths")
    protected String crlPaths;
    
    @XmlElement(name = "crl-values")
    protected String crlValues;
    
    @XmlElement(name = "use-alpn", defaultValue = "false")
    protected Boolean useAlpn;
    
    @XmlElement(name = "enabled-secure-transport-protocols", defaultValue = "TLSv1,TLSv1.1,TLSv1.2,TLSv1.3")
    protected String enabledSecureTransportProtocols;

    public Integer getSslHandshakeTimeout() {
        return sslHandshakeTimeout;
    }

    public void setSslHandshakeTimeout(Integer sslHandshakeTimeout) {
        this.sslHandshakeTimeout = sslHandshakeTimeout;
    }

    public String getKeyCertOptions() {
        return keyCertOptions;
    }

    public void setKeyCertOptions(String keyCertOptions) {
        this.keyCertOptions = keyCertOptions;
    }

    public String getTrustOptions() {
        return trustOptions;
    }

    public void setTrustOptions(String trustOptions) {
        this.trustOptions = trustOptions;
    }

    public String getEnabledCipherSuites() {
        return enabledCipherSuites;
    }

    public void setEnabledCipherSuites(String enabledCipherSuites) {
        this.enabledCipherSuites = enabledCipherSuites;
    }

    public String getCrlPaths() {
        return crlPaths;
    }

    public void setCrlPaths(String crlPaths) {
        this.crlPaths = crlPaths;
    }

    public String getCrlValues() {
        return crlValues;
    }

    public void setCrlValues(String crlValues) {
        this.crlValues = crlValues;
    }

    public Boolean isUseAlpn() {
        return useAlpn;
    }

    public void setUseAlpn(Boolean useAlpn) {
        this.useAlpn = useAlpn;
    }

    public String getEnabledSecureTransportProtocols() {
        return enabledSecureTransportProtocols;
    }

    public void setEnabledSecureTransportProtocols(String enabledSecureTransportProtocols) {
        this.enabledSecureTransportProtocols = enabledSecureTransportProtocols;
    }
}
