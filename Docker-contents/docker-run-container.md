# docker commands -
- running container with permenant volume.
- docker run -d -p 8080:8080 -v /mnt/d/my-jenkins-data/:/var/jenkins_home --name <container_name> <jenkins:2.60.3-alpine>
