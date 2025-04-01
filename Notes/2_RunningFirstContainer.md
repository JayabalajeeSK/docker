PS C:\Users\tharu> docker run hello-world
Unable to find image 'hello-world:latest' locally
latest: Pulling from library/hello-world
e6590344b1a5: Download complete
Digest: sha256:7e1a4e2d11e2ac7a8c3f768d4166c2defeb09d2a750b010412b6ea13de1efb19
Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/

 --------------------------------------------------

 PS C:\Users\tharu> docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

PS C:\Users\tharu> docker ps -a
CONTAINER ID   IMAGE                                                            COMMAND                  CREATED          STATUS                        PORTS     NAMES
654633af09dc   hello-world                                                      "/hello"                 7 minutes ago  

PS C:\Users\tharu> docker images
REPOSITORY                                        TAG               IMAGE ID       CREATED         SIZE
hello-world                                       latest            7e1a4e2d11e2   2 months ago    20.4kB