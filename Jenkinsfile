@Library("mytest-sl@${params.branchName.split('/').last()}") _

pipeline{
    
    agent any 

    tools{
        maven 'maven3'
    }
    
    stages {
        
        stage('Git Checkout'){
            
            steps{
                
                script{
                    
                    //git branch: 'new1', url: 'https://github.com/manvigoyal20/demoapp.git'
                    echo "User selected branch is ${params.branchName.split('/').last()}"
                    
                    gitCheckout(branch: "${params.branchName.split('/').last()}", url:"https://github.com/manvigoyal20/demoapp.git")
                }
            }
        }
        stage('UNIT TESTING'){
            
            steps{
                
                script{
                    
                    //sh "mvn test"
                    mvnTest()
                }
            }
        }
        stage('INTEGRATION TESTING'){
            
            steps{
                
                script{
                    
                    //sh "mvn verify -DskipUnitTests"
                    intTest()
                }
            }
        }
        stage('Maven Build'){
            steps{
                script{
                    //sh "mvn clean install"
                    mvnBuild()
                }
            }
        }
        //stage('Static Code Analysis'){
        //    steps{
        //        script{
        //            //withSonarQubeEnv(credentialsId: 'sonar_api'){
        //            //    sh 'mvn clean package sonar:sonar'
        //            //}
        //            def SonarCredentialsId= 'sonar_api'
        //            SonarQube(SonarCredentialsId)
        //        }
        //    }
        //}
         //stage('Quality Gate Analysis'){
           // steps{
           //     script{
           //
           //         waitForQualityGate abortPipeline: true, credentialsId: 'sonar_api'
           //         
           //     }
           // }
        //}

        
    }
        
}