## What is dockerfile?
- is a set of instruction to run the application.
- used to bundle the program.
- it is text document containes all instruction that user may create an image from command line.


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
 
 ENTRYPOINT ["executable", "param1", "param2"](exec form)
 command line argument to *docker run <image>* will appended after all element in exec form ENTRYPOINT.
 
 ENTRYPOINT command param1 param2  (shell form)
 *shell form* prevent any CMD & RUN command line argument from being used.
 
 
 
 
 


 

 
 
 [reference](https://youtu.be/Zb7h7UVgMD8)
 
