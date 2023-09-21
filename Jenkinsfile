@Library("mytest-sl") _

pipeline{
    
    agent any 

    parameters{

        choice(name:'branch', choices:'main\ndevelop', description:'choose any branch')
        booleanParam(name: 'testParam', defaultValue: 'true', description:'select true or false')
    }

    tools{
        maven 'maven3'
    }
    
    stages {
        
        stage('UNIT TESTING.develop'){


            when{
                allOf{
                    expression{ params.testParam }
                    expression{ params.branch=='develop'}
         
                }
            }

            
            steps{
                
                script{
                    
                    //sh "mvn test"
                    mvnTest()
                    library 'mytest-sl'
                
                }
            }
        }
        stage('INTEGRATION TESTING.develop'){

            when{expression{ params.branch == 'develop'}}
            
            steps{
                
                script{
                    
                    //sh "mvn verify -DskipUnitTests"
                    intTest()
                }
            }
        }
        stage('Maven Build.develop'){

            when{expression{ params.branch == 'develop'}}

            steps{
                script{
                    //sh "mvn clean install"
                    mvnBuild()
                }
            }
        }

        stage('Static Code Analysis.develop'){

            when{expression{ params.branch == 'main'}}

            steps{
                script{
                    //withSonarQubeEnv(credentialsId: 'sonar_api'){

                    //    sh 'mvn clean package sonar:sonar'
                   
                    //}
                    def SonarCredentialsId= 'sonar_api'
                    SonarQube(SonarCredentialsId)
                }
            }
        }

        stage('Quality Gate Analysis.develop'){

            when{expression{ params.branch == 'main'}}

            steps{
                script{
           
                    waitForQualityGate abortPipeline: true, credentialsId: 'sonar_api'
                    
                }
            }
        }

        
    }
        
}
