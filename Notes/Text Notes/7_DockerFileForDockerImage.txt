FROM openjdk:22-jdk
ADD target/rest-demo.jar rest-demo.jar
ENTRYPOINT [ "java","-jar","/rest-demo.jar" ]

--------------------------------------------------------------------------------
E:\TMachineTraining\docker\rest-demo>docker build -t jayabalajeesk4/rest-demo:v31 . 
[+] Building 4.2s (8/8) FINISHED                                                                                                       docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                   0.0s
 => => transferring dockerfile: 143B                                                                                                                   0.0s 
 => [internal] load metadata for docker.io/library/openjdk:22-jdk                                                                                      0.0s 
 => [internal] load .dockerignore                                                                                                                      0.0s 
 => => transferring context: 2B                                                                                                                        0.0s 
 => [internal] load build context                                                                                                                      0.6s 
 => => transferring context: 20.75MB                                                                                                                   0.5s
 => [1/2] FROM docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                3.0s 
 => => resolve docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                3.0s 
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                         0.0s 
 => [2/2] ADD target/rest-demo.jar rest-demo.jar                                                                                                       0.1s 
 => exporting to image                                                                                                                                 0.9s 
 => => exporting layers                                                                                                                                0.7s 
 => => exporting manifest sha256:99393b5fd8293617b626510cbf62c12d6bbec7b7b16fc2b04c09b9b2106b95aa                                                      0.0s 
 => => exporting config sha256:b5e87c9d0dc29f1aa520d3585c77768dd91f2141ef62f8cf13e75b6c194af473                                                        0.0s 
 => => exporting attestation manifest sha256:df49c4a229c27def506d47f2972dbd683a780400016eb86e1f1539c904cc5549                                          0.0s 
 => => exporting manifest list sha256:b786ad82ba42bbd0daccf5f6f726f0c787e2f1014e755b8eedaf7f25750ab3d7                                                 0.0s 
 => => naming to docker.io/jayabalajeesk4/rest-demo:v31                                                                                                0.0s 
 => => unpacking to docker.io/jayabalajeesk4/rest-demo:v31                                                                                             0.1s 

View build details: docker-desktop://dashboard/build/desktop-linux/desktop-linux/roquktky6f6vs3zlhzsj4yvrr

--------------------------------------------------------------
E:\TMachineTraining\docker\rest-demo>docker run -p 8080:8080 jayabalajeesk4/rest-demo:v31

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-04-01T10:06:03.197Z  INFO 1 --- [rest-demo] [           main] com.jb.rest_demo.RestDemoApplication     : Starting RestDemoApplication v0.0.1-SNAPSHOT using Java 22 with PID 1 (/rest-demo.jar started by root in /)
2025-04-01T10:06:03.201Z  INFO 1 --- [rest-demo] [           main] com.jb.rest_demo.RestDemoApplication     : No active profile set, falling back to 1 default profile: "default"
2025-04-01T10:06:04.121Z  INFO 1 --- [rest-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-04-01T10:06:04.136Z  INFO 1 --- [rest-demo] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-04-01T10:06:04.136Z  INFO 1 --- [rest-demo] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
2025-04-01T10:06:04.165Z  INFO 1 --- [rest-demo] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-04-01T10:06:04.167Z  INFO 1 --- [rest-demo] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 908 ms
2025-04-01T10:06:04.476Z  INFO 1 --- [rest-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-04-01T10:06:04.494Z  INFO 1 --- [rest-demo] [           main] com.jb.rest_demo.RestDemoApplication     : Started RestDemoApplication in 1.782 seconds (process running for 2.26)
2025-04-01T10:06:13.128Z  INFO 1 --- [rest-demo] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-04-01T10:06:13.128Z  INFO 1 --- [rest-demo] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'      
2025-04-01T10:06:13.129Z  INFO 1 --- [rest-demo] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms