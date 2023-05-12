Pod: A running instance of a container in Kubernetes.
Node: A worker vm machine in Kubernetes, part of a cluster.

service: 
- A Kubernetes resource that exposes a set of pods as a network service.
- a Service is a method for exposing a network application that is running as one or more Pods in your cluster. 

uses of service:
- You use a Service to make that set of Pods available on the network so that clients can interact with it.

 `node-port`:
- NodePort service is an extension of ClusterIP service. A ClusterIP Service, to which the NodePort Service routes, is automatically created.
- It exposes the service outside of the cluster by adding a cluster-wide port on top of ClusterIP.

`Deployment`: A higher-level object that manages a set of replicas of a pod and allows for rolling updates and rollbacks.
Ingress
- Make your HTTP (or HTTPS) network service available using a protocol-aware configuration mechanism,
- that understands web concepts like URIs, hostnames, paths, and more. The Ingress concept lets you map traffic to different backends based on rules you define via the Kubernetes API

Ingress Controllers
- In order for an Ingress to work in your cluster, there must be an ingress controller running. You need to select at least one ingress controller and make sure it is set up in your cluster. 

Daemonset:
- Ensures a copy of a Pod is running across a set of nodes in a cluste
- Used to deploy system daemons such as log collectors and monitoring agents that typically must run on every Node.
