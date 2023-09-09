# coommands
-  kubectl get csr | grep Pending
  369  kubectl get csr | grep Pending | less
  370  kubectl adm certificate approve 




## K8s Commands
             
             kubectl delete -f  quota.yml
# Create new with manifests file?
      - kubectl create -f deployment.yml
      - kubectl get resourcequotas
# describe the resource quotas ?
    - kubectl describe quota

		Kubectl explain resourcequota
  
> it will display the apiVersion   kind 

# kubectl run app --image=nginx:alpine
	It creates pod
# kubectl delete po nginx tomcat
	Delete multiple pods at a time

# 
    - kubectl get ns
    - kubectl describe ns quota
    
     - kubectl get pods 
for listing no. of pods

      - kubectl describe pod pod_name
detailed info about pod

		kubectl run nginx --image=nginx --dry-run=client -o yaml
  it generated the yaml file on th output.
# pod-defination.yml

				apiVersion:
				kind:
				metadata:
				   name: myapp_pod	*dictionary*
				   labels:
				        app: myapp
					type: front-end
				spec:
				   containers:
				      - name: nginx-controller       *list*
				      	image: nginx

# 
1. right api version for right `object`
2. kind - what kind of object, rs, pod, k=
3. metadata -  data above the object like `Name` `label`
4. 

# container installation

Command to install contained:-
   17  dnf update -y
			     dnf install -y  yum-utils device-mapper-persistent-data lvm2
			     dnf config-manager --add-repo=https://download.docker.com/linux/centos/docker-ce.repo
			     dnf update -y && dnf install -y containerd.io
			     mkdir -p /etc/containerd
			     containerd config default > /etc/containerd/config.toml
			     systemctl restart containerd
			     systemctl status containerd
			     systemctl enable containerd

# not installing containerD `issue`
podman 
buildah


# Init containers
				apiVersion: v1
				kind: Pod
				metadata:
				  name: myapp-pod
				  labels:
				    app: myapp
				spec:
				  containers:
				  - name: myapp-container
				    image: busybox:1.28
				    command: ['sh', '-c', 'echo The app is running! && sleep 3600']
				  initContainers:
				  - name: init-myservice
				    image: busybox
				    command: ['sh', '-c', 'git clone <some-repository-that-will-be-used-by-application> ;']
