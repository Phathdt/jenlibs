@Library('jenlibs@master') _

pipeline{
    agent any

    environment {
        BRANCH = "master"
    }

    stages{
        stage("A"){
            steps{
                git branch: BRANCH,
                    url: checkoutBranch("https://github.com/Phathdt/express-boilerplate")
            }
        }
    }
}
