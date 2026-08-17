plugins {
    id("org.sonarqube") version "7.4.0.8496"
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
