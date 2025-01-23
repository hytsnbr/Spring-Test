plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.4.2")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.7")
}
