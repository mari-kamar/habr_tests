pipeline {
   agent { docker { image 'maven:3.3.3' } }

   stages {
      /* stage('Initialize'){
           def dockerHome = tool 'myDocker'
           env.PATH = "${dockerHome}/bin:${env.PATH}"
      } */
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
/*              sh 'export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64'
             sh 'curl -N https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_mac64.zip -P ~/'
             sh 'gzip ~/chromedriver_linux64.zip -d ~/'
              sh 'rm ~/chromedriver_linux64.zip'
              sh 'mv -f ~/chromedriver /usr/local/bin/chromedriver'
              sh 'chown root:root /usr/local/bin/chromedriver'
              sh 'chmod 0755 /usr/local/bin/chromedriver' */
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
