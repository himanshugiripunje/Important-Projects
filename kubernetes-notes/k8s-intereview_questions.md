1. When you have a lot of services which mode of kube proxy is preferred to use? iptables or IPVS
2. Who is responsible for doing health checks on the containers?
3. What is an overlay network?
4. How will you scale coredns[DNS Resolution] for large deployments?
5. What is a CSI?
. What is the difference between a CSI, CRI and CNI?
2. What is the difference between a CNI and a CNI plugin?
3. What is the naming convention of the APIs in Kubernetes? What does v1aplha1 specify?
4. What is the cluster IP of the kube-api server?
5. Can operator do exec in one of your running pods?
6.  Which Linux capability is used to control the resources given to any containers? Like container can use 1GB of memory.
2. Which Linux capability is used to separate/isolate the process running in one container from another?
3. What are init containers and why are they used?
4. How can you attach a pod to a service?
5. How can you look at the logs of a container inside a pod?
6. Kubernetes Questions: Kubectl commands

This is the 9th set of Questions for Kubernetes Interview Preparation. This time it's more theme based and around commands in k8s this time.

1. Which command will you use to list the pods of a particular deployment?
2. A pod has two containers container_a and container_b. How can you exec to shell in container_b?
3. How can you look at events of any pod or deployments?
4. How to switch context to a different Kubernetes cluster?
5. How can you increase the replica of any deployment?
6. Does actual traffic pass through Kube Proxy?
2. What will happen to traffic / pods if a kube proxy is down in a node for few seconds ?
3. Which component does kube proxy talks to from these- etcd, kube api server or scheduler?
4. How is the kube proxy deployed in all nodes? Do you know any tool to run worker node with out actually using kube proxy?
5. Which namespace does kube proxy runs in?



# Kubernetes Failure Story.

How Kubernetes upgrade and a CNI config caused havoc in Redis Infrastructure.

When using EKS(AWS) there is a setting named externalsnat with which you can control if you want your k8s pods to be accessible from within the peered VPC also.

If SNAT disabled, the IP address allocated to a Pod is routable inside the VPC. But traffic to a destination outside of the VPC has the source Pod IP SNAT'ed to the instance ENI's primary IP address. Thus the response will come from the Primary IP which will be dropped if the request was targetted to the secondary IP pods. You can read more about it here in-depth.

https://www.learnsteps.com/kubernetes-upgrade-failure-story-how-a-cni-config-caused-havoc-in-our-redis-infrastructure/ 

![image](https://github.com/himanshugiripunje/Theory-notes/assets/99471014/e67a6d5c-4045-433f-8912-762606b48c35)


#How Pods Communicate with Each Other:

- Because each pod has a unique IP in a flat address space inside the Kubernetes cluster, direct pod-to-pod communication is possible without requiring any kind of proxy or address translation. This also allows using standard ports for most applications as there is no need to route traffic from a host port to a container port, as in Docker. Note that because all containers in a pod share the same IP address, container-private ports are not possible (containers can access each other’s ports via localhost:<port>) and port conflicts are possible. However, the typical use case for a pod is to run a single application service (in a similar fashion to a VM), in which case port conflicts are a rare situation.

# How Pods Communicate with Services
- Kubernetes services allow grouping pods under a common access policy (for example, load-balanced). The service gets assigned a virtual IP which pods outside the service can communicate with. Those requests are then transparently proxied (via the kube-proxy component that runs on each node) to the pods inside the service. Different proxy-modes are supported.

# Network
===================
- iptables: kube-proxy installs iptables rules trap access to service IP addresses and redirect them to the correct pods.
userspace: kube-proxy opens a port (randomly chosen) on the local node. Requests on this “proxy port” get proxied to one of the service’s pods (as retrieved from Endpoints API).
ipvs (from Kubernetes 1.9): calls netlink interface to create ipvs rules and regularly synchronizes them with the Endpoints API.
Kubernetes also offers an Endpoints API for Kubernetes native applications that is updated whenever the set of pods in a service changes. This allows a pod to retrieve the current endpoints for all pods in a service.

- Incoming Traffic from the Outside World
Nodes inside a Kubernetes cluster are firewalled from the Internet by default, thus services IP addresses are only targetable within the cluster network. In order to allow incoming traffic from outside the cluster, a service specification can map the service to one or more externalIPs (external to the cluster). Requests arriving at an external IP address get routed by the underlying cloud provider to a node in the cluster (usually via a load balancer outside Kubernetes). The node then knows which service is mapped to the external IP and also which pods are part of the service, thus routing the request to an appropriate pod.

- To support more complex policies on incoming traffic, Kubernetes provides an Ingress API offering externally-reachable URLs, traffic load balancing, SSL termination, and name based virtual hosting to services. An ingress is a collection of rules that allow inbound connections to reach the cluster service. Note that to actually action ingresses specified via the API, an ingress controller (such as the NGINX ingress controller) must be deployed and configured for the cluster.
