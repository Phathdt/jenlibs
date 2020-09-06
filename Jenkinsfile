@Library('jenlibs@master') _

pipeline{
    agent any

    environment {
        BRANCH = "master"
    }

    stages{
        stage("clone source code"){
            steps{
                git branch: BRANCH,
                    url: checkoutBranch("https://github.com/Phathdt/express-boilerplate")
            }
        }

        stage("send mail"){
            steps{
                sendEmail currentBuild, ['phathdt379@gmail.com']
            }
        }
    }
}
