the executable war with embedded jetty
=====
The project is created by Eclipse.
Project name : jettyExam
Environment requirment : Maven 3.0.4

The main function is defined in "jettyExam/src/main/java/Runner.java". It is responsible to create a Jetty Server.
The servlet app is in "jettyExam/src/main/java/hello/app/HelloWorldServlet.java".
The map which is communicate url and servlet app is defined in "jettyExam/src/main/webapp/WEB-INF/web.xml"

The example dosen't support JSP, because some jar file is not included.
The main effort is to maintain "jettyExam/pom.xml":
In order to source code is compiled successfully, the dependency is key.
    <dependency>
      <groupId>org.eclipse.jetty</groupId>
    	<artifactId>jetty-server</artifactId>
    	<version>${jettyVersion}</version>
    	<scope>provided</scope>
    </dependency>
    <dependency>
    	<groupId>org.eclipse.jetty</groupId>
    	<artifactId>jetty-webapp</artifactId>
    	<version>${jettyVersion}</version>
    	<scope>provided</scope>
    </dependency>
Meanwhile, "provided" can avoid the jar file to be packaged into war file.


