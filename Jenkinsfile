pipeline{
    
    agent any 

    tools{
        maven 'maven3'
    }
    
    stages {
        
        stage('Git Checkout'){
            
            steps{
                
                script{
                    echo "User selected branch is ${params.branchName.split('/').last()}"
                    
                    git branch: "${params.branchName.split('/').last()}", url: 'https://github.com/manvigoyal20/demoapp.git'
                }
            }
        }
        stage('UNIT TESTING'){
            
            steps{
                
                script{
                    
                    sh "mvn test"
                }
            }
        }
        stage('INTEGRATION TESTING'){
            
            steps{
                
                script{
                    
                    sh "mvn verify -DskipUnitTests"
                }
            }
        }
        stage('Maven Build'){
            steps{
                script{
                    sh "mvn clean install"
                }
            }
        }
        
    }
        
}