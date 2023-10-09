vol-snap.yml
      
      apiVersion: snapshot.storage.k8s.io/v1
      deletionPolicy: Delete
      driver: csi.nutanix.com
      kind: VolumeSnapshotClass
      metadata:
        annotations:
          k10.kasten.io/is-snapshot-class: "true"
        name: volsnapclass-files
      parameters:
        csi.storage.k8s.io/snapshotter-secret-name: ntnx-secret
        csi.storage.k8s.io/snapshotter-secret-namespace: kasten-io
        storageType: NutanixFiles


secret create.yml     **secret are namespace specific

                  apiVersion: v1
                  kind: Secret
                  metadata:
                   name: pe-files-secret
                   namespace: kube-system
                  stringData:
                  # Provide Nutanix Prism Element credentials which is a default UI credential separated by colon in "key:".
                  # Provide Nutanix File Server credentials which is a REST API user created on File server UI separated by colon in "files-key:".
                    key: "10.48.70.146:9440:admin:nxTech123!"
