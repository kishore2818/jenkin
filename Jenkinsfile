pipeline {
    agent any

    tools {
        // These names must match what you configured in Jenkins Manage Tools
        gradle 'Gradle 8.x'
        jdk 'Java 17'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from Git...'
            }
        }

        stage('Build') {
            steps {
                echo 'Building application...'
                // Build the JAR file
                sh 'gradle build -x test'
            }
        }

        stage('Test') {
            steps {
                echo 'Running automated tests...'
                sh 'gradle test'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application to local environment...'
                sh '''
                # 1. Stop any old version of the app running on port 9090
                echo "Stopping old app if running..."
                lsof -ti:9090 | xargs kill -9 || true

                # 2. Find the newly built JAR file
                JAR=$(ls build/libs/*.jar | head -n 1)
                echo "Found JAR: $JAR"

                # 3. Start the app in the background using nohup
                echo "Starting app on port 9090..."
                nohup java -jar $JAR > app.log 2>&1 &
                
                # 4. Give it a moment to start
                sleep 5
                echo "Deployment complete! Check http://localhost:9090"
                '''
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline finished successfully!'
        }
        failure {
            echo 'Pipeline failed. Check Console Output for errors.'
        }
    }
}