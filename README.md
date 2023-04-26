# Theory-notes
## AWS Theory provides
One project that comes  is a web application that was built to provide a platform for online shopping. The application was built using microservices architecture, and each microservice was packaged as a Docker container.

To manage the containers and deploy the application, Kubernetes was used as the container orchestration tool. Kubernetes was responsible for managing the deployment, scaling, and load balancing of the application's microservices.

The development team used Git for version control and GitHub as the repository for the code. Every time a new feature was added or a bug was fixed, the code was pushed to the GitHub repository.  
# we implemeting the github branching strategy. 


The continuous integration/continuous deployment (CI/CD) pipeline was set up using Jenkins. When a new code change was pushed to the GitHub repository, Jenkins automatically triggered a build process to create new Docker images for the updated microservices. Once the Docker images were built, they were pushed to the Docker registry.

Finally, Kubernetes pulled the updated Docker images from the Docker registry and deployed them to the Kubernetes cluster. This automated process ensured that the application was continuously updated and available to users without any downtime.
# we also use deployment strategy like rolling out for this.

In summary, Docker and Kubernetes were used in this project for containerizing microservices and managing their deployment, scaling, and load balancing. The CI/CD pipeline was set up using Jenkins, which automated the build and deployment processes. This approach made the development and deployment process more efficient, reliable, and scalable.
