pipeline {
    agent any

    tools {
        jdk 'JDK-21'
        maven 'Maven-3.10.0'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Source code checkout completed'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
    }
}