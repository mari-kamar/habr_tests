pipeline {
   agent {
       docker {
           image 'maven'
       }
   }

   stages {
      stage('Build') {
         steps {
            echo 'Build time'
            git branch: 'jenkinsTest', credentialsId: '3c34ed55-4061-46f9-83d9-9e22653d6144', url: 'https://github.com/mari-kamar/habr_tests' 
            echo 'Stop build'
         }
      }
      stage('clean') {
         steps {
            echo 'tests execution'
            sh 'export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64' 
            sh 'mvn clean'
         }
      }
      stage('test') {
         steps {
            echo 'tests execution'
            sh 'mvn test'
         }
      }
      stage('results') {
         steps {
            echo 'tests execution'
            sh "allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]"
         }
      }
   }
}
