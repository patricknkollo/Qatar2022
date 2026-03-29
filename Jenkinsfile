//@Library("shared_library1") _

pipeline {
       agent any

        tools {
            jdk 'JDK17'
            maven 'mvn3'
            nodejs 'nodeJS25'
        }

        triggers {
        cron(env.BRANCH_NAME == 'main' ? 'H 1 * * *' : '')
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

            stage('Copy Frontend into Backend') {
                steps {
                    bat 'xcopy frontend\\build src\\main\\resources\\static /E /Y /I'
                }
            }

           /*  stage('Build Docker Image') {
                 steps {
                     bat """
                     docker build -t %IMAGE_NAME%:%IMAGE_TAG% .
                     """
                 }
            } */

             stage('Build Docker Image') {
                 steps {
                     buildKursnetBatchContainer()
                 }
             }

              stage('push Docker Image') {
                  steps {
                     dockerPushBatchesImage()
                  }
              }

              stage('deploy Docker Image') {
                 steps {
                    deployKursnetBatchToK8s()
                 }
              }

/*             stage('Docker Login') {
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

          stages {
                  stage('Hello world') {
                      steps {
                              sh 'echo hello world from jenkinsfile'
                      }
                  }
           }

            stages {
                     stage('Shared lib test') {
                         steps {
                                 helloWorld() ' from shared library'
                         }
                     }
             }
 */
        post {
            success {
                echo '✅ Backend + UI buildés avec succès'
            }
            failure {
                echo '❌ Build échoué'
            }
        }
}

 def buildKursnetBatchContainer(){
    dir("kubernetes/container"){
    echo 'docker build !!!'
    }
        //build Batche-Image
        bat """
        docker build -t ${IMAGE_NAME} -f kubernetes/container/Dockerfile .
        docker tag ${IMAGE_NAME}:${IMAGE_TAG}
        """
}


def dockerPushBatchesImage() {
    dir(".") {
        script {
            docker.withRegistry("https://index.io/v1/", DOCKERHUB_CREDENTIALS) {
               bat """
                  docker push ${IMAGE_NAME}
                  docker tag ${IMAGE_NAME}:${IMAGE_TAG}
               """
            }
        }
    }
}

def deployKursnetBatchToK8s(){
    dir("kubernetes/k8s"){
        script{
              //deploy den Kursneta-Batches
              bat "kubectl apply -f deployment.yaml"
              //Bau den Service des Kursneta-Batches
              bat "kubectl apply -f service.yaml"
        }
    }
}



