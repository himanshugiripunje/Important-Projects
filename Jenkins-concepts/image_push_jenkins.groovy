 pipeline {
        agent any
        stages{     
            stage('git-checkout') {
                steps {
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Java-Techie-jt/devops-automation.git']])
                    sh 'mvn clean package'
                    //sh 'mv /home/ubuntu/workspace/dockerpush1/target/**.jar /home/ubuntu/workspace/dockerpush/target/app-${BUILD_ID}.jar'
                }
            }
            stage('build_image'){
                steps {
                    script {
                        sh 'docker build -t himanshugiripunje/tomcat:${BUILD_ID} .'
                    }
                }
            }
          // image is pushed from 
            stage('push_image'){
                steps{
                    script {
                        withCredentials([string(credentialsId: 'docker-creds', variable: 'passwd')]) {
                sh 'docker login -u himanshugiripunje -p ${passwd}'          
                    }
                sh 'docker push himanshugiripunje/tomcat:${BUILD_ID}'
                    }
                }
            
            }
        }
    }
