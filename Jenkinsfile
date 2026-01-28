pipeline {
       agent any

        tools {
            jdk 'JDK17'
            maven 'mvn3'
            nodejs 'nodeJS25'
        }

        stages {

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
