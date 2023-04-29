## What is dockerfile?
- is a set of instruction to run the application.
- used to bundle the program.
- it is text document containes all instruction that user may create an image from command line.

## Docker images?
- it is a kind of ready-to-use software read-only template crafted with source codes, libraries, external dependencies needed for software application to run any platform/os.
- the developer call it snapshot. this snapshot is perfect recipe for developers to build test and deploy the desired app swiftly.

## Docker container?
- as discussed docker image is read-only image, that can't be executed by themselves or cannot run/start.
- container is nothing but a box that has ability to run any image.
- when creat docker container you essentialy endup creating a read-write copy of filesystem inside container.


## how docker container differs from image.
- docker images without containers are like orphans/meaningless. 
- docker container is runtime instance.
- docker images can exist in isolation but container cant exist without image.
- docker image cant be stopped but container can be start/stop.
-  


## why docker?
- it mainly help to create and execute containers, self-contained program that are independent from underlying infra
- docker, which is based on linux kernel's resource isolation capability
- we can share images to any environment.
- requires very fewer resources than VM
- its very faster than VM

## syntax for writing dockerfile

 # FROM
-  statement defines which image to download and start from. 
-  ITS a base image 
-  a Dockerfile can have multiple FROM statement. which means docker provides more than one image.
   
           - FROM java: 8  

# MAINTAINER: 
-  defines the author who is creating this Dockerfile

# RUN:
- The RUN statement defines running a command through the shell.
- It tells what process will be running inside the container at the run time
        
            - RUN echo hello 

## Difference RUN vs CMD
- RUN commites changes into image.
- CMD runs command in running container.

# ADD: 
- copies new files/directories/remote-urls from <src> and add them to the *image* <dest>.
- so, that image size get increase.
- dir itself is not copied but its containts.
- it can add local files, contents of tar archives as well as URLs.
 - if <src> is local tar archive in recognised compressed format (.gzip, .zip, xz) then it is unpacked as a directory and add them to the <dest> files from dir.
                      - ADD hom* /mydir/                             to add all files starting with hom.
                      - ADD hom?.txt /mydir/                         to replace hom.txt
 
# COPY:
- copies new files/dir from <src> add them to the *container* <dest>.
- It just copies new files from local to container.
- dir itself is not copied but its containts.
- it cannot add local files, contents of tar archives as well as URLs. 

 
 # CMD: package {httpd}
- there can be a 1 cmd instruction only.
- if you list more than one cmd it will take last only one CMD
- Sets default parameters that can be overridden from the Docker command line interface (CLI) while running container.
                 
 
               - CMD["param1", "param2"] (default parameter to entrypoint)
 
 # EXPOSE:
 - Inform docker that container listens on specified port at runtime.
 - you can specify whether your port listens on TCP/UDP. if protocol is not specified default is TCP
 
         -  EXPOSE 80/tcp
 
 # ENV
 - sets the environment variable key to value
      
        - ENV <KEY> = <VALUE>
 EXAMPLE:
        ENV MY_NAME = "john_doe"
        ENV my_var myvalue
 - the ENV will persist when container is running from resulting image.
 - you can view values using *docker inspect* change them using 
 **docker run --env <key> = <value>** 
 
 ## ENTRYPOINT: variable pass {yum install}
 - An ENTRYPOINT allows you to configure a container that will run as an executable.
 - You can override the ENTRYPOINT instruction using the *docker run --entrypoint flag*.
 - will always run after the container is initiated.
 - Docker defaults the entrypoint to /bin/sh -c. This means you’ll end up in a shell session when you start the container.
 
 ENTRYPOINT ["executable", "param1", "param2"](exec form)
 command line argument to *docker run <image>* will appended after all element in exec form ENTRYPOINT.
 
 ENTRYPOINT command param1 param2  (shell form)
 *shell form* prevent any CMD & RUN command line argument from being used.

 Example:
 FROM Ubuntu
 ENTRYPOINT exec top -b ---      > why exec is there 
 
 # Understand  how CMD And ENTRYPOINT interact
 
 - Both cmd & entrypoint instruction tells what comand get executed while running containeer
 - Dockerfile should specify at least 1 of CMD OR ENTRYPOINT-----> either cmd or use ENTRYPOINT
 - ENTRYPOINT defined as executable in container.
 - CMD should be used as way of defining default argument  for an ENTRYPOINT. or for a Ad-hock command in a container.
 - CMD will be overidden while running container with local CLI/ENTRYPOINT.
 - ENTRYPOINT has the higher priority than CMD.
 
 
 ## when to use ENTRYPOINT
 - when your container will run.
 - 
 
 
 
 # VOLUME
 - the volume instruction creates a mount point with the specified name and marks it as a holding externally mounted volumes from native host.
 # example
 FROM ubuntu
 RUN mkdir myvol
 RUN echo "hello world" > /myvol/greeting
 VOLUME myvol
 
 
 json array  :
 VOLUME ["/var/log"]

 plain string :
 VOLUME /var/log
 
 # USER
 It sets username (uid), the specifired user for RUN CMD ENTRYPOINT instruction
 
 //////////////////////
 A docker image is a collection of code, libraries, configuration files, etc. for an application. Repositories are used to store the images (storage locations).

Docker containers can be created by downloading images from a repository and executing them. Thus, a container is nothing more than a run-time instance of a particular image
//////////////////////////

 ## docker image push to docker hub
 - 1stly you have have dockerhub_account.
 - when building an image 
 - must specify dockerhub_username -- as a part of image_name
 - must include this username in the image_name 
 - format should be {username/image_name}
 - after this we have to login via
 
           - docker login

Username: madflojo
Password:

after this
--> Your password will be stored unencrypted in /root/.docker/config.json.

- then just docker push username/image:tagname

## Pushing to a Non-Docker-Hub Registry
- Specifying the registry address in the tag name

        - docker build -t registry.example.com/username/image_name
     
- Log in to a non-Docker-Hub registry

       - docker login registry.example.com
     
- Use the full tag name with push

       - docker push registry.example.com/username/image_name
       
       
# why docker network?
 - You can connect a container by name or by ID. Once connected, the container can communicate with other containers in the same network.
# types of Docker Network?
 - bridge networks - used within a single host,
 - overlay networks - for multi-host communication.
 - macvlan networks - which are used to connect Docker containers directly to host network interfaces.

 

 # Docker agent
 - 

 

 
 
 [reference](https://youtu.be/Zb7h7UVgMD8)
 
