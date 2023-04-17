 ## Use Terraform to deploy following things:
- VPC
- Public Subnets
- Private Subnets
- Launch Template
- Auto Scaling Group of EC2 Machine with Latest ubuntu image
- Application Load Balancer for above auto scaling group
- MySQL RDS
- SNS Topic and subscription
- Cloudwatch CPU and RAM utilization metric and Alert (Alerts should be sent to SNS Topic subscribers)

2. Deploy a sample application with Ansible
- Application should be deployed on auto scaling group created in previous step
- MySQL database connection should happen

3. Push all your code to private Github repo with documentation on how to run the code and all configurable terraform and ansible properties

Follow best practices while creating infrastructure.
