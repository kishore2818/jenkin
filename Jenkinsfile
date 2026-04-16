// pipeline {
//     agent any

//     tools {
//         // This requires 'Gradle' to be configured in Jenkins Global Tool Configuration
//         gradle 'Gradle 8.x'
//         jdk 'Java 17'
//     }

//     stages {
//         stage('Checkout') {
//             steps {
//                 // Jenkins usually handles checkout automatically for Pipeline from SCM
//                 script {
//                     echo 'Checking out code from Git...'
//                 }
//             }
//         }

//         stage('Build') {
//             steps {
//                 echo 'Building application...'
//                 // Using gradlew if available, otherwise 'gradle'
//                 sh 'gradle build -x test'
//             }
//         }

//         stage('Test') {
//             steps {
//                 echo 'Running automated tests...'
//                 sh 'gradle test'
//             }
//             post {
//                 always {
//                     // Archive JUnit test results
//                     junit 'build/test-results/test/*.xml'
//                 }
//             }
//         }

//         stage('Deploy') {
//             steps {
//                 echo 'Deploying to Web Page...'
//                 // Demonstration of a deployment command
//                 script {
//                     echo 'Deployment logic goes here (e.g., docker push, cloud foundry, etc.)'
//                     echo 'Application is live at: http://localhost:9090'
//                 }
//             }
//         }
//     }

//     post {
//         success {
//             echo 'Pipeline completed successfully!'
//         }
//         failure {
//             echo 'Pipeline failed. Please check the logs.'
//         }
//     }
// }




stage('Deploy') {
    steps {
        echo 'Deploying application...'
        sh '''
        echo "Stopping old app..."
        pkill -f 'java -jar' || true

        echo "Building JAR..."
        ls build/libs

        JAR=$(ls build/libs/*.jar | head -n 1)

        echo "Starting app on port 9090..."
        nohup java -jar $JAR > app.log 2>&1 &

        sleep 5
        echo "App started successfully"
        '''
    }
}