# what is PODMAN ?
- Docker runs on a client-server that is mediatated by the daemon that leverage REST APIs to respond to perform container related operation.

Podman does not required a daemon. It uses pods to manage containers, which helps users to run rootless containers.
- It developing managing  running containers as per Open container Initiative standards(OCI).
- its default conntainer engine for rhedhat8, centos8.
- *pods are group of containers that run on same system share the same resources*.

How does the POdman work?
- podman works on daemonless architecture, it leverage the systemd instead of daemon 
- One of the differentiating factors of Podman for users is being able to run and manage their own repositories on the system.
- a system and service manager for Linux OS—to run and manage containers in the background

- By integrating Podman and systemd, you can easily generate and establish control units for the containers and run them automatically.




## Why is Podman more secure than Docker?
- Podman is more secure than Docker because of its daemon-less architecture, which makes it rootless. The rootless architecture of Podman allows users to work on their own containers or pods without interfering with other containers. It is also useful in stopping attackers from accessing servers that require root access.





: You have a microservices-based application that consists of several components. How can Docker help in managing and deploying these components efficiently?

: You need to deploy an application that requires specific software dependencies and configurations on multiple servers. How can Docker assist in simplifying this deployment process?

: Your development team is working on a project, and you want to ensure that everyone has the same development environment. How can Docker facilitate consistent development environments across multiple developers?

: You have an application that needs to scale dynamically based on incoming traffic. How can Docker help in automatically scaling the application to meet demand?

: You want to isolate different applications running on the same server to enhance security and prevent conflicts. How can Docker provide containerization to achieve this goal?

: Your application has a complex architecture with various components that need to communicate with each other. How can Docker's networking capabilities help in managing communication between containers?

: You have a legacy application that relies on specific versions of software libraries and tools. How can Docker enable running and maintaining this legacy application without interfering with other system dependencies?

: Your development team is adopting a continuous integration and continuous deployment (CI/CD) approach. How can Docker be integrated into the CI/CD pipeline to streamline the build, test, and deployment processes?

: You want to replicate the production environment for testing purposes without affecting the actual production environment. How can Docker assist in creating isolated testing environments?

: You need to distribute an application along with its dependencies as a self-contained package. How can Docker help in creating portable and reproducible application packages
