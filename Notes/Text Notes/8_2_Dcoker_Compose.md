INSERT INTO students (name, age) VALUES ('jaya', 22);
INSERT INTO students (name, age) VALUES ('bala', 23);
INSERT INTO students (name, age) VALUES ('jayabala', 21);
INSERT INTO students (name, age) VALUES ('tharun', 20);
INSERT INTO students (name, age) VALUES ('jb', 23);
INSERT INTO students (name, age) VALUES ('eva', 23);

------------------------------------------------------------------

FROM openjdk:22-jdk
ADD target/student-app.jar student-app.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","/student-app.jar" ]

-----------------------------------------------------------------

version: "3.7"

services:
  mysqldb:
    container_name: mysqldb
    image: mysql:8
    environment:
      MYSQL_ROOT_PASSWORD: tharunsk4
      MYSQL_USER: root
      MYSQL_PASSWORD: tharunsk4
      MYSQL_DATABASE: docker_db

    ports:
      - "3336:3306"
    volumes:
      - ./mysql-data:/var/lib/mysql    
    networks:
      - springboot-mysql-net  

  springboot-restful-webservices:
    container_name: springboot-restful-webservices
    build:
      context: ./
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    depends_on:
      - mysqldb
    environment:  
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
      - SPRING_DATASOURCE_URL=jdbc:mysql://mysqldb:3306/docker_db
      - SPRING_DATASOURCE_USERNAME=root
      - SPRING_DATASOURCE_PASSWORD=tharunsk4
      - SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
    networks:
      - springboot-mysql-net  
#    restart: always  # Ensuring service restarts on failure

networks:
  springboot-mysql-net:
    driver: bridge

-------------------------------------------------------------------------------------

E:\TMachineTraining\docker\student-app>docker-compose down       
time="2025-04-03T10:30:00+05:30" level=warning msg="E:\\TMachineTraining\\docker\\student-app\\docker-compose.yaml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
[+] Running 3/3
 ✔ Container springboot-restful-webservices  Removed                                                                                                                                                    0.0s 
 ✔ Container mysqldb                         Removed                                                                                                                                                    2.0s 
 ✔ Network student-app_springboot-mysql-net  Removed                                                                                                                                                    0.9s 

E:\TMachineTraining\docker\student-app>docker-compose up --build
time="2025-04-03T10:30:08+05:30" level=warning msg="E:\\TMachineTraining\\docker\\student-app\\docker-compose.yaml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
[+] Building 0.2s (8/8) FINISHED                                                                                                                                                        docker:desktop-linux
 => [springboot-restful-webservices internal] load build definition from Dockerfile                                                                                                                     0.0s
 => => transferring dockerfile: 162B                                                                                                                                                                    0.0s 
 => [springboot-restful-webservices internal] load metadata for docker.io/library/openjdk:22-jdk                                                                                                        0.0s 
 => [springboot-restful-webservices internal] load .dockerignore                                                                                                                                        0.0s 
 => => transferring context: 2B                                                                                                                                                                         0.0s 
 => [springboot-restful-webservices internal] load build context                                                                                                                                        0.0s 
 => => transferring context: 72B                                                                                                                                                                        0.0s 
 => [springboot-restful-webservices 1/2] FROM docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                                  0.0s 
 => => resolve docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                                                                 0.0s 
 => CACHED [springboot-restful-webservices 2/2] ADD target/student-app.jar student-app.jar                                                                                                              0.0s 
 => [springboot-restful-webservices] exporting to image                                                                                                                                                 0.1s 
 => => exporting layers                                                                                                                                                                                 0.0s 
 => => exporting manifest sha256:a1501affae54a647eae0bdd200eb3b9182179331d9c572d1c217335cb85b4369                                                                                                       0.0s 
 => => exporting config sha256:92ee74bc05716a02d9ab80963b79d91bfe52955f56e7c16db9b7c9a77934cfee                                                                                                         0.0s 
 => => exporting attestation manifest sha256:8e2c1a5f3b9541b9c6240e578c3011b75eeffe229f5be49e180988526ae79b87                                                                                           0.0s 
 => => exporting manifest list sha256:3510c636b2ebcce89d1e9a080c846d9951917ce5750cf0aadfe715b41a271aaf                                                                                                  0.0s 
 => => naming to docker.io/library/student-app-springboot-restful-webservices:latest                                                                                                                    0.0s
 => => unpacking to docker.io/library/student-app-springboot-restful-webservices:latest                                                                                                                 0.0s 
 => [springboot-restful-webservices] resolving provenance for metadata file                                                                                                                             0.0s 
[+] Running 4/4
 ✔ springboot-restful-webservices            Built                                                                                                                                                      0.0s 
 ✔ Network student-app_springboot-mysql-net  Created                                                                                                                                                    0.3s 
 ✔ Container mysqldb                         Created                                                                                                                                                    0.1s 
 ✔ Container springboot-restful-webservices  Created                                                                                                                                                    0.1s 
Attaching to mysqldb, springboot-restful-webservices
mysqldb                         | 2025-04-03 05:00:09+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.4.4-1.el9 started.
mysqldb                         | 2025-04-03 05:00:10+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
mysqldb                         | 2025-04-03 05:00:10+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.4.4-1.el9 started.
mysqldb                         | '/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'                                                                                                               
mysqldb                         | 2025-04-03T05:00:10.580267Z 0 [System] [MY-015015] [Server] MySQL Server - start.
mysqldb                         | 2025-04-03T05:00:10.806570Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 8.4.4) starting as process 1
mysqldb                         | 2025-04-03T05:00:10.810776Z 0 [Warning] [MY-010159] [Server] Setting lower_case_table_names=2 because file system for /var/lib/mysql/ is case insensitive                  
mysqldb                         | 2025-04-03T05:00:10.826508Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.                                                                             
springboot-restful-webservices  | 
springboot-restful-webservices  |   .   ____          _            __ _ _
springboot-restful-webservices  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
springboot-restful-webservices  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \                                                                                                                                  
springboot-restful-webservices  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )                                                                                                                                 
springboot-restful-webservices  |   '  |____| .__|_| |_|_| |_\__, | / / / /
springboot-restful-webservices  |  =========|_|==============|___/=/_/_/_/                                                                                                                                   
springboot-restful-webservices  |                                                                                                                                                                            
springboot-restful-webservices  |  :: Spring Boot ::                (v3.4.4)                                                                                                                                 
springboot-restful-webservices  | 
springboot-restful-webservices  | 2025-04-03T05:00:11.357Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : Starting StudentAppApplication v0.0.1-SNAPSHOT using Java 22 with PID 1 (/student-app.jar started by root in /)
springboot-restful-webservices  | 2025-04-03T05:00:11.360Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : No active profile set, falling back to 1 default profile: "default"
mysqldb                         | 2025-04-03T05:00:11.951025Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.                                                                               
springboot-restful-webservices  | 2025-04-03T05:00:12.158Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
springboot-restful-webservices  | 2025-04-03T05:00:12.218Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 45 ms. Found 1 JPA repository interface.
mysqldb                         | 2025-04-03T05:00:12.382326Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
mysqldb                         | 2025-04-03T05:00:12.382871Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
mysqldb                         | 2025-04-03T05:00:12.402079Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.
mysqldb                         | 2025-04-03T05:00:12.503614Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
mysqldb                         | 2025-04-03T05:00:12.503883Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.4.4'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.                                                                                                                                                                                 
springboot-restful-webservices  | 2025-04-03T05:00:12.698Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
springboot-restful-webservices  | 2025-04-03T05:00:12.722Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
springboot-restful-webservices  | 2025-04-03T05:00:12.722Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
springboot-restful-webservices  | 2025-04-03T05:00:12.747Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext                       
springboot-restful-webservices  | 2025-04-03T05:00:12.748Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1326 ms
springboot-restful-webservices  | 2025-04-03T05:00:12.895Z  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
springboot-restful-webservices  | 2025-04-03T05:00:12.936Z  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.6.11.Final
springboot-restful-webservices  | 2025-04-03T05:00:12.965Z  INFO 1 --- [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
springboot-restful-webservices  | 2025-04-03T05:00:13.197Z  INFO 1 --- [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
springboot-restful-webservices  | 2025-04-03T05:00:13.224Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
springboot-restful-webservices  | 2025-04-03T05:00:13.612Z  INFO 1 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@3db1ce78
springboot-restful-webservices  | 2025-04-03T05:00:13.613Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
springboot-restful-webservices  | 2025-04-03T05:00:13.654Z  WARN 1 --- [           main] org.hibernate.orm.deprecation            : HHH90000025: MySQL8Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
springboot-restful-webservices  | 2025-04-03T05:00:13.654Z  WARN 1 --- [           main] org.hibernate.orm.deprecation            : HHH90000026: MySQL8Dialect has been deprecated; use org.hibernate.dialect.MySQLDialect instead                                                                                                                                                                                        
springboot-restful-webservices  | 2025-04-03T05:00:13.671Z  INFO 1 --- [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
springboot-restful-webservices  |       Database JDBC URL [Connecting through datasource 'HikariDataSource (HikariPool-1)']
springboot-restful-webservices  |       Database driver: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Database version: 8.0
springboot-restful-webservices  |       Autocommit mode: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Isolation level: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Minimum pool size: undefined/unknown                                                                                                                                 
springboot-restful-webservices  |       Maximum pool size: undefined/unknown
springboot-restful-webservices  | 2025-04-03T05:00:14.230Z  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
springboot-restful-webservices  | Hibernate: create table students (id integer not null auto_increment, age integer not null, name varchar(255), primary key (id)) engine=InnoDB
springboot-restful-webservices  | 2025-04-03T05:00:14.289Z  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
springboot-restful-webservices  | 2025-04-03T05:00:14.508Z  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
springboot-restful-webservices  | 2025-04-03T05:00:14.833Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
springboot-restful-webservices  | 2025-04-03T05:00:14.854Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : Started StudentAppApplication in 4.106 seconds (process running for 4.653)
springboot-restful-webservices  | 2025-04-03T05:00:33.872Z  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
springboot-restful-webservices  | 2025-04-03T05:00:33.872Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
springboot-restful-webservices  | 2025-04-03T05:00:33.874Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms                                         
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0                                                                                                            
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0

-------------------------------------------------------
PS C:\Users\tharu> docker exec -it mysqldb mysql -u root -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 42
Server version: 8.4.4 MySQL Community Server - GPL

Copyright (c) 2000, 2025, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| docker_db          |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.01 sec)

mysql> use docker_db;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> select * from students;
+----+-----+------+
| id | age | name |
+----+-----+------+
|  1 |  31 | jaya |
+----+-----+------+
1 row in set (0.00 sec)

mysql>
-------------------------------------------------------------------------------------

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+---------------------+
| Database            |
+---------------------+
| banking_app         |
| banking_appbp       |
| docker_db           |
| ecom                |
| ecombp              |
| employee_db         |
| ems_db              |
| face_recognizer     |
| information_schema  |
| java                |
| job_app_rest        |
| mysql               |
| performance_schema  |
| portfolio_db        |
| sakila              |
| security_demo       |
| sms                 |
| smsbp               |
| sys                 |
| todo_management_app |
| tododb              |
| world               |
+---------------------+
22 rows in set (0.02 sec)

mysql> use docker_db;
Database changed
mysql> select * from students;
+----+-----+----------+
| id | age | name     |
+----+-----+----------+
|  1 |  22 | jaya     |
|  2 |  23 | bala     |
|  3 |  21 | jayabala |
|  4 |  20 | tharun   |
|  5 |  23 | jb       |
|  6 |  23 | eva      |
+----+-----+----------+
6 rows in set (0.01 sec)
------------------------------------------------------------
E:\TMachineTraining\docker\student-app>docker-compose down       
time="2025-04-03T10:30:00+05:30" level=warning msg="E:\\TMachineTraining\\docker\\student-app\\docker-compose.yaml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
[+] Running 3/3
 ✔ Container springboot-restful-webservices  Removed                                                                                                                                                    0.0s 
 ✔ Container mysqldb                         Removed                                                                                                                                                    2.0s 
 ✔ Network student-app_springboot-mysql-net  Removed                                                                                                                                                    0.9s 

E:\TMachineTraining\docker\student-app>docker-compose up --build
time="2025-04-03T10:30:08+05:30" level=warning msg="E:\\TMachineTraining\\docker\\student-app\\docker-compose.yaml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
[+] Building 0.2s (8/8) FINISHED                                                                                                                                                        docker:desktop-linux
 => [springboot-restful-webservices internal] load build definition from Dockerfile                                                                                                                     0.0s
 => => transferring dockerfile: 162B                                                                                                                                                                    0.0s 
 => [springboot-restful-webservices internal] load metadata for docker.io/library/openjdk:22-jdk                                                                                                        0.0s 
 => [springboot-restful-webservices internal] load .dockerignore                                                                                                                                        0.0s 
 => => transferring context: 2B                                                                                                                                                                         0.0s 
 => [springboot-restful-webservices internal] load build context                                                                                                                                        0.0s 
 => => transferring context: 72B                                                                                                                                                                        0.0s 
 => [springboot-restful-webservices 1/2] FROM docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                                  0.0s 
 => => resolve docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                                                                 0.0s 
 => CACHED [springboot-restful-webservices 2/2] ADD target/student-app.jar student-app.jar                                                                                                              0.0s 
 => [springboot-restful-webservices] exporting to image                                                                                                                                                 0.1s 
 => => exporting layers                                                                                                                                                                                 0.0s 
 => => exporting manifest sha256:a1501affae54a647eae0bdd200eb3b9182179331d9c572d1c217335cb85b4369                                                                                                       0.0s 
 => => exporting config sha256:92ee74bc05716a02d9ab80963b79d91bfe52955f56e7c16db9b7c9a77934cfee                                                                                                         0.0s 
 => => exporting attestation manifest sha256:8e2c1a5f3b9541b9c6240e578c3011b75eeffe229f5be49e180988526ae79b87                                                                                           0.0s 
 => => exporting manifest list sha256:3510c636b2ebcce89d1e9a080c846d9951917ce5750cf0aadfe715b41a271aaf                                                                                                  0.0s 
 => => naming to docker.io/library/student-app-springboot-restful-webservices:latest                                                                                                                    0.0s
 => => unpacking to docker.io/library/student-app-springboot-restful-webservices:latest                                                                                                                 0.0s 
 => [springboot-restful-webservices] resolving provenance for metadata file                                                                                                                             0.0s 
[+] Running 4/4
 ✔ springboot-restful-webservices            Built                                                                                                                                                      0.0s 
 ✔ Network student-app_springboot-mysql-net  Created                                                                                                                                                    0.3s 
 ✔ Container mysqldb                         Created                                                                                                                                                    0.1s 
 ✔ Container springboot-restful-webservices  Created                                                                                                                                                    0.1s 
Attaching to mysqldb, springboot-restful-webservices
mysqldb                         | 2025-04-03 05:00:09+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.4.4-1.el9 started.
mysqldb                         | 2025-04-03 05:00:10+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
mysqldb                         | 2025-04-03 05:00:10+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.4.4-1.el9 started.
mysqldb                         | '/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'                                                                                                               
mysqldb                         | 2025-04-03T05:00:10.580267Z 0 [System] [MY-015015] [Server] MySQL Server - start.
mysqldb                         | 2025-04-03T05:00:10.806570Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 8.4.4) starting as process 1
mysqldb                         | 2025-04-03T05:00:10.810776Z 0 [Warning] [MY-010159] [Server] Setting lower_case_table_names=2 because file system for /var/lib/mysql/ is case insensitive                  
mysqldb                         | 2025-04-03T05:00:10.826508Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.                                                                             
springboot-restful-webservices  | 
springboot-restful-webservices  |   .   ____          _            __ _ _
springboot-restful-webservices  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
springboot-restful-webservices  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \                                                                                                                                  
springboot-restful-webservices  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )                                                                                                                                 
springboot-restful-webservices  |   '  |____| .__|_| |_|_| |_\__, | / / / /
springboot-restful-webservices  |  =========|_|==============|___/=/_/_/_/                                                                                                                                   
springboot-restful-webservices  |                                                                                                                                                                            
springboot-restful-webservices  |  :: Spring Boot ::                (v3.4.4)                                                                                                                                 
springboot-restful-webservices  | 
springboot-restful-webservices  | 2025-04-03T05:00:11.357Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : Starting StudentAppApplication v0.0.1-SNAPSHOT using Java 22 with PID 1 (/student-app.jar started by root in /)
springboot-restful-webservices  | 2025-04-03T05:00:11.360Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : No active profile set, falling back to 1 default profile: "default"
mysqldb                         | 2025-04-03T05:00:11.951025Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.                                                                               
springboot-restful-webservices  | 2025-04-03T05:00:12.158Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
springboot-restful-webservices  | 2025-04-03T05:00:12.218Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 45 ms. Found 1 JPA repository interface.
mysqldb                         | 2025-04-03T05:00:12.382326Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
mysqldb                         | 2025-04-03T05:00:12.382871Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
mysqldb                         | 2025-04-03T05:00:12.402079Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.
mysqldb                         | 2025-04-03T05:00:12.503614Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
mysqldb                         | 2025-04-03T05:00:12.503883Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.4.4'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.                                                                                                                                                                                 
springboot-restful-webservices  | 2025-04-03T05:00:12.698Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
springboot-restful-webservices  | 2025-04-03T05:00:12.722Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
springboot-restful-webservices  | 2025-04-03T05:00:12.722Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
springboot-restful-webservices  | 2025-04-03T05:00:12.747Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext                       
springboot-restful-webservices  | 2025-04-03T05:00:12.748Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1326 ms
springboot-restful-webservices  | 2025-04-03T05:00:12.895Z  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
springboot-restful-webservices  | 2025-04-03T05:00:12.936Z  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.6.11.Final
springboot-restful-webservices  | 2025-04-03T05:00:12.965Z  INFO 1 --- [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
springboot-restful-webservices  | 2025-04-03T05:00:13.197Z  INFO 1 --- [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
springboot-restful-webservices  | 2025-04-03T05:00:13.224Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
springboot-restful-webservices  | 2025-04-03T05:00:13.612Z  INFO 1 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@3db1ce78
springboot-restful-webservices  | 2025-04-03T05:00:13.613Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
springboot-restful-webservices  | 2025-04-03T05:00:13.654Z  WARN 1 --- [           main] org.hibernate.orm.deprecation            : HHH90000025: MySQL8Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
springboot-restful-webservices  | 2025-04-03T05:00:13.654Z  WARN 1 --- [           main] org.hibernate.orm.deprecation            : HHH90000026: MySQL8Dialect has been deprecated; use org.hibernate.dialect.MySQLDialect instead                                                                                                                                                                                        
springboot-restful-webservices  | 2025-04-03T05:00:13.671Z  INFO 1 --- [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
springboot-restful-webservices  |       Database JDBC URL [Connecting through datasource 'HikariDataSource (HikariPool-1)']
springboot-restful-webservices  |       Database driver: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Database version: 8.0
springboot-restful-webservices  |       Autocommit mode: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Isolation level: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Minimum pool size: undefined/unknown                                                                                                                                 
springboot-restful-webservices  |       Maximum pool size: undefined/unknown
springboot-restful-webservices  | 2025-04-03T05:00:14.230Z  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
springboot-restful-webservices  | Hibernate: create table students (id integer not null auto_increment, age integer not null, name varchar(255), primary key (id)) engine=InnoDB
springboot-restful-webservices  | 2025-04-03T05:00:14.289Z  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
springboot-restful-webservices  | 2025-04-03T05:00:14.508Z  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
springboot-restful-webservices  | 2025-04-03T05:00:14.833Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
springboot-restful-webservices  | 2025-04-03T05:00:14.854Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : Started StudentAppApplication in 4.106 seconds (process running for 4.653)
springboot-restful-webservices  | 2025-04-03T05:00:33.872Z  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
springboot-restful-webservices  | 2025-04-03T05:00:33.872Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
springboot-restful-webservices  | 2025-04-03T05:00:33.874Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms                                         
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0                                                                                                            
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0
Gracefully stopping... (press Ctrl+C again to force)
[+] Stopping 2/2
 ✔ Container springboot-restful-webservices  Stopped                                                                                                                                                    0.8s 
 ✔ Container mysqldb                         Stopped                                                                                                                                                    4.5s 
^C
E:\TMachineTraining\docker\student-app>docker-compose down       
time="2025-04-03T12:23:38+05:30" level=warning msg="E:\\TMachineTraining\\docker\\student-app\\docker-compose.yaml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
[+] Running 3/3
 ✔ Container springboot-restful-webservices  Removed                                                                                                                                                    0.1s 
 ✔ Container mysqldb                         Removed                                                                                                                                                    0.0s 
 ✔ Network student-app_springboot-mysql-net  Removed                                                                                                                                                    1.0s 

E:\TMachineTraining\docker\student-app>docker-compose up --build
time="2025-04-03T12:23:42+05:30" level=warning msg="E:\\TMachineTraining\\docker\\student-app\\docker-compose.yaml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
[+] Building 3.5s (9/9) FINISHED                                                                                                                                                        docker:desktop-linux
 => [springboot-restful-webservices internal] load build definition from Dockerfile                                                                                                                     0.0s
 => => transferring dockerfile: 162B                                                                                                                                                                    0.0s 
 => [springboot-restful-webservices internal] load metadata for docker.io/library/openjdk:22-jdk                                                                                                        0.0s 
 => [springboot-restful-webservices internal] load .dockerignore                                                                                                                                        0.0s 
 => => transferring context: 2B                                                                                                                                                                         0.0s 
 => [springboot-restful-webservices internal] load build context                                                                                                                                        0.0s 
 => => transferring context: 72B                                                                                                                                                                        0.0s 
 => [springboot-restful-webservices 1/2] FROM docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                                  3.2s 
 => => resolve docker.io/library/openjdk:22-jdk@sha256:b7d44427f4622d3f6b9a60583e5218ecfa8b4e44f3e01dfd0d9b7d7abba31c9a                                                                                 3.2s 
 => [springboot-restful-webservices auth] library/openjdk:pull token for registry-1.docker.io                                                                                                           0.0s
 => CACHED [springboot-restful-webservices 2/2] ADD target/student-app.jar student-app.jar                                                                                                              0.0s
 => [springboot-restful-webservices] exporting to image                                                                                                                                                 0.1s 
 => => exporting layers                                                                                                                                                                                 0.0s 
 => => exporting manifest sha256:a1501affae54a647eae0bdd200eb3b9182179331d9c572d1c217335cb85b4369                                                                                                       0.0s 
 => => exporting config sha256:92ee74bc05716a02d9ab80963b79d91bfe52955f56e7c16db9b7c9a77934cfee                                                                                                         0.0s 
 => => exporting attestation manifest sha256:16cc248a1e44db84820d72bfa0b0cde5a330ef0a2ef2afe5a4679d0327e4cdb6                                                                                           0.0s 
 => => exporting manifest list sha256:f5882efeebf29918a0bc5f55f472e0d83f9f9f2156dc5a7c79c660ed9306112f                                                                                                  0.0s 
 => => naming to docker.io/library/student-app-springboot-restful-webservices:latest                                                                                                                    0.0s 
 => => unpacking to docker.io/library/student-app-springboot-restful-webservices:latest                                                                                                                 0.0s 
 => [springboot-restful-webservices] resolving provenance for metadata file                                                                                                                             0.0s 
[+] Running 4/4
 ✔ springboot-restful-webservices            Built                                                                                                                                                      0.0s 
 ✔ Network student-app_springboot-mysql-net  Created                                                                                                                                                    0.2s 
 ✔ Container mysqldb                         Created                                                                                                                                                    0.1s 
 ✔ Container springboot-restful-webservices  Created                                                                                                                                                    0.1s 
Attaching to mysqldb, springboot-restful-webservices
mysqldb                         | 2025-04-03 06:53:47+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.4.4-1.el9 started.
mysqldb                         | 2025-04-03 06:53:48+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
mysqldb                         | 2025-04-03 06:53:48+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.4.4-1.el9 started.
mysqldb                         | '/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'
mysqldb                         | 2025-04-03T06:53:48.555788Z 0 [System] [MY-015015] [Server] MySQL Server - start.
mysqldb                         | 2025-04-03T06:53:48.956990Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 8.4.4) starting as process 1
mysqldb                         | 2025-04-03T06:53:48.961418Z 0 [Warning] [MY-010159] [Server] Setting lower_case_table_names=2 because file system for /var/lib/mysql/ is case insensitive                  
mysqldb                         | 2025-04-03T06:53:48.980644Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
springboot-restful-webservices  |                                                                                                                                                                            
springboot-restful-webservices  |   .   ____          _            __ _ _
springboot-restful-webservices  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \                                                                                                                                   
springboot-restful-webservices  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \                                                                                                                                  
springboot-restful-webservices  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
springboot-restful-webservices  |   '  |____| .__|_| |_|_| |_\__, | / / / /                                                                                                                                  
springboot-restful-webservices  |  =========|_|==============|___/=/_/_/_/
springboot-restful-webservices  |                                                                                                                                                                            
springboot-restful-webservices  |  :: Spring Boot ::                (v3.4.4)
springboot-restful-webservices  | 
springboot-restful-webservices  | 2025-04-03T06:53:49.339Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : Starting StudentAppApplication v0.0.1-SNAPSHOT using Java 22 with PID 1 (/student-app.jar started by root in /)
springboot-restful-webservices  | 2025-04-03T06:53:49.342Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : No active profile set, falling back to 1 default profile: "default"
mysqldb                         | 2025-04-03T06:53:50.224082Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.                                                                               
springboot-restful-webservices  | 2025-04-03T06:53:50.233Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
springboot-restful-webservices  | 2025-04-03T06:53:50.300Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 53 ms. Found 1 JPA repository interface.
mysqldb                         | 2025-04-03T06:53:50.801453Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
mysqldb                         | 2025-04-03T06:53:50.801909Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
springboot-restful-webservices  | 2025-04-03T06:53:50.809Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)                                 
mysqldb                         | 2025-04-03T06:53:50.816420Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.                                                                                                                                                                      
springboot-restful-webservices  | 2025-04-03T06:53:50.834Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
springboot-restful-webservices  | 2025-04-03T06:53:50.834Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
springboot-restful-webservices  | 2025-04-03T06:53:50.863Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext                       
springboot-restful-webservices  | 2025-04-03T06:53:50.864Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1471 ms
mysqldb                         | 2025-04-03T06:53:50.925591Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock            
mysqldb                         | 2025-04-03T06:53:50.926163Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.4.4'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.                                                                                                                                                                                 
springboot-restful-webservices  | 2025-04-03T06:53:51.025Z  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
springboot-restful-webservices  | 2025-04-03T06:53:51.090Z  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.6.11.Final
springboot-restful-webservices  | 2025-04-03T06:53:51.124Z  INFO 1 --- [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
springboot-restful-webservices  | 2025-04-03T06:53:51.396Z  INFO 1 --- [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
springboot-restful-webservices  | 2025-04-03T06:53:51.424Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
springboot-restful-webservices  | 2025-04-03T06:53:51.816Z  INFO 1 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@322b09da
springboot-restful-webservices  | 2025-04-03T06:53:51.818Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
springboot-restful-webservices  | 2025-04-03T06:53:51.863Z  WARN 1 --- [           main] org.hibernate.orm.deprecation            : HHH90000025: MySQL8Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
springboot-restful-webservices  | 2025-04-03T06:53:51.864Z  WARN 1 --- [           main] org.hibernate.orm.deprecation            : HHH90000026: MySQL8Dialect has been deprecated; use org.hibernate.dialect.MySQLDialect instead                                                                                                                                                                                        
springboot-restful-webservices  | 2025-04-03T06:53:51.879Z  INFO 1 --- [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
springboot-restful-webservices  |       Database JDBC URL [Connecting through datasource 'HikariDataSource (HikariPool-1)']                                                                                  
springboot-restful-webservices  |       Database driver: undefined/unknown
springboot-restful-webservices  |       Database version: 8.0                                                                                                                                                
springboot-restful-webservices  |       Autocommit mode: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Isolation level: undefined/unknown                                                                                                                                   
springboot-restful-webservices  |       Minimum pool size: undefined/unknown
springboot-restful-webservices  |       Maximum pool size: undefined/unknown                                                                                                                                 
springboot-restful-webservices  | 2025-04-03T06:53:52.477Z  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
springboot-restful-webservices  | 2025-04-03T06:53:52.517Z  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
springboot-restful-webservices  | 2025-04-03T06:53:52.741Z  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
springboot-restful-webservices  | 2025-04-03T06:53:53.061Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
springboot-restful-webservices  | 2025-04-03T06:53:53.081Z  INFO 1 --- [           main] c.jb.student_app.StudentAppApplication   : Started StudentAppApplication in 4.351 seconds (process running for 4.993)
springboot-restful-webservices  | 2025-04-03T06:54:02.819Z  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
springboot-restful-webservices  | 2025-04-03T06:54:02.819Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
springboot-restful-webservices  | 2025-04-03T06:54:02.820Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0                                                                                                            
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0
springboot-restful-webservices  | Hibernate: select s1_0.id,s1_0.age,s1_0.name from students s1_0