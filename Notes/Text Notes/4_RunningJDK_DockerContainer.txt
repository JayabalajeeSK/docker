C:\Users\tharu>jshell
|  Welcome to JShell -- Version 24
|  For an introduction type: /help intro

jshell> int num=9;
num ==> 9

jshell> /exit
|  Goodbye

----------------------------------------------------------------------

C:\Users\tharu>docker search openjdk
NAME                      DESCRIPTION                                     STARS     OFFICIAL
openjdk                   Pre-release / non-production builds of OpenJ…   4027      [OK]
circleci/openjdk          CircleCI images for OpenJDK                     11
cimg/openjdk              The CircleCI OpenJDK (Java) Docker Convenien…   8
jumpserver/openjdk        Pre-release / non-production builds of OpenJ…   0
jenkins/openjdk            Docker Images based on various AdoptOpenJDK…   0
jenkins4eval/openjdk      More information on https://github.com/jenki…   0
vulhub/openjdk            This image is deprecating.                      1
rootpublic/openjdk                                                        0
clarinpl/openjdk                                                          0
openeuler/openjdk                                                         0
cfje/openjdk              OpenJDK Builder Image                           0
amd64/openjdk             Pre-release / non-production builds of OpenJ…   16
arm64v8/openjdk           Pre-release / non-production builds of OpenJ…   71
winamd64/openjdk          Pre-release / non-production builds of OpenJ…   70
springcloud/openjdk       OpenJDK Docker image                            4
arm32v7/openjdk           Pre-release / non-production builds of OpenJ…   18
colstrom/openjdk                                                          0
ccitest/openjdk           CircleCI test images for OpenJDK                1
splatform/openjdk                                                         0
i386/openjdk              Pre-release / non-production builds of OpenJ…   1
shipilev/openjdk          OpenJDK development builds                      14
trollin/openjdk                                                           0
dtcloudplatform/openjdk                                                   0
titicacadev/openjdk       Triple Official OpenJDK Repository              0
s390x/openjdk             Pre-release / non-production builds of OpenJ…   0

--------------------------------------------------------------------
C:\Users\tharu>docker images
REPOSITORY                                        TAG               IMAGE ID       CREATED         SIZE
openjdk                                           22-jdk            b7d44427f462   12 months ago   863MB

C:\Users\tharu>docker run openjdk:22-jdk
Apr 01, 2025 7:28:38 AM java.util.prefs.FileSystemPreferences$1 run
INFO: Created user preferences directory.
|  Welcome to JShell -- Version 22
|  For an introduction type: /help intro
jshell>

-------------------------------------------------------------------
C:\Users\tharu>docker run -dit openjdk:22-jdk
8e522eb151bd63c8c3708d4de82fafbb99ede0e5b270743c83ffa652ca768dc7

C:\Users\tharu>docker run -it openjdk:22-jdk
Apr 01, 2025 7:29:41 AM java.util.prefs.FileSystemPreferences$1 run
INFO: Created user preferences directory.
|  Welcome to JShell -- Version 22
|  For an introduction type: /help intro

--------------------------------------------------------------------
jshell> int num=30;
num ==> 30

jshell> System.out.println("jaya");
jaya

jshell> /exit
|  Goodbye

---------------------------------------------------------------------
C:\Users\tharu>docker ps
CONTAINER ID   IMAGE            COMMAND    CREATED         STATUS         PORTS     NAMES
8e522eb151bd   openjdk:22-jdk   "jshell"   5 minutes ago   Up 5 minutes             zealous_keldysh