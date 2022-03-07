pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh 'echo "Test Branches"'
        withMaven() {
          sh 'mvn test'
        }

      }
    }

    stage('Build') {
      when {
        branch 'main'
      }
      steps {
        withMaven() {
          sh 'mvn clean package'
        }

      }
    }

    stage('Build Docker Image') {
      when {
        branch 'main'
      }
      steps {
        sh 'echo "Building Docker Image"'
        script {
          dockerImage = docker.build "$registry"
        }

      }
    }

    stage('Delivering Docker Image') {
      when {
        branch 'main'
      }
      steps {
        sh 'echo "Delivering Docker Image"'
        script {
          docker.withRegistry('', dockerHubCreds) {
            dockerImage.push("$currentBuild.number")
            dockerImage.push("latest")

          }
        }

      }
    }

    stage('Deploy into Kubernetes') {
      when {
        branch 'main'
      }
      steps {
        sh 'echo "Starting Deployment to Kubernetes"'
        sh 'sed -i "s/%TAG%/$BUILD_NUMBER/g" ./Kubernetes/deployment.yml'
        sh 'cat ./Kubernetes/deployment.yml'
        step([$class: 'KubernetesEngineBuilder',
                              projectId: 'united-button-342103',
                              clusterName: 'pogi-firstcluster',
                              zone: 'us-central1-a',
                              manifestPattern: 'Kubernetes/',
                              credentialsId: 'united-button-342103',
                              verifyDeployments: true
                        ])
      }
    }

  }
  environment {
    registry = 'project2team4/email'
    dockerHubCreds = 'Docker_Credential'
    dockerImage = ''
    deploymentFile = 'Kubernetes/deployment.yml'
  }
}