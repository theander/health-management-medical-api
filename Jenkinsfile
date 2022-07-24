pipeline {
    agent any
    tools {
            maven 'Maven 3.8.3'
            jdk 'jdk17'
    }

    stages {
        stage('Checkout SCM') {
            steps {
                    echo 'Checkout scm...'
                    checkout scm
            }
        }
        stage ('Initialize') {
            steps {
                sh '''
                   echo "PATH = ${PATH}"
                   echo "M2_HOME = ${M2_HOME}"
                   '''
           }
        }
        stage('Jenkins trigger') {
            steps {
                echo 'Github web hook'
            }
        }        
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
