pipeline {
       agent any

        tools {
            jdk 'JDK17'
            maven 'mvn3'
            nodejs 'nodeJS25'
        }

        environment {
                DOCKERHUB_CREDENTIALS = credentials('my-dockerhub-credentials')
                IMAGE_NAME = "pnkollo/docker-springboot"
                IMAGE_TAG = "latest"
        }

        stages {

            stage('Test Docker') {
                steps {
                    bat 'docker ps'
                }
            }

            stage('Checkout Backend') {
                steps {
                    checkout scm
                }
            }

            stage('Checkout Frontend') {
                steps {
                    dir('frontend') {
                        git branch: 'main',
                            url: 'https://github.com/patricknkollo/Qatar22_frontend.git'
                    }
                }
            }

            stage('Build Backend') {
                steps {
                    bat 'mvn clean package -DskipTests'
                }
            }

            stage('Build Frontend') {
                steps {
                    dir('frontend') {
                        bat 'npm install'
                        bat 'npm run build'
                    }
                }
            }

            stage('Build Docker Image') {
                 steps {
                     bat """
                     docker build -t %IMAGE_NAME%:%IMAGE_TAG% .
                     """
                 }
            }

            stage('Docker Login') {
                 steps {
                     bat """
                     echo %DOCKERHUB_CREDENTIALS_PSW% | docker login -u %DOCKERHUB_CREDENTIALS_USR% --password-stdin
                     """
                 }
            }

            stage('Push Image to Docker Hub') {
                steps {
                       bat """
                       docker push %IMAGE_NAME%:%IMAGE_TAG%
                       """
                }
            }
        }

        post {
            success {
                echo '✅ Backend + UI buildés avec succès'
            }
            failure {
                echo '❌ Build échoué'
            }
        }
}
