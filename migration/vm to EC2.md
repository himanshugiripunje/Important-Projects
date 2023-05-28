## migrate existing application from on premises to cloud

# Export your virtual machin image with extention of OVA   

- go to oracle vm virtual box manager
- > file -> export appliance
- >  This will open the Export Virtual Appliance wizard.
- C:\Users\himanshu\OneDrive\Documents\centos-7.ova
- appliance setting> Formate:open virtualisation 
                   Formate 2.0    
                   
# Step2:- Create an S3 Bucket ( create an s3 bucket in the Region where you will create your EC2)
- *create bucket*
- created bucket upload exported vm
-  C:\Users\himanshu\OneDrive\Documents\centos-7.ova   <- exported vm onto s3 bucket

# create role for vmimport with relevant permission,
- open ubuntu terminal in your own machine 
- having awscli downloaded
- aws configured
        
        # aws s3 ls
- create trust-policy for vm-import
    
 $cat trust-policy.json > 
    
    {
        "Version": "2012-10-17",
        "Statement": [
          {
                "Effect": "Allow",
                "Principal": {
                  "Service": "vmie.amazonaws.com"
                },
                "Action": "sts:AssumeRole"
          }
        ]
          }
        ///its very important for migration
        
        
- create role on basis of that policy
          
            aws iam create-role --role-name vmimport --assume-role-policy-document   file:///mnt/d/trust-policy.json
            
- *if show error file location*                                     
- Cd file location where u store 
 
- check graphically role are created mean aws console-> 
                          Roles->vmimport
# attach policy to role
- s3 full access *get object*
- *put object*
- attach vmimport export policy 

        aws iam attach-role-policy --role-name vmimport --policy-arn arn:aws:iam::aws:policy/VMImportExportRoleForAWSConnector 

- *if error show*
- administrator policy should be attach

# create new file - container.json

                [
            {
              "Description": "onpremisesvm",
              "Format": "ova",
              "UserBucket": {
                  "S3Bucket": "your-buckt-name",
                  "S3Key": "image name jo s3 bucket me upload ki"
              }
            }
          ]

# Then execute this commands

        
       aws ec2 import-image --disk-containers file:///mnt/d/container.json --role-name vmimport
       
 - check whether its imported or not/ check status
        
         aws ec2 describe-import-image-tasks --import-task-ids <task-id>
         
  *note* - *make sure bucket-region=ec2-region*
         - *where your vm is create only in that region*
      
- after some time 
- you would know that vm is imported  as a snapshot and *ami in same region where your bucket exist* 
         
        

