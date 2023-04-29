#  when pipeline run it running perticular commands.
 - 1stly it does 
 - docker inspect -f . node:16-alpine
 - docker pull node:16-alpine
 - docker runs container and mount on persistenet volume.
 - it runs shell command in it. check version + node --version
 - then stop container and delete the persistent volume.
