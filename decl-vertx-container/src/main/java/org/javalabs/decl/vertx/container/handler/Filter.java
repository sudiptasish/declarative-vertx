package org.javalabs.decl.vertx.container.handler;

import org.javalabs.decl.vertx.container.util.CookieUtil;
import org.javalabs.decl.vertx.container.util.ResponseHandler;
import io.vertx.core.Handler;
import io.vertx.core.http.Cookie;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic filter class.
 * 
 * <p>
 * A filter used to pre- and post-process incoming requests. Pre-processing occurs before 
 * the application's handler is invoked, and post-processing occurs after the handler returns. 
 * Filters can be organized in chains, and are associated with {@link RoutingContext} instance.
 * 
 * <p>
 * {@link Filter} is the default filter that comes along with the declarative vertx framework.
 * This filter will be invoked for every single call.
 *
 * @author Sudiptasish Chanda
 */
public class Filter implements Handler<RoutingContext> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Filter.class);
    
    private static final String ACC_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACC_METHODS = "Access-Control-Allow-Methods";
    
    private final Set<String> allowedHeaders;
    private final Set<HttpMethod> allowedMethods;
    
    public static final String SERVER = "Vert.x/5.0.11 Http Server";
    
    public Filter(Set<String> allowedHeaders, Set<HttpMethod> allowedMethods) {
        this.allowedHeaders = allowedHeaders;
        this.allowedMethods = allowedMethods;
    }

    @Override
    public void handle(RoutingContext ctx) {
        String headers = allowedHeaders.toString();
        headers = headers.substring(1, headers.length() - 1);
        
        String methods = allowedMethods.toString();
        methods = methods.substring(1, methods.length() - 1);
        
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Invoked application common filter");
        }
        String path = ctx.request().path();
        if (path.equals("/")) {
            ctx.response().headers().add("Date", new Date().toString())
                .add(ACC_HEADERS, headers)
                .add(ACC_METHODS, methods)
                .add("Server", SERVER);
            
            ResponseHandler.send(ctx, HttpURLConnection.HTTP_OK, null);
        }
        else {
            String jwt = null;
            final Cookie cookie = ctx.request().getCookie(CookieUtil.AUTH_COOKIE);
            if (cookie != null) {
                jwt = cookie.getValue();
                if (jwt != null) {
                    ctx.request().headers().add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
                }
            }
            
            // Set the handling of resource /projects
            ctx.next();
        }
    }
}
