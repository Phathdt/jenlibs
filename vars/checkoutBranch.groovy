def call(repo_url, branch) {
  pipeline {
    agent any
    stages {
      stage('pull repo_url') {
        steps {
          sh '''
            rm -rf source_code
            git clone ${repo_url} source_code
          '''
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
