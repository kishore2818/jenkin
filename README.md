# Hello World Automation Project

This project demonstrates a fully automated CI/CD pipeline using **Gradle**, **Java 17**, **Spring Boot**, and **Jenkins**.

## Project Features
- **Web Interface**: Simple "Hello World" page served via Spring Boot.
- **Automated Testing**: JUnit 5 tests to verify functionality.
- **CI/CD Pipeline**: `Jenkinsfile` ready for automation.
- **Build System**: Gradle.

## How to Run Locally
Ensure you have Java 17 installed.

1. **Build the project**:
   ```bash
   gradle build
   ```
2. **Run the application**:
   ```bash
   gradle bootRun
   ```
3. **Access the webpage**:
   Open [http://localhost:8080](http://localhost:8080) in your browser.

## CI/CD with Jenkins
1. Push this project to a Git repository.
2. Create a "Pipeline" job in Jenkins.
3. Point the job to your Git repository and set the script path to `Jenkinsfile`.
4. Run the build.

## Project Structure
- `src/main/java`: Application source code.
- `src/test/java`: Automated tests.
- `build.gradle`: Project dependencies and plugins.
- `Jenkinsfile`: Pipeline definition.
