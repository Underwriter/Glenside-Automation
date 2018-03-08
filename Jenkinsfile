pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    post {
        always {
           junit 'target/surefire-reports/*.xml'
        }
    }
  }
}