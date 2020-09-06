def call(String repo_url, String branch) {
  pipeline {
    agent any
    stages {
      stage('pull repo_url') {
        steps {
          echo repo_url

          sh 'rm -rf source_code'
          sh "git clone ${repo_url} source_code"
        }
      }
      stage('Checkout branch') {
        steps {
          sh '''
            cd source_code
            git reset HEAD --hard
            git fetch origin ${branch}
            git checkout ${repo_url}
          '''
        }
      }
    }
  }
}
