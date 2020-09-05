def call(branch) {
  pipeline {
    agent any
    stages {
      stage('pull code') {
        steps {
          sh 'ls -l'
          sh 'pwd'
        }
      }

      stage('Checkout branch') {
        steps {
          echo "Hello, ${branch}."
        }
      }
    }
  }
}
