pipeline{
    
    agent any 

    tools{
        maven 'maven3'
    }
    
    stages {
        
        stage('Git Checkout'){
            
            steps{
                
                script{
                    
                    git branch: 'main', url: 'https://github.com/manvigoyal20/demoapp.git'
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
                    
                    sh "mvn verify -dskipUnitTests"
                }
            }
        }
        
    }
        
}