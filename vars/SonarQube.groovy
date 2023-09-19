def call(SonarCredentialsId){
    withSonarQubeEnv(credentialsId: SonarCredentialsId){
        sh 'mvn clean package sonar:sonar'
    }
}