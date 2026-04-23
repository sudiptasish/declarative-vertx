## Table of Contents  
- [What is Java Agent](#ja)  
- [Oracle Attach API](#ap) 
- [What Purpose does it Solve](#wp) 
- [How to Run](#hr)
- [JDI and Vert.x](#jv)
- [Appendix](#app)


<a name="ja"/>

## What is Java Agent

A Java agent is a class that can modify the bytecode of applications running on the Java Virtual Machine (JVM). 
Java agents are part of the Java Instrumentation API, which allows for changes to an application without editing its source code.

<a name="ap"/>

## Oracle Attach API

From Oracle Wiki:
```
The Attach API is an extension that provides a mechanism to attach to a Java virtual machine. 
A tool written in the Java Language, uses this API to attach to a target virtual machine and load its tool agent into that virtual 
machine. For example, a management console might have a management agent which it uses to obtain management information from 
instrumented objects in a virtual machine. If the management console is required to manage an application that is running in a 
virtual machine that does not include the management agent, then this API can be used to attach to the target virtual machine and 
load the agent.
```

We will be using the capability of (Attach API)[https://docs.oracle.com/javase/8/docs/jdk/api/attach/spec/index.html] to load the agent during runtime.
The agent will crawl through the code to find out the registered REST resources and generate the `openapi.yaml`.

If you are interested in contributing towards this utility, visit our [CONTRIBUTING.md](CONTRIBUTING.md) file.

<a name="wp"/>

## What Purpose does it Solve

`ecm-swagger-agent` utility uses the java attach API to connect to a remote JVM. It then crawl through the code to identify the REST
resources and generate the openapi compliant swagger documentation. The generated file `openapi.yaml` will be created in the same directory
of the target vm.


<a name="hr"/>

## How to Run

Pre-Requisites:
1. An already running springboot or jaxrs compliant application in the same machine.

Ensure the application is started with `agentlib` enabled.
```
java -jar target/spring-rest-0.0.1-SNAPSHOT.jar
```

2. Connect to target vm by starting the agent.

From `ecm-swagger-agent` directory, execute the below commnd:

```
java -jar target/ecm-swagger-agent-0.0.1-SNAPSHOT.jar\
     -p 41068\
     -a /Users/schan280/Amex_Projects/github/ecm-platform-provider/ecm-swagger-agent/target/ecm-swagger-agent-0.0.1-SNAPSHOT.jar\
     -t spring\
     -k com.example.rest.handler\
     -o /Users/schan280/Projects/openapi.yaml
```

| Option   | Description   |   Mandatory   |
| --------------|------------|----------------
| -p | Process id of the target vm | Y |
| -a | Complete path of the swagger agent | Y |
| -t | Tech stack of target vm. Valid values are: spring, jaxrs, vertx | Y |
| -k | Package name that has the rest resources (handler/controller files)  | Y |
| -o | Complete path of the to-be-generated openapi file  | Y |

<a name="jv"/>

## JDI and Vert.x

Unlike `Springboot` and `Jax-Rs`, `Vert.x` does not follow any declarative approach, hence we cannot leverage the `Oracle's Attach API` for crawling.

### JDI in Action

#### JPDA

JPDA stands for "Java Platform Debugger Architecture," which is a framework within the Java development environment that allows developers to create debugging tools for Java applications.

JPDA Structure:
JPDA consists of three main components:

1. JVM Tool Interface (JVMTI): A low-level interface that the Java Virtual Machine (JVM) exposes for debugging.
1. Java Debug Wire Protocol (JDWP): A communication protocol that defines how debugging information is exchanged between the debugger and the JVM.
1. Java Debug Interface (JDI): A high-level Java API that developers use to interact with the debugging process, built on top of JDWP.

#### JDI

JDI, which is part of JPDA, represents the "Java Debug Interface," a high-level API that developers use to interact with a running Java program for debugging purposes, providing a user-friendly way to control the debugging process without dealing with low-level details.
It provides a convenient way to set breakpoints, examine variables, step through code, and perform other debugging operations.

#### Crawl a Vert.x Application

1. Make sure the target application is started with `agentlib` enabled.
```
java -agentlib:jdwp=transport=dt_socket,server=y,address=localhost:9792,suspend=n -jar target/spring-rest-0.0.1-SNAPSHOT.jar
```

**Note:** `agentlib` is a JVM startup parameter used to load a native library (like a debugging agent) when the JVM starts, 
while `runjdwp` is a specific command-line option used to explicitly start the Java Debug Wire Protocol (JDWP) agent, 
essentially enabling debugging capabilities for a Java application; "agentlib" is a more general term that can be used to 
load various types of agents, not just for debugging, while "runjdwp" is specifically focused on debugging with `JDWP`.

2. Start the Agent

```
java -jar target/ecm-swagger-agent-0.0.1-SNAPSHOT.jar -h localhost -r 9792 -jdi
```

<a name="app"/>

## Appendix