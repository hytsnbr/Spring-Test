plugins {
    id("org.sonarqube") version "6.1.0.5360"
}

dependencies {

}

sonar {
    properties {
        property("sonar.projectKey", "hytsnbr_Spring-Test")
        property("sonar.organization", "hytsnbr")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
