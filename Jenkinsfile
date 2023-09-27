@Library('mytest-sl') _
def params = customParameters()

pipeline {
    //agent any
    agent{ node{ label'mySystem' }}

    tools {

        maven 'maven3'
        //'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'

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
                    expression { params.branch == 'develop' }
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
            when { expression { params.branch == 'develop' } }

            steps {
                script {
                    //withSonarQubeEnv(credentialsId: 'sonar-api'){

                    //    sh 'mvn clean package sonar:sonar'

                    //}
                    def SonarCredentialsId = 'sonar-api'
                    SonarQube(SonarCredentialsId)
                }
            }
        }

        stage('Quality Gate Analysis') {
            when { expression { params.branch == 'develop' } }

            steps {
                script {
                    waitForQualityGate abortPipeline: true, credentialsId: 'sonar-api'
                }
            }
        }

        stage('Docker Image Build') {
            when { expression { params.branch == 'develop' } }

            steps {
                script {
                    dockerBuild("${params.imageName}", "${params.imageTag}", "${params.dockerhubUser}")
                }
            }
        }
    }

    post {
        always {
            junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
        }
    }
}
