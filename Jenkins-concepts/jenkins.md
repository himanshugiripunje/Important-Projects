# What is DSL in Jenkins?
- you can describe your jobs in jenkins using groovy based language.
- Groovy is a scripting language.
- The Job DSL plugin attempts to solve this problem by allowing jobs to be defined in a programmatic form in a human readable file.


# why DSL 
- is a computer language specialized to a particular application domain. 
- Domain specific language is usually less complex than a general-purpose language, such as Java, C, or Ruby.
- it makes software development much efficiently , don't have to do grunt work manually
- you can use shared libraries.
- avoidance of duplication in code and the automation of repetitive work


# DSL defination
- A Domain Specific Language is a programming language with a higher level of abstraction optimized for a specific class of problems. A DSL uses the concepts and rules from the field or domain.


# scripted pipeline drawback
- developers community found that pipeline builders have strong java/groovy skills, so they have to write complex code not to focus on functionality on jenkins.
- excessive scripting violeting the fundamentals of cicd.


### jenkins Plugin
- One approach to isolate complex code is to code the logic into a Jenkins plugin.
- reusability across multiple jenkins installation
-  


# declarative pipeline benifits?
- A declarative pipeline supports conditional statement usage, allows access to environment variables 
-  provides facilities to add logging and error handling declaratively.
- The tradeoff is that declarative pipelines don't allow deep integration into Groovy and Java APIs.
- it offers programmers to able to do operation in asynchronous way, developer must be able to sequence the operation.
-  



-  

# key difference betwween scripted vs declarative pipeline.
- scripted allows you to inject code in groovy
- declarative doesnot allow to inject code.


# How can we stop a scheduled job from being executed temporarily?
- Disable the job from the job details page to temporarily stop all scheduled executions & other factors/events from triggering the job and enable it back to resume the job schedules/triggers. 
- If a job is not required permanently, we can delete the job from the jobs list view page.



# scripted pipeline
                                           node {

                                        git url: 'https://github.com/jfrogdev/project-examples.git'

                                        // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
                                        def server = Artifactory.server "SERVER_ID"

                                        // Read the upload spec and upload files to Artifactory.
                                        def downloadSpec =       
                                             '''{
                                             "files": [     
                                               {
                                                  "pattern": "libs-snapshot-local/*.zip",
                                                  "target": "dependencies/",
                                                  "props": "p1=v1;p2=v2"
                                               }      
                                             ]    
                                         }'''

                                        def buildInfo1 = server.download spec: downloadSpec

                                        // Read the upload spec which was downloaded from github.
                                        def uploadSpec =
                                           '''{
                                           "files": [
                                             {
                                                "pattern": "resources/Kermit.*",
                                                "target": "libs-snapshot-local",
                                                "props": "p1=v1;p2=v2"
                                             },
                                             {
                                                "pattern": "resources/Frogger.*",
                                                "target": "libs-snapshot-local"
                                             }
                                            ]
                                         }'''


                                        // Upload to Artifactory.
                                        def buildInfo2 = server.upload spec: uploadSpec

                                        // Merge the upload and download build-info objects.
                                        buildInfo1.append buildInfo2

                                        // Publish the build to Artifactory
                                        server.publishBuildInfo buildInfo1
                                      }

# what is multi-branch pipeline?
- It is a pipeline job that can be configured to Create a set of Pipeline projects according to the detected branches in one SCM repository.
- This can be used to configure pipelines for all branches of a single repository 




#  when pipeline run it running perticular commands via docker agent
 - 1stly it does 
 - docker inspect -f . node:16-alpine
 - docker pull node:16-alpine
 - docker runs container and mount on persistenet volume.
 - it runs shell command in it. check version + node --version
 - then stop container and delete the persistent volume.

# What are the three security mechanisms Jenkins uses to authenticate users? / How does jenkins authenticate user?
*The three mechanisms are as follows:

- Jenkins uses an internal database to store user data and credentials.
- Jenkins can use a lightweight Directory Access Protocol (LDAP) server to authenticate users.
- We can configure Jenkins to employ the application server's authentication mechanism upon which we deploy it

