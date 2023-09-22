@Library('mytest-sl') _
def params = customParameters()

pipeline {
    agent any
    tools {
        maven 'maven3'
    }

    stages {
        stage('UNIT TESTING') {
    
            when {
                allOf {
                    expression { params.testParam }
                    expression { params.branch == 'develop' }
                }
            }

            steps {
                script {
                    //sh "mvn test"
                    mvnTest()
                }
            }
        }
        stage('INTEGRATION TESTING') {
            when {
                allOf {
                    expression { params.testParam }
                    expression { params.branch == 'main' }
                }
            }

            steps {
                script {
                    //sh "mvn verify -DskipUnitTests"
                    intTest()
                }
            }
        }
        stage('Maven Build') {
            when {
                allOf {
                    expression { params.testParam }
                    expression { params.branch == 'main' }
                }
            }

            steps {
                script {
                    //sh "mvn clean install"
                    mvnBuild()
                }
            }
        }

        stage('Static Code Analysis') {
            when { expression { params.branch == 'main' } }

            steps {
                script {
                    //withSonarQubeEnv(credentialsId: 'sonar_api'){

                    //    sh 'mvn clean package sonar:sonar'

                    //}
                    def SonarCredentialsId = 'sonar_api'
                    SonarQube(SonarCredentialsId)
                }
            }
        }

        stage('Quality Gate Analysis') {
            when { expression { params.branch == 'main' } }

            steps {
                script {
                    waitForQualityGate abortPipeline: true, credentialsId: 'sonar_api'
                }
            }
        }
    }
}
