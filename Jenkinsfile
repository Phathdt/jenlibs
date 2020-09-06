@Library('jenlibs@master') _

pipeline{
    agent any

    environment {
        REPO_URL = "https://github.com/Phathdt/express-boilerplate"
        BRANCH = "master"
    }

    stages{
        stage("A"){
            steps{
                sh "rm -rf *"
                sh "git clone ${checkoutBranch(REPO_URL)} source_code"

                sh "cd source_code && git checkout ${BRANCH}"
            }
        }
    }
}
