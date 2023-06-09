# what is the main purpose of docker?
=  allows you to build, test, and deploy applications quickly
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
- It provides a runtime environment(act as small operating systems and provide all the functionality necessary for a program to run.) in a single container.
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

#
- Here's why Docker is a game-changer:
- 1️⃣ Containerisation: Docker enables you to encapsulate your application, along with its dependencies and runtime environment, into a single container. Containers are lightweight, isolated, and share the host operating system's kernel, making them portable and efficient.
- 2️⃣ Portability and Consistency: With Docker, you can package your application, regardless of its underlying infrastructure, into a standardised container. This container can run seamlessly on any machine that has Docker installed, ensuring consistency across different environments.
- 3️⃣ Rapid Deployment: Docker containers are quick to start, stop, and scale, providing fast and efficient deployment. They allow you to easily replicate and distribute your application across multiple hosts, facilitating horizontal scalability and load balancing.
- 4️⃣ DevOps Enablement: Docker plays a pivotal role in DevOps practices by promoting collaboration, automation, and continuous delivery. It allows developers and operations teams to work together seamlessly, ensuring applications are built, tested, and deployed reliably.
- 5️⃣ Resource Efficiency: Docker's containerisation approach maximizes resource utilisation by sharing the host operating system's resources among multiple containers. This results in higher density, improved server utilization, and cost savings.
- 6️⃣ Ecosystem and Tooling: Docker has a vast ecosystem with a wide range of pre-built container images available on the Docker Hub. It also provides a powerful command-line interface (CLI) and robust APIs for managing containers, networks, and volumes.
- 7️⃣ Flexibility and Scalability: Docker enables you to decompose your application into microservices, each running in its own container. This allows you to independently scale and update different components of your application, providing flexibility and agility.

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
 - it restrict the flexibility of user.
 - Docker defaults the entrypoint to /bin/sh -c. This means you’ll end up in a shell session when you start the container.
 - `The ENTRYPOINT instruction is used to configure the executables that will always run after the container is initiated. For example, you can mention a script to run as soon as the container is started.`
 
 ENTRYPOINT ["executable", "param1", "param2"](exec form)
 command line argument to *docker run <image>* will appended after all element in exec form ENTRYPOINT.
 
 ENTRYPOINT command param1 param2  (shell form)
 *shell form* prevent any CMD & RUN command line argument from being used.

 Example:
 FROM Ubuntu
 ENTRYPOINT exec top -b ---      > why exec is there 
 # why cmd
 - The use of CMD as a best practice in Docker is recommended for several reasons:

1. Flexibility: CMD allows users to easily override the default command when running a container. By specifying the default command using CMD, users can easily modify or extend the behavior of the container without needing to modify the Dockerfile itself. This flexibility is valuable in various scenarios, such as running the container with different startup options or executing additional commands alongside the default command.

2. Composability: CMD promotes the concept of creating composable containers. By separating the default command from the Dockerfile, you can build reusable images that can serve as a base for other containers. Users can extend or customize the behavior of the base image by specifying their own command during container runtime

3. Debugging and troubleshooting: When using CMD, it's easier to troubleshoot and debug containers. If you encounter issues with the container's startup or execution, you can override the CMD and execute alternative commands to investigate the problem without modifying the Dockerfile. This approach simplifies the debugging process and provides greater flexibility in identifying and resolving issues.

4. Testing and development: CMD is particularly useful during testing and development phases. It allows developers to define a default command that reflects the typical usage of the containerized application. Developers can then focus on writing and testing application code without worrying about specifying the command every time they run the container.

5. Compliance with the 12-factor app methodology: The 12-factor app methodology, which provides guidelines for building modern and scalable applications, recommends keeping the application's configuration separate from the code. By using CMD instead of hardcoding the command in the Dockerfile, you adhere to this principle and enable easy configuration changes and command overrides.

By following the best practice of using CMD in Docker, you ensure greater flexibility, composability, ease of debugging, and adherence to best practices like the 12-factor app methodology. It ultimately results in more maintainable, reusable, and scalable Docker images and containers.
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
 - The aim of this docker plugin is to be able to use a Docker host to dynamically provision a docker container as a Jenkins agent node, let that run a single build, then tear-down that node, without the build process.
                                        
 
                                        pipeline {
                                      agent {
                                          docker { image 'node:18.16.0-alpine' }
                                      }
                                      stages {
                                          stage('Test') {
                                              steps {
                                                  sh 'node --version'
                                              }
                                          }
                                      }
                                    } 
## workspace syncronize - to continue using the another stages of Docker. 
 >- you have to use "reuseNode true". 
                            
                                       pipeline {
                                          agent any
                                          stages {
                                              stage('Build') {
                                                  agent {
                                                      docker {
                                                          image 'gradle:6.7-jdk11'
                                                          // Run the container on the node specified at the
                                                          // top-level of the Pipeline, in the same workspace,
                                                          // rather than on a new node entirely:
                                                          reuseNode true
                                                      }
                                                  }
                                                  steps {
                                                      sh 'gradle --version'
                                                  }
                                              }
                                          }
                                      }
                       
                                             
 
## for mounting your data to container.
                                             pipeline {
                                                agent {
                                                    docker {
                                                        image 'maven:3.9.0-eclipse-temurin-11'
                                                        args '-v $HOME/.m2:/root/.m2'
                                                    }
                                                }
                                                stages {
                                                    stage('Build') {
                                                        steps {
                                                            sh 'mvn -B'
                                                        }
                                                    }
                                                }
                                            }
 
 
 
 
 
 
 
 [reference](https://youtu.be/Zb7h7UVgMD8)
 
