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
