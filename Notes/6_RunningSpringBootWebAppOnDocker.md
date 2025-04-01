PS E:\TMachineTraining\docker\rest-demo> docker ps
CONTAINER ID   IMAGE            COMMAND    CREATED       STATUS       PORTS     NAMES
8e522eb151bd   openjdk:22-jdk   "jshell"   2 hours ago   Up 2 hours             zealous_keldysh

PS E:\TMachineTraining\docker\rest-demo> docker exec zealous_keldysh ls -a
.
..
.dockerenv
afs
bin
boot
dev
etc
home
lib
lib64
media
mnt
opt
proc
root
run
sbin
srv
sys
tmp
usr
var

PS E:\TMachineTraining\docker\rest-demo> docker exec zealous_keldysh ls /tmp
hsperfdata_root

PS E:\TMachineTraining\docker\rest-demo> docker cp target/rest-demo.jar zealous_keldysh:/tmp
Successfully copied 20.7MB to zealous_keldysh:/tmp

PS E:\TMachineTraining\docker\rest-demo> docker exec zealous_keldysh ls /tmp
hsperfdata_root
rest-demo.jar

PS E:\TMachineTraining\docker\rest-demo> docker commit zealous_keldysh jayabalajeesk4/rest-demo:v1
sha256:03047ea49458c5e5da138261f80ad39ace146ce343837b88727789b3831cf184

PS E:\TMachineTraining\docker\rest-demo> docker images
REPOSITORY                                        TAG               IMAGE ID       CREATED          SIZE
jayabalajeesk4/rest-demo                          v1                03047ea49458   10 seconds ago   903MB

PS E:\TMachineTraining\docker\rest-demo> docker run jayabalajeesk4/rest-demo:v1
|  Welcome to JShell -- Version 22
|  For an introduction type: /help intro

jshell>

PS E:\TMachineTraining\docker\rest-demo> docker ps
CONTAINER ID   IMAGE            COMMAND    CREATED       STATUS       PORTS     NAMES
8e522eb151bd   openjdk:22-jdk   "jshell"   2 hours ago   Up 2 hours             zealous_keldysh

PS E:\TMachineTraining\docker\rest-demo> docker commit --change='CMD ["java","-jar","/tmp/rest-demo.jar"]' zealous_keldy
sh jayabalajeesk4/rest-demo:v2
sha256:88f8a9a12b3651b0d384701e6f7f1b6a746032d90ed1595ca63a903f4aaf27ee

PS E:\TMachineTraining\docker\rest-demo> docker run -p 8081:8081 jayabalajeesk4/rest-demo:v22
/bin/sh: line 1: [java,-jar,tmprest-demo.jar]: command not found

PS E:\TMachineTraining\docker\rest-demo> docker commit --change='CMD ["java","-jar","/tmp/rest-demo.jar"]' zealous_keldy
sh jayabalajeesk4/rest-demo:v22
sha256:e84cae4800ef29aeb4366e7758df8fe8b47ea7332aea74c20827086f574eef7b

PS E:\TMachineTraining\docker\rest-demo> docker run -p 8081:8081 jayabalajeesk4/rest-demo:v22
/bin/sh: line 1: [java,-jar,/tmp/rest-demo.jar]: No such file or directory

PS E:\TMachineTraining\docker\rest-demo> docker exec zealous_keldysh ls /tmp
hsperfdata_root
rest-demo.jar

PS E:\TMachineTraining\docker\rest-demo> docker exec zealous_keldysh java -version
openjdk version "22" 2024-03-19
OpenJDK Runtime Environment (build 22+36-2370)
OpenJDK 64-Bit Server VM (build 22+36-2370, mixed mode, sharing)

PS E:\TMachineTraining\docker\rest-demo>