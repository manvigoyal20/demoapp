@Library("mytest-sl") _

pipeline{
    
    agent any 

    parameters{

        choice(name:'branch', choices:'main\ndevelop', description:'choose any branch')
    }

    tools{
        maven 'maven3'
    }
    
    stages {
        
        stage('Git Checkout'){

            when{expression{ params.branch == 'develop'}}
            
            steps{
                
                script{
                    //git branch: 'new1', url: 'https://github.com/manvigoyal20/demoapp.git'

                    
                    gitCheckout(branch: "${params.branch}", url:"https://github.com/manvigoyal20/demoapp.git")

                }
            }
        }
        stage('UNIT TESTING'){

            when{expression{ params.branch == 'develop'}}
            
            steps{
                
                script{
                    
                    //sh "mvn test"
                    mvnTest()
                }
            }
        }
        stage('INTEGRATION TESTING'){

            when{expression{ params.branch == 'develop'}}
            
            steps{
                
                script{
                    
                    //sh "mvn verify -DskipUnitTests"
                    intTest()
                }
            }
        }
        stage('Maven Build'){

            when{expression{ params.branch == 'develop'}}

            steps{
                script{
                    //sh "mvn clean install"
                    mvnBuild()
                }
            }
        }
        stage('Static Code Analysis'){

            when{expression{ params.branch == 'develop'}}

            steps{
                script{
                    //withSonarQubeEnv(credentialsId: 'sonar_api'){
                    //   sh 'mvn clean package sonar:sonar'
                    //}
                    def SonarCredentialsId= 'sonar_api'
                    SonarQube(SonarCredentialsId)
                }
            }
        }
        stage('Quality Gate Analysis'){

            when{expression{ params.branch == 'develop'}}

            steps{
                script{
           
                    waitForQualityGate abortPipeline: true, credentialsId: 'sonar_api'
                    
                }
            }
        }

        
    }
        
}
