Pod: A running instance of a container in Kubernetes.
Node: A worker vm machine in Kubernetes, part of a cluster.

service: 
- A Kubernetes resource that exposes a set of pods as a network service.
- a Service is a method for exposing a network application that is running as one or more Pods in your cluster. 

uses of service:
- You use a Service to make that set of Pods available on the network so that clients can interact with it.


`clusterip address`:
- Provides static Ip address.
- Inter service communication within the cluster. For example, communication between the front-end and back-end components of your app.



 `node-port`:
- NodePort service is an extension of ClusterIP service. A ClusterIP Service, to which the NodePort Service routes, is automatically created.
- It exposes the service outside of the cluster by adding a cluster-wide port on top of ClusterIP.
- NodePort exposes the service on each Node’s IP at a static port
- When you want to enable external connectivity to your service.
- Using a NodePort gives you the freedom to set up your own load balancing solution, to configure environments that are not fully supported by Kubernetes,
-  or even to expose one or more nodes’ IPs directly.


`loadbalancer`:
- LoadBalancer service is an extension of NodePort service. NodePort and ClusterIP Services, to which the external load balancer routes, are automatically created.
- It integrates NodePort with cloud-based load balancers.
- It exposes the Service externally using a cloud provider’s load balancer.

`externalname`:
- Services of type ExternalName map a Service to a DNS name, not to a typical selector such as my-service.
- You specify these Services with the `spec.externalName` parameter.
- It maps the Service to the contents of the externalName field (e.g. foo.bar.example.com), by returning a CNAME record with its value.


`Deployment`: A higher-level object that manages a set of replicas of a pod and allows for rolling updates and rollbacks.
Ingress
- Make your HTTP (or HTTPS) network service available using a protocol-aware configuration mechanism,
- that understands web concepts like URIs, hostnames, paths, and more. The Ingress concept lets you map traffic to different backends based on rules you define via the Kubernetes API

Ingress Controllers
- In order for an Ingress to work in your cluster, there must be an ingress controller running. You need to select at least one ingress controller and make sure it is set up in your cluster. 

Daemonset:
- Ensures a copy of a Pod is running across a set of nodes in a cluste
- Used to deploy system daemons such as log collectors and monitoring agents that typically must run on every Node.