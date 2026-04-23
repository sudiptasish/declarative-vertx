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
 *         &lt;element name="search-domains" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dns-server" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "hostsPath",
    "hostsRefreshPeriod",
    "servers",
    "optResourceEnabled",
    "cacheMinTimeToLive",
    "cacheMaxTimeToLive",
    "cacheNegativeTimeToLive",
    "queryTimeout",
    "maxQueries",
    "rdFlag",
    "searchDomains",
    "ndots",
    "rotateServers",
    "roundRobinInetAddress",
})
public class AddressResolverOptions {

    @XmlElement(name = "hosts-path", required = false)
    protected String hostsPath;
    
    @XmlElement(name = "hosts-refresh-period", required = false, defaultValue = "0")
    protected Integer hostsRefreshPeriod;
    
    @XmlElement(name = "servers", required = false)
    protected String servers;
    
    @XmlElement(name = "opt-resource-enabled", required = false, defaultValue = "false")
    protected Boolean optResourceEnabled;
    
    @XmlElement(name = "cache-min-time-to-live", required = false, defaultValue = "0")
    protected Integer cacheMinTimeToLive;
    
    @XmlElement(name = "cache-max-time-to-live", required = false, defaultValue = "2147483647")
    protected Integer cacheMaxTimeToLive;
    
    @XmlElement(name = "cache-negative-time-to-live", required = false, defaultValue = "0")
    protected Integer cacheNegativeTimeToLive;
    
    @XmlElement(name = "query-timeout", required = false, defaultValue = "5000")
    protected Integer queryTimeout;
    
    @XmlElement(name = "max-queries", required = false, defaultValue = "4")
    protected Integer maxQueries;
    
    @XmlElement(name = "rd-flag", required = false, defaultValue = "true")
    protected Boolean rdFlag;
    
    @XmlElement(name = "search-domains", required = false)
    protected String searchDomains;
    
    @XmlElement(name = "ndots", required = false)
    protected Integer ndots;
    
    @XmlElement(name = "rotate-servers", required = false, defaultValue = "false")
    protected Boolean rotateServers;
    
    @XmlElement(name = "round-robin-inet-address", required = false, defaultValue = "false")
    protected Boolean roundRobinInetAddress;

    /**
     * Gets the value of the hostsPath property.
     *
     * @return Boolean allowed object is {@link String }
     */
    public String getHostsPath() {
        return hostsPath;
    }

    /**
     * Sets the value of the hostsPath property.
     *
     * @param value allowed object is {@link String }
     */
    public void setHostsPath(String value) {
        this.hostsPath = value;
    }

    /**
     * Gets the value of the hostsRefreshPeriod property.
     *
     * @return Boolean allowed object is {@link Integer }
     */
    public Integer getHostsRefreshPeriod() {
        return hostsRefreshPeriod;
    }

    /**
     * Sets the value of the hostsRefreshPeriod property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setHostsRefreshPeriod(Integer value) {
        this.hostsRefreshPeriod = value;
    }

    /**
     * Gets the value of the servers property.
     *
     * @return Boolean allowed object is {@link String }
     */
    public String getServers() {
        return servers;
    }

    /**
     * Sets the value of the servers property.
     *
     * @param value allowed object is {@link String }
     */
    public void setServers(String value) {
        this.servers = value;
    }

    /**
     * Gets the value of the optResourceEnabled property.
     *
     * @return Boolean allowed object is {@link Boolean }
     */
    public Boolean isOptResourceEnabled() {
        return optResourceEnabled;
    }

    /**
     * Sets the value of the optResourceEnabled property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setOptResourceEnabled(Boolean value) {
        this.optResourceEnabled = value;
    }

    /**
     * Gets the value of the cacheMinTimeToLive property.
     *
     * @return Boolean allowed object is {@link Integer }
     */
    public Integer getCacheMinTimeToLive() {
        return cacheMinTimeToLive;
    }

    /**
     * Sets the value of the cacheMinTimeToLive property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setCacheMinTimeToLive(Integer value) {
        this.cacheMinTimeToLive = value;
    }

    /**
     * Gets the value of the cacheMaxTimeToLive property.
     *
     * @return Boolean allowed object is {@link Integer }
     */
    public Integer getCacheMaxTimeToLive() {
        return cacheMaxTimeToLive;
    }

    /**
     * Sets the value of the cacheMaxTimeToLive property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setCacheMaxTimeToLive(Integer value) {
        this.cacheMaxTimeToLive = value;
    }

    /**
     * Gets the value of the cacheNegativeTimeToLive property.
     *
     * @return Boolean allowed object is {@link Integer }
     */
    public Integer getCacheNegativeTimeToLive() {
        return cacheNegativeTimeToLive;
    }

    /**
     * Sets the value of the cacheNegativeTimeToLive property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setCacheNegativeTimeToLive(Integer value) {
        this.cacheNegativeTimeToLive = value;
    }

    /**
     * Gets the value of the queryTimeout property.
     *
     * @return Boolean allowed object is {@link Integer }
     */
    public Integer getQueryTimeout() {
        return queryTimeout;
    }

    /**
     * Sets the value of the queryTimeout property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setQueryTimeout(Integer value) {
        this.queryTimeout = value;
    }

    /**
     * Gets the value of the maxQueries property.
     *
     * @return Boolean allowed object is {@link Integer }
     */
    public Integer getMaxQueries() {
        return maxQueries;
    }

    /**
     * Sets the value of the maxQueries property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setMaxQueries(Integer value) {
        this.maxQueries = value;
    }

    /**
     * Gets the value of the rdFlag property.
     *
     * @return Boolean allowed object is {@link Boolean }
     */
    public Boolean isRdFlag() {
        return rdFlag;
    }

    /**
     * Sets the value of the rdFlag property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setRdFlag(Boolean value) {
        this.rdFlag = value;
    }

    /**
     * Gets the value of the searchDomains property.
     *
     * @return Boolean allowed object is {@link String }
     */
    public String getSearchDomains() {
        return searchDomains;
    }

    /**
     * Sets the value of the searchDomains property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSearchDomains(String value) {
        this.searchDomains = value;
    }

    /**
     * Gets the value of the ndots property.
     *
     * @return Boolean allowed object is {@link Integer }
     */
    public Integer getNdots() {
        return ndots;
    }

    /**
     * Sets the value of the ndots property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setNdots(Integer value) {
        this.ndots = value;
    }

    /**
     * Gets the value of the rotateServers property.
     *
     * @return Boolean allowed object is {@link Boolean }
     */
    public Boolean isRotateServers() {
        return rotateServers;
    }

    /**
     * Sets the value of the rotateServers property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setRotateServers(Boolean value) {
        this.rotateServers = value;
    }

    /**
     * Gets the value of the roundRobinInetAddress property.
     *
     * @return Boolean allowed object is {@link Boolean }
     */
    public Boolean isRoundRobinInetAddress() {
        return roundRobinInetAddress;
    }

    /**
     * Sets the value of the roundRobinInetAddress property.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setRoundRobinInetAddress(Boolean value) {
        this.roundRobinInetAddress = value;
    }

}
