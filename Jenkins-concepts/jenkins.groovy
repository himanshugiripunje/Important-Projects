pipeline{
    agent {
        label  "slave"
    }
    stages{
        stage("code-pull"){
            steps{
               git branch: 'J2EE', url: 'https://github.com/shashirajraja/onlinebookstore.git'
            }          
        }
        stage("code-build"){
            steps{
                sh "mvn clean package"
            }
        }
        stage("push-artifact"){
            steps{
                sh "aws s3 ls"
                sh "aws --version"
                sh "aws s3 mb s3://buck20.2 --region ap-south-1"
                sh 'sudo mv /home/ec2-user/workspace/newpipe/target/onlinebookstore-0.0.1-SNAPSHOT.war /mnt/.'
                sh 'aws s3 cp /mnt/onlinebookstore-0.0.1-SNAPSHOT.war s3://buck20.2/'
                sh 'aws s3api put-object-acl --bucket buck20.2 --key onlinebookstore-0.0.1-SNAPSHOT.war --acl public-read'
            }
         }
            stage("dev-deployment"){
                steps{
                sh '''             
                sudo curl -O https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.5/bin/apache-tomcat-10.1.5.zip
    
                 unzip -o apache-tomcat-10.1.5.zip                
                 chmod 777 apache-tomcat-10.1.5/bin/catalina.sh
                 sudo aws s3 cp s3://buck20.2/onlinebookstore-0.0.1-SNAPSHOT.war /home/ec2-user/workspace/newpipe/apache-tomcat-10.1.5/webapps/.
                 "cd /home/ec2-user/workspace/newpipe"
                 "apache-tomcat-10.1.5/bin/catalina.sh stop"
                 "apache-tomcat-10.1.5/bin/catalina.sh start"
                '''
            }
        }
    }              
}
