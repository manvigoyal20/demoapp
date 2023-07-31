pipeline{
    
    agent any 
    
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
        
    }
        
}