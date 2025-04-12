pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven 3.8.8' // Make sure this matches your Maven config
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
                bat '"C:\\Program Files\\apache-maven-3.8.8-bin\\apache-maven-3.8.8\\bin\\mvn.cmd" clean test'
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
