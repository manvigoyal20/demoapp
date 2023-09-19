pipeline{
    
    agent any 

    tools{
        maven 'maven3'
    }
    
    stages {
        
        stage('Git Checkout'){
            
            steps{
                
                script{
                    
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
