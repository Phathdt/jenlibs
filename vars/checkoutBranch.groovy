def call(branch) {
  pipeline {
    agent any
    stages {
      stage('Checkout branch') {
        steps {
          echo "Hello, ${branch}."
        }
      }
    }
  }
}
