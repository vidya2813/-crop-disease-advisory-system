
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
        stage('Docker Build') {
    steps {
        bat '"C:/Users/hemal/AppData/Local/Programs/DockerDesktop/resources/bin/docker.exe" --version'

        bat '"C:/Users/hemal/AppData/Local/Programs/DockerDesktop/resources/bin/docker.exe" build -t crop-advisory:%BUILD_NUMBER% .'
        }
    }

        stage('Kubernetes Connection Check') {
            steps {
                bat 'set KUBECONFIG=C:/Users/hemal/.kube/config && "C:/Users/hemal/AppData/Local/Programs/DockerDesktop/resources/bin/kubectl.exe" config current-context'

                bat 'set KUBECONFIG=C:/Users/hemal/.kube/config && "C:/Users/hemal/AppData/Local/Programs/DockerDesktop/resources/bin/kubectl.exe" get nodes'
            }
        }
                stage('Kubernetes Deployment') {
            steps {
                bat 'set KUBECONFIG=C:/Users/hemal/.kube/config && "C:/Users/hemal/AppData/Local/Programs/DockerDesktop/resources/bin/kubectl.exe" set image deployment/crop-advisory crop-advisory=crop-advisory:%BUILD_NUMBER%'

                bat 'set KUBECONFIG=C:/Users/hemal/.kube/config && "C:/Users/hemal/AppData/Local/Programs/DockerDesktop/resources/bin/kubectl.exe" rollout status deployment/crop-advisory'
            }
        }

        
    }
}
