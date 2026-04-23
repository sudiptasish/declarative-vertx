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
 *         &lt;element name="event-loop-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="worker-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="blocked-thread-check-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-event-loop-execute-time" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="max-worker-execute-time" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="internal-blocking-pool-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="cluster-manager" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ha-enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="quorum-size" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="ha-group" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="file-system-options"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="class-path-resolving-enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *                   &lt;element name="file-caching-enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *                   &lt;element name="file-cache-dir" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="metrics-options"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *                   &lt;element name="factory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tracing-options"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="factory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="warning-exception-time" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="prefer-native-transport" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="disable-tccl" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="use-daemon-thread" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *         &lt;element name="event-bus-options"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cluster-public-host" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="cluster-public-port" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="cluster-ping-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="cluster-ping-reply-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="accept-backlog" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                   &lt;element name="reconnect-interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="reconnect-attempts" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="connect-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                   &lt;element name="trust-all" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *                   &lt;element name="log-activity" type="{http://www.w3.org/2001/XMLSchema}Boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="address-resolver-options"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="search-domains" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="dns-server" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="error-handler" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="metric-class" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "eventLoopPoolSize",
    "workerPoolSize",
    "blockedThreadCheckInterval",
    "maxEventLoopExecuteTime",
    "maxWorkerExecuteTime",
    "internalBlockingPoolSize",
    "clusterManager",
    "haEnabled",
    "quorumSize",
    "haGroup",
    "fileSystemOptions",
    "metricsOptions",
    "tracingOptions",
    "warningExceptionTime",
    "preferNativeTransport",
    "disableTccl",
    "useDaemonThread",
    "eventBusOptions",
    "addressResolverOptions",
    "errorHandler",
    "metricClass"
})
public class ContextParams {

    @XmlElement(name = "event-loop-pool-size", defaultValue = "2")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer eventLoopPoolSize;
    
    @XmlElement(name = "worker-pool-size", defaultValue = "20")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer workerPoolSize;
    
    @XmlElement(name = "blocked-thread-check-interval", defaultValue = "1000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer blockedThreadCheckInterval;
    
    @XmlElement(name = "max-event-loop-execute-time", defaultValue = "2000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxEventLoopExecuteTime;
    
    @XmlElement(name = "max-worker-execute-time", defaultValue = "60000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer maxWorkerExecuteTime;
    
    @XmlElement(name = "internal-blocking-pool-size", defaultValue = "20")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer internalBlockingPoolSize;
    
    @XmlElement(name = "cluster-manager", required = true)
    protected String clusterManager;
    
    @XmlElement(name = "ha-enabled", defaultValue = "false")
    protected Boolean haEnabled;
    
    @XmlElement(name = "quorum-size", defaultValue = "1")
    @XmlSchemaType(name = "unsignedByte")
    protected Integer quorumSize;
    
    @XmlElement(name = "ha-group", required = true, defaultValue = "__DEFAULT__")
    protected String haGroup;
    
    @XmlElement(name = "file-system-options", required = true)
    protected FileSystemOptions fileSystemOptions;
    
    @XmlElement(name = "metrics-options", required = true)
    protected MetricsOptions metricsOptions;
    
    @XmlElement(name = "tracing-options", required = true)
    protected TracingOptions tracingOptions;
    
    @XmlElement(name = "warning-exception-time", defaultValue = "5000")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer warningExceptionTime;
    
    @XmlElement(name = "prefer-native-transport", defaultValue = "false")
    protected Boolean preferNativeTransport;
    
    @XmlElement(name = "disable-tccl", defaultValue = "false")
    protected Boolean disableTccl;
    
    @XmlElement(name = "use-daemon-thread", defaultValue = "false")
    protected Boolean useDaemonThread;
    
    @XmlElement(name = "event-bus-options", required = true)
    protected EventBusOptions eventBusOptions;
    
    @XmlElement(name = "address-resolver-options", required = true)
    protected AddressResolverOptions addressResolverOptions;
    
    @XmlElement(name = "error-handler", required = true, defaultValue = "org.javalabs.decl.vertx.container.ContainerErrorHandler")
    protected String errorHandler;
    
    @XmlElement(name = "metric-class", required = true)
    protected String metricClass;

    /**
     * Gets the value of the eventloopPoolSize property.
     *
     * @return Integer
     */
    public Integer getEventLoopPoolSize() {
        return eventLoopPoolSize;
    }

    /**
     * Sets the value of the eventloopPoolSize property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setEventLoopPoolSize(Integer value) {
        this.eventLoopPoolSize = value;
    }

    /**
     * Gets the value of the workerPoolSize property.
     *
     * @return Integer
     */
    public Integer getWorkerPoolSize() {
        return workerPoolSize;
    }

    /**
     * Sets the value of the workerPoolSize property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setWorkerPoolSize(Integer value) {
        this.workerPoolSize = value;
    }

    /**
     * Gets the value of the blockedThreadCheckInterval property.
     *
     * @return Integer
     */
    public Integer getBlockedThreadCheckInterval() {
        return blockedThreadCheckInterval;
    }

    /**
     * Sets the value of the blockedThreadCheckInterval property.
     *
     * @param value allowed object is {@link Integer }
     */
    public void setBlockedThreadCheckInterval(Integer value) {
        this.blockedThreadCheckInterval = value;
    }

    /**
     * Gets the value of the maxEventLoopExecuteTime property.
     * 
     * @return Integer
     *
     */
    public Integer getMaxEventLoopExecuteTime() {
        return maxEventLoopExecuteTime;
    }

    /**
     * Sets the value of the maxEventLoopExecuteTime property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxEventLoopExecuteTime(Integer value) {
        this.maxEventLoopExecuteTime = value;
    }

    /**
     * Gets the value of the maxWorkerExecuteTime property.
     * 
     * @return Integer
     *
     */
    public Integer getMaxWorkerExecuteTime() {
        return maxWorkerExecuteTime;
    }

    /**
     * Sets the value of the maxWorkerExecuteTime property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setMaxWorkerExecuteTime(Integer value) {
        this.maxWorkerExecuteTime = value;
    }

    /**
     * Gets the value of the internalBlockingPoolSize property.
     * 
     * @return Integer
     *
     */
    public Integer getInternalBlockingPoolSize() {
        return internalBlockingPoolSize;
    }

    /**
     * Sets the value of the internalBlockingPoolSize property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setInternalBlockingPoolSize(Integer value) {
        this.internalBlockingPoolSize = value;
    }

    /**
     * Gets the value of the clusterManager property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClusterManager() {
        return clusterManager;
    }

    /**
     * Sets the value of the clusterManager property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClusterManager(String value) {
        this.clusterManager = value;
    }

    /**
     * Gets the value of the haEnabled property.
     * 
     * @return Boolean
     *
     */
    public Boolean isHaEnabled() {
        return haEnabled;
    }

    /**
     * Sets the value of the haEnabled property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setHaEnabled(Boolean value) {
        this.haEnabled = value;
    }

    /**
     * Gets the value of the quorumSize property.
     * 
     * @return Integer
     *
     */
    public Integer getQuorumSize() {
        return quorumSize;
    }

    /**
     * Sets the value of the quorumSize property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setQuorumSize(Integer value) {
        this.quorumSize = value;
    }

    /**
     * Gets the value of the haGroup property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getHaGroup() {
        return haGroup;
    }

    /**
     * Sets the value of the haGroup property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setHaGroup(String value) {
        this.haGroup = value;
    }

    /**
     * Gets the value of the fileSystemOptions property.
     *
     * @return possible object is {@link FileSystemOptions }
     *
     */
    public FileSystemOptions getFileSystemOptions() {
        return fileSystemOptions;
    }

    /**
     * Sets the value of the fileSystemOptions property.
     *
     * @param value allowed object is {@link FileSystemOptions }
     *
     */
    public void setFileSystemOptions(FileSystemOptions value) {
        this.fileSystemOptions = value;
    }

    /**
     * Gets the value of the metricsOptions property.
     *
     * @return possible object is {@link MetricsOptions }
     *
     */
    public MetricsOptions getMetricsOptions() {
        return metricsOptions;
    }

    /**
     * Sets the value of the metricsOptions property.
     *
     * @param value allowed object is {@link MetricsOptions }
     *
     */
    public void setMetricsOptions(MetricsOptions value) {
        this.metricsOptions = value;
    }

    /**
     * Gets the value of the tracingOptions property.
     *
     * @return possible object is {@link TracingOptions }
     *
     */
    public TracingOptions getTracingOptions() {
        return tracingOptions;
    }

    /**
     * Sets the value of the tracingOptions property.
     *
     * @param value allowed object is {@link TracingOptions }
     *
     */
    public void setTracingOptions(TracingOptions value) {
        this.tracingOptions = value;
    }

    /**
     * Gets the value of the warningExceptionTime property.
     *
     * @return Integer allowed object is {@link Integer }
     *
     */
    public Integer getWarningExceptionTime() {
        return warningExceptionTime;
    }

    /**
     * Sets the value of the warningExceptionTime property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setWarningExceptionTime(Integer value) {
        this.warningExceptionTime = value;
    }

    /**
     * Gets the value of the preferNativeTransport property.
     *
     * @return Boolean allowed object is {@link Boolean }
     *
     */
    public Boolean isPreferNativeTransport() {
        return preferNativeTransport;
    }

    /**
     * Sets the value of the preferNativeTransport property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setPreferNativeTransport(Boolean value) {
        this.preferNativeTransport = value;
    }

    /**
     * Gets the value of the disableTccl property.
     *
     * @return Boolean allowed object is {@link Boolean }
     *
     */
    public Boolean isDisableTccl() {
        return disableTccl;
    }

    /**
     * Sets the value of the disableTccl property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setDisableTccl(Boolean value) {
        this.disableTccl = value;
    }

    /**
     * Gets the value of the useDaemonThread property.
     *
     * @return Boolean allowed object is {@link Boolean }
     *
     */
    public Boolean isUseDaemonThread() {
        return useDaemonThread;
    }

    /**
     * Sets the value of the useDaemonThread property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setUseDaemonThread(Boolean value) {
        this.useDaemonThread = value;
    }

    /**
     * Gets the value of the eventBusOptions property.
     *
     * @return possible object is {@link EventBusOptions }
     *
     */
    public EventBusOptions getEventBusOptions() {
        return eventBusOptions;
    }

    /**
     * Sets the value of the eventBusOptions property.
     *
     * @param value allowed object is {@link EventBusOptions }
     *
     */
    public void setEventBusOptions(EventBusOptions value) {
        this.eventBusOptions = value;
    }

    /**
     * Gets the value of the addressResolverOptions property.
     *
     * @return possible object is {@link AddressResolverOptions }
     *
     */
    public AddressResolverOptions getAddressResolverOptions() {
        return addressResolverOptions;
    }

    /**
     * Sets the value of the addressResolverOptions property.
     *
     * @param value allowed object is {@link AddressResolverOptions }
     *
     */
    public void setAddressResolverOptions(AddressResolverOptions value) {
        this.addressResolverOptions = value;
    }

    /**
     * Gets the value of the errorHandler property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getErrorHandler() {
        return errorHandler;
    }

    /**
     * Sets the value of the errorHandler property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setErrorHandler(String value) {
        this.errorHandler = value;
    }

    /**
     * Gets the value of the metricClass property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getMetricClass() {
        return metricClass;
    }

    /**
     * Sets the value of the metricClass property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setMetricClass(String value) {
        this.metricClass = value;
    }
}
