package org.javalabs.decl.container;

/**
 * Generic container exception class.
 * 
 * <p>
 * A container exception generally refers to an error or unexpected event that occurs within the
 * vert.x container, or within an application framework. These exceptions can arise from various 
 * issues, including errors during container startup, dependency conflicts, resource exhaustion, 
 * or problems with the application running inside the container.
 *
 * @author Sudiptasish Chanda
 */
public class ContainerException extends RuntimeException {
    
    public static final int GENERIC_FAILURE = -999;
    public static final int DEPLOYMENT_FAILURE = -1;
    
    private final int errorCode;
    private final String errorMessage;
    private final Throwable cause;
    
    public ContainerException(Throwable cause) {
        this(GENERIC_FAILURE, "", cause);
    }
    
    public ContainerException(String errorMessage) {
        this(GENERIC_FAILURE, errorMessage, null);
    }
    
    public ContainerException(int errorCode, Throwable cause) {
        this(errorCode, "", cause);
    }
    
    public ContainerException(String errorMessage, Throwable cause) {
        this(GENERIC_FAILURE, errorMessage, cause);
    }
    
    public ContainerException(int errorCode
        , String errorMessage
        , Throwable cause) {
        
        this.errorCode = errorCode;
        this.cause = cause;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Throwable getCause() {
        return cause;
    }
}
