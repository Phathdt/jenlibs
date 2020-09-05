def call(branch) {
  pipeline {
    agent any
    stages {
      stage('pull code') {
        steps {
          echo 'ls -l'
          echo 'pwd'
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
