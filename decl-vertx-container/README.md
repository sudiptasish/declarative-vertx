## Table of Contents  
- [Background](#bg)
- [Declarative Approach in Building REST API](#sccm)
  - [Some REST with Vert.x - Simple Example](#sex)
  - [Some REST with Vert.x - Complex Example](#cex)
- [Conclusion](#app)

<a name="bg"/>

## Background

Traditionally application like `Servlet`, `Taglib`, `Spring Boot`, `Jax-Rs`, etc heavily leverage external `xml`configuration or annotations to define REST API endpoints.
It allows developers to define the mapping between HTTP requests and Java methods within a class by decorating them with annotations like `@Path`, `@GET`, `@POST`, `@PUT`, and `@DELETE` to specify the resource URI and supported HTTP methods respectively.
Annotations or external configuration provide a more declarative way to define RESTful web service behavior without needing extensive configuration or boiler-plate code.

Vert.x takes a more code-centric approach and does not provide extensive annotation support for building REST APIs.

Key points about Vert.x and REST API development:
1. Route-based:
Vert.x uses a routing mechanism where you define routes based on HTTP methods (GET, POST, PUT, DELETE) and paths, and then associate them with custom handler functions to process requests.
1. Flexibility:
This approach gives developers more control over how requests are handled but requires writing more explicit code compared to Spring's annotation-based approach.
1. Vert.x Web module:
The core functionality for building REST APIs in Vert.x is provided by the "vertx-web" module, which provides classes like Router to define routes and handle requests.

Refer to [Vert.x REST](https://vertx.io/blog/some-rest-with-vert-x/) to see how you can use vert.x to develop your RESTful resources.

<a name="sccm"/>

## Declarative Approach in Building REST API

A "declarative approach" in creating a REST API means focusing on defining the desired state of your data and the operations you want to perform on it, without specifying the exact steps to achieve that state.
Key points:
1. Focus on resource representation:
Primarily define the data structures (resources) that your API exposes, outlining their attributes and relationships, rather than intricate logic for manipulating them. 
1. Standard HTTP verbs:
Utilize standard HTTP methods like GET, POST, PUT, DELETE to clearly indicate the intended actions on those resources, allowing the client to understand the operations without needing additional instructions. 
1. Stateless design:
Each request should contain all the necessary information to be processed independently, without relying on previous interactions with the server. 
1. Minimal configuration:
Use declarative frameworks or tools to specify the desired API behavior through configuration files, allowing for easier management and updates

Today, Vert.x does not provide any framework to achieve this. `decl-vertx-container` aims to bridge this gap.

<a name="sex"/>

### Some REST with Vert.x - Simple Example

**Step 1:** Modify your `pom.xml` file.

Add the following dependency in your pom file.

```
<dependency>
    <groupId>org.javalabs.decl</groupId>
    <artifactId>decl-vertx-container</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

**Step 2:** Define API Specification and Contract. Create the `routing-config.xml`. This file will have all routing details.

```
<routing-config>
    <!-- Package name where to find all the handler classes -->
    <package name="com.example.rest"/>
    
    <api version="1.0" basePath="/api/v1" produce="application/vnd.ex+json.v1" consume="application/json"/>
    
    <resource-mapping name="Employee"
            path="/employees"
            resource="com.example.rest.handler.EmployeeHandler"
            schema="com.example.rest.model.Employee">

        <mapping uri=""     method="POST"   api="create"/>
        <mapping uri="/:id" method="PUT"    api="modify"/>
        <mapping uri="/:id" method="GET"    api="view"/>
        <mapping uri="/:id" method="DELETE" api="remove"/>
        <mapping uri=""     method="GET"    api="viewAll"/>
    </resource-mapping>
</routing-config>
```

Ensure to create the `EmployeeHandler.java` and the model class `Employee.java`

**Step 3:** Create the main class.

```
public class ExampleMain {
    
    private HttpServer server = null;
    
    public static void main(String[] args) throws Exception {
        ExampleMain ex = new ExampleMain();
        ex.run();
    }
    
    public void run() {
        Vertx vertx = Vertx.vertx();
        
        // Initialize the vert.x router.
        // The router is a core component that receives incoming HTTP requests and directs them to the appropriate handler.
        Router router = Router.router(vertx);
        router.route("/*").handler(BodyHandler.create(false).setBodyLimit(1024 * 1024));
        
        // Read the routing-config.xml and configure the handler(s).
        Routematic rmatic = new Routematic();
        RoutingConfig rc = RoutingConfigParser.parser().read("routing-config.xml");
        
        // Add the routing path to the Vert.x router.
        rmatic.addPath(vertx, router, rc);
        
        server = vertx.createHttpServer();
        server.requestHandler(router);
        server.listen(8080);
        
        System.out.println("Started Http Server. Listening to port: " + server.actualPort());
    }
}

```

**Step 4:** Compile and Execute

Compile the project using maven and run. Once the server is started you will see the below log.

```
[main] INFO org.javalabs.decl.vertx.config.Routematic - Route:
(1) /api/v1/employees
	[POST]     true
	[PUT]  /:id  true
	[GET]  /:id  true
	[DELETE]  /:id  true
	[GET]     true


Started Http Server. Listening to port: 8080
```

<a name="cex"/>

### Some REST with Vert.x - Complex Example

**Step 1:** Modify your `pom.xml` file.

Add the following dependency in your pom file.

```
<dependency>
    <groupId>org.javalabs.decl</groupId>
    <artifactId>decl-vertx-container</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

**Step 2:** Create a file `vertx-web.xml`. Plase it under `src/main/resources` directory.

```
<vertx-web>
    
    <!-- Add the set of verticles -->
    <!-- 
        Each verticle section (tag) will have the following tags
        1. name     (mandatory)                - Name of the verticle
        2. class    (mandatory)                - The verticle class name (must be a sub-class of Verticle interface)
        3. worker   (optional. default: false) - Whether this verticle is acting as a worker verticle.
        4. ha       (optional. default: false) - Whether the verticle will be deployed in High Availability mode.
        5. instance (optional. default: 1)     - Number of instances of this verticle to be deployed.
        
        If you intend to start the embedded http server from any of the verticles, specify,
        6. config (mandatory)
    -->
    <verticles>
        <verticle>
            <name>http.server</name>
            <class>com.example.rest.ExampleHttpServer</class>
            <worker>false</worker>
            <ha>false</ha>
            <instance>1</instance>
            
            <!-- Specify http configuration file only if the verticle is supposed to start an embedded http server -->
            <config>server.xml</config>
        </verticle>
    </verticles>
    
</vertx-web>
```

We have defined one verticle.
1. ExampleHttpServer   (worker mode is `false`)

**Step 3:** Create a file `server.xml` which will be used by the `ExampleHttpServer` to start the http server. Plase it under `src/main/resources` directory.

```
<server-config>
    <ssl>false</ssl>
    <port>system(http.port::8080)</port>
    <logging>true</logging>
    
    <context-root>/api/v1</context-root>
    
    <!-- The vert.x routing configuration file for the http server -->
    <routing-config>routing-config.xml</routing-config>
</server-config>
```

**Step 4:** Define API Specification and Contract. Create the `routing-config.xml`. This file will have all routing details.

```
<routing-config>
    <!-- Package name where to find all the handler classes -->
    <package name="com.example.rest"/>
    
    <api version="1.0" basePath="/api/v1" produce="application/vnd.ex+json.v1" consume="application/json"/>
    
    <resource-mapping name="Employee"
            path="/employees"
            resource="com.example.rest.handler.EmployeeHandler"
            schema="com.example.rest.model.Employee">

        <mapping uri=""     method="POST"   api="create"/>
        <mapping uri="/:id" method="PUT"    api="modify"/>
        <mapping uri="/:id" method="GET"    api="view"/>
        <mapping uri="/:id" method="DELETE" api="remove"/>
        <mapping uri=""     method="GET"    api="viewAll"/>
    </resource-mapping>
</routing-config>
```

Ensure to create the `EmployeeHandler.java` and the model class `Employee.java`


**Step 5:** Create the container class.

```
import org.javalabs.decl.vertx.container.VertxContainer;

public class TestContainer extends VertxContainer {

    public TestContainer() {
        super();
    }

    @Override
    protected void preDeploy() {
        // Add initialization code just before deploying the verticles.
    }

    @Override
    protected void postDeploy() {
        // Post deployment code.
    }
}
```

**Step 6:** Finally the main class.

```
public class TestApp {

    public static void main(String[] args) {
        Container container = new TestContainer();
        container.setup(new ContainerConfig());
    }
}
```

**Step 7:** Compile and Execute

Compile the project using maven and run. Once the server is started you will see the below log.

```
[main] INFO org.javalabs.decl.vertx.config.Routematic - Route:
(1) /api/v1/employees
	[POST]     true
	[PUT]  /:id  true
	[GET]  /:id  true
	[DELETE]  /:id  true
	[GET]     true


Started Http Server. Listening to port: 8080
```

<a name="app"/>

## Conclusion

In Vert.x REST, a `handler class` is a dedicated class that implements the Handler interface, providing a structured
 way to handle requests, while a `lambda expression` is a concise, inline function used to directly define the request
 handling logic within the routing code, often preferred for simpler operations due to its brevity and readability;
 both are used to process incoming requests but differ in terms of code organization and complexity.

### Key Differences

1. Code Structure:
A handler class is a separate class with a defined handle method, allowing for more complex logic with potential helper methods, while a lambda expression is a short, anonymous function embedded directly in the routing code. 
1. Readability:
For simple operations, lambda expressions are often considered more readable due to their concise syntax. 
1. Reusability:
A handler class can be reused across different routes if the logic is generic, while a lambda might be specific to a particular route. 

### When to use a handler class

1. Complex logic:
When the request handling involves multiple steps, conditional checks, database interactions, or other intricate operations, creating a dedicated handler class provides better organization and maintainability.
1. Code separation:
If you want to separate the routing logic from the actual request processing, using a handler class can help maintain a clean separation of concerns. 

### When to use a lambda expression

1. Simple operations:
For basic tasks like returning a static response, performing simple calculations, or basic data manipulation, a lambda expression can be a more concise and readable choice.
1. Inline logic:
When you want to define the request handling behavior directly within the route definition, using a lambda can improve code flow. 
