the executable war with embedded jetty
=====
The project is created by __Eclipse Indigo__  
Project name : __jettyExam__  
Environment requirment : __Maven 3.0.4__  

The main function is defined in `"jettyExam/src/main/java/Runner.java"`. It is responsible to create a Jetty Server.  
The servlet app is in `"jettyExam/src/main/java/hello/app/HelloWorldServlet.java"`.  
The map which is to communicate url and servlet app is defined in `"jettyExam/src/main/webapp/WEB-INF/web.xml"`.  

The example dosen't support JSP, because some jar file is not included.  
The main effort is to maintain `"jettyExam/pom.xml"`:  
In order to source code is compiled successfully, the dependency is key point.  

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
 
Meanwhile, `"provided"` can avoid these jar files to be packaged into war file.    

If JSP need be supported, the following dependency should be contained:    

               <dependency>
                 <groupId>org.eclipse.jetty.orbit</groupId>
                 <artifactId>org.apache.jasper.glassfish</artifactId>
                 <version>2.2.2.v201112011158</version>
                 <scope>provided</scope>
               </dependency>
               <dependency>
                 <groupId>org.eclipse.jetty.orbit</groupId>
                 <artifactId>javax.el</artifactId>
                 <version>2.2.0.v201108011116</version>
                 <scope>provided</scope>
               </dependency>
The war file would increase 800KB size, if JSP dependency is contained.     
So it suggest to comment the JSP dependency.    

In addition, some plugins are essential.    
__maven-war-plugin__ will define "main" class in _MANIFEST.MF_.    
__maven-antrun-plugin__ will move the "main" class to the root path of war file.  
__maven-dependency-plugin__ will decompress the dependency jar files.  

After perform "run"->"run as"->"maven install" in Eclipse, the `jettyExam.war` can be found in the target fold.   
now we can run `java -jar -Dport=10080 jettyExam.war` and check the result via browsing `http://localhost:10080`    

reference:    
[Step by step: Executable WAR files](http://internna.blogspot.com/2011/08/step-by-step-executable-war-files.html)    
Pay attention, there is wrong in the article.

