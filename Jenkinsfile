@Library('jenlibs@master') _

pipeline{
    agent any

    environment {
        BRANCH = "master"
    }

    libraries {
        lib('github.com/cfpb/jenkins-shared-libraries')
        lib('github.com/Phathdt/jenlibs')
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
