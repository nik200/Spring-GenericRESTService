# Spring-GenericRESTService

This project involves three parts.
1. Creating a generic sprong-boot application which will provide a web interface to our service API's and capability to run as standalone application from any server..with JRE ;)
2. Implementing our Web Service API's. This step will automatically plug our business logic and service implementation.
3. Creating an Admin service for our application monitoring.

## PART 1 : Creating a generic Spring-boot application.

This part walks through setting up Maven and building a self contained executable JAR for SpringBootGenericService project.
Pre-build jar can be used from the Git repository if no further extensions/modifications are required in the Spring-boot part of the application.

###Setting up Maven

1. Download maven bin (https://maven.apache.org/download.cgi) and unzip to a folder with no spaces in folder name. 
   In our example we got following folder `C:\Spring-workspace\apache-maven-3.3.9\bin`

2. Add the bin directory of the created directory apache-maven-3.3.9 to the PATH environment variable
   To verify, execute `mvn -v` command  in a cmd prompt. The result should look similar to - 
C:\Spring-workspace\SpringBootGenericService>mvn -v
```bash
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T10:41:47-06:00)
Maven home: C:\Spring-workspace\apache-maven-3.3.9\bin\..
Java version: 1.7.0_07, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.7.0_07\jre
Default locale: en_IN, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "amd64", family: "windows"
```
###Creating a Maven project
		
3. Create a project root directory. Ex. `C:\Spring-workspace\SpringBootGenericService`

Note : For our example we will need to place `impl.jar` to the location `C:\Spring-workspace\SpringBootGenericService\lib`. Explaination for the same in PART 2.

4. Create a `pom.xml` file for adding Maven dependencies. Add the file to the project root directory. At this point we are good to create our build, but without main class, the build will fail.
	To ceate build, run `mvn package` command fom project root folder. A target folder will get created in the project root.
	
###Creating Maven enabled Spring-boot application

5. Maven will compile sources from `src/main/java` by default so you need to create that folder structure within project root directory.
   Ex. `util.generic.service` package was created with .java files. `SpringBootGenericServiceApplication.java` will be the main class in our example.

6. To execute the project, run `mvn spring-boot:run` command from project root directry. Application will be started with default properties (port 8080).
   You can add `application.properties` file to  `C:\Spring-workspace\SpringBootGenericService\src\main\resources` folder. This file will be packaged in the JAR we'll be creating in next step.

###Packaging and Stand-alone execution

7. To build an executable jar for the project, execute `mvn package` command from project root directory.
   jar file `C:\Spring-workspace\SpringBootGenericService\target\generic-0.0.1-SNAPSHOT.jar` will be created.
   
8. To execute the above jar execute command `java -jar target\generic-0.0.1-SNAPSHOT.jar` from project root.

##PART 2 : Implementing Web Service API's

To implement our API's and plugging them to the generic web service which we created in Part 1, we'll need to create a simple java project with `generic.spring.implementations.GenericSpringService` class.
This class should atleast define two static methods - 
```java
public static String baseMethod(String serviceName, String operationName, String soapAction,String postString){}
public static Object getMonitorObject(){}
```
These methods are kind of callback methods which will be imvoked our generic web service. A dummy `generic.spring.implementations.GenericSpringService` class is required to be in Maven dependency for the build to complete successfully in Part 1.

```xml
<dependency>
    	<groupId>impl</groupId>
    	<artifactId>Implementation</artifactId>
    	<version>1.0</version>
    	<scope>system</scope>
	<systemPath>C:/Spring-workspace/SpringBootGenericService/lib/impl.jar</systemPath>
</dependency>
```

###Service API
The generic web service created in Part 1, exposes a URI `/RestWebService/{serviceName}/{operationName}` which accepts `POST` requests of content-type `application/xml` and responds back in the same format.
An HTTP header property, `SoapAction` with default value `"na"` so that SOAP service can be implemented with this API.
The value of URI parameters `serviceName`,`operationName`, the POST data `postString` and the header field `SoapAction` will be provided to `baseMethod`. Implementation of this method should ensure that a valid XML is returned back.

###Management API
Application property `management.custom.endpoint` can be used to define a custom endpoint for retrieving status details of the application. `getMonitorObject()` method definition provides the implementation to this service
Generic web service created in Part 1 will respond back with the JSON representation of the object returned by `getMonitorObject()` method when `management.custom.endpoint` is invoked.
 
##PART 3 : Admin console for Web application 
	
	


