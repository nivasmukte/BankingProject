pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven-3.8.8' // Make sure this matches your Maven config
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/nivasmukte/BankingProject.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'

                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber-html-reports.html',
                    reportName: 'Cucumber HTML Report'
                ])
            }
        }
    }

    post {
        success {
            echo "✅ Build and tests succeeded!"
        }
        failure {
            echo "❌ Something failed during the build or tests!"
        }
    }
}
