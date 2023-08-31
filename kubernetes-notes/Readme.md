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
