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
- A declarative pipeline supports conditional statement usage, allows access to environment variables and provides facilities to add logging and error handling
-  The tradeoff is that declarative pipelines don't allow deep integration into Groovy and Java APIs.

# why declarative
-  the declarative Jenkins pipeline doesn't permit a developer to inject code. 
-  it does not allow developers to code complex groovy, via plugin, shared libraries.
-   




#  when pipeline run it running perticular commands.
 - 1stly it does 
 - docker inspect -f . node:16-alpine
 - docker pull node:16-alpine
 - docker runs container and mount on persistenet volume.
 - it runs shell command in it. check version + node --version
 - then stop container and delete the persistent volume.
