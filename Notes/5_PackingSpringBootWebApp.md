<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.jb</groupId>
    <artifactId>rest-demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>rest-demo</name>
    <description>Demo project for Spring Boot</description>
    <url/>
    <licenses>
        <license/>
    </licenses>
    <developers>
        <developer/>
    </developers>
    <scm>
        <connection/>
        <developerConnection/>
        <tag/>
        <url/>
    </scm>
    <properties>
        <java.version>21</java.version>
   <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
        
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
    <finalName>rest-demo</finalName>
        <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
             <!-- Use a stable version -->
            <configuration>
                <source>21</source>
                <target>21</target>
            </configuration>
        </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
-------------------------------------------------------------------
Hello Controller
package com.jb.rest_demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //return json format
public class HelloController {
    @GetMapping("/hello")
    private String greet()
    {
        return "Hello World";
    }
}

-----------------------------------------------------------------------
Check application by running
Then stop
Eclipse:
Run as -> Maven clean
Run as -> Maven Build -> goals: package
Terminal 

------------------------------------------------------------------------------------
PS E:\TMachineTraining\docker\rest-demo> java -jar target/rest-demo.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-04-01T14:28:25.073+05:30  INFO 13552 --- [rest-demo] [           main] com.jb.rest_demo.RestDemoApplication     : Starting RestDemoApplication v0.0.1-SNAPSHOT using Java 24 with PID 13552 (E:\TMachineTraining\docker\rest-demo\target\rest-demo.jar started by tharu in E:\TMachineTraining\docker\rest-demo)
2025-04-01T14:28:25.076+05:30  INFO 13552 --- [rest-demo] [           main] com.jb.rest_demo.RestDemoApplication     : No active profile set, falling back to 1 default profile: "default"
2025-04-01T14:28:25.863+05:30  INFO 13552 --- [rest-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-04-01T14:28:25.875+05:30  INFO 13552 --- [rest-demo] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-04-01T14:28:25.876+05:30  INFO 13552 --- [rest-demo] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
2025-04-01T14:28:25.903+05:30  INFO 13552 --- [rest-demo] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-04-01T14:28:25.904+05:30  INFO 13552 --- [rest-demo] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 780 ms
2025-04-01T14:28:26.256+05:30  INFO 13552 --- [rest-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-04-01T14:28:26.275+05:30  INFO 13552 --- [rest-demo] [           main] com.jb.rest_demo.RestDemoApplication     : Started RestDemoApplication in 1.61 seconds (process running for 1.985)

----------------------------------------------------------------------------
http://localhost:8080/hello 

----------------------------------------------------------------------------
