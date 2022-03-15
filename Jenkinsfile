@Library('ceiba-jenkins-library') _
pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
 	gitLabConnection('GitCeiba')
  }

  environment {
    PROJECT_PATH_BACK = 'microservicio'
  }

  triggers {
    // @yearly, @annually, @monthly, @weekly, @daily, @midnight, and @hourly o definir un intervalo. Ej: H */4 * * 1-5
    pollSCM('@daily') //define un intervalo regular en el que Jenkins debería verificar los cambios de fuente nuevos
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Verisión preinstalada en la Configuración del Master
  }
/*	Versiones disponibles
      JDK8_Mac
      JDK6_Centos
      JDK7_Centos
      JDK8_Centos
      JDK10_Centos
      JDK11_Centos
      JDK13_Centos
      JDK14_Centos
*/

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout scm

        dir("${PROJECT_PATH_BACK}") {
            sh 'chmod +x ./gradlew'
            sh './gradlew clean'
          }
      }
    }

    stage('Compile & Unit Tests') {
       parallel {
          stage('Test- Backend'){
             steps {
                echo '------------>Test Backend<------------'
                dir("${PROJECT_PATH_BACK}"){
                    sh 'chmod +x gradlew'
                    sh './gradlew --b ./build.gradle test'
                  }
              }
             post{
                always {
                    junit '**/build/test-results/test/*.xml' //Configuración de los reportes de JUnit
                }
             }
          }
       }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
            sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:[galeria-bryan.guzman]',
            sonarName:'CeibaADN-Galeria(bryan.guzman)',
            sonarPathProperties:'./sonar-project.properties')
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        sh 'chmod +x ./presupuesto/gradlew'
        sh './presupuesto/gradlew --b ./presupuesto/build.gradle clean'
        sh './presupuesto/gradlew --b ./presupuesto/build.gradle build -x test'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'bryan.guzman@ceiba.com.co',
            subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
            body: "Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
