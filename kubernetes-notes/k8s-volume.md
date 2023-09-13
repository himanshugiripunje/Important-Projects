
# persistent volume create
-  
                    apiVersion: v1
                    kind: PersistentVolume
                    metadata:
                      name: nginx-pv
                      labels:
                        type: local
                    spec:
                      storageClassName: local-storage
                      capacity:
                        storage: 5Gi
                      accessModes:
                        - ReadWriteOnce
                      hostPath:
                        path: "/mnt/data"


# pvc 

                        kind: PersistentVolumeClaim
                        metadata:
                          name: mysql-pv-claim
                        spec:
                          storageClassName: local-storage
                        
                          accessModes:
                            - ReadWriteOnce
                          resources:
                            requests:
                              storage: 5Gi




# storage class

apiVersion: storage.k8s.io/v1
kind: StorageClass
metadata:
  name: local-storage
provisioner: kubernetes.io/no-provisioner
volumeBindingMode: WaitForFirstConsumer





