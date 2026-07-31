pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3.9.16'
    }

    environment {
        BROWSER = 'chrome'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
        }
    }
}