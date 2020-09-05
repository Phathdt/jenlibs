def call(branch) {
  pipeline {
    agent any
    stages {
      stage('Checkout branch') {
        steps {
          sh 'cd /var/lib/jenkins/source_code'
          sh "git checkout ${branch}"
        }
      }
    }
  }
}
