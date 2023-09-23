def call() {
    pipeline {
        agent { label 'worker2' }
        stages {
            stage('Install Nginx') {
                steps {
                    sh 'sudo apt update'
                    sh 'sudo apt install -y nginx'
                }
            }
            stage('Start Nginx') {
                steps {
                    sh 'sudo systemctl start nginx'
                }
            }
            stage('Testing') {
                steps {
                    sh 'curl localhost'
                }
            }
        }
    }
}
