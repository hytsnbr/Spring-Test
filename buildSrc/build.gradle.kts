plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.3.6")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.6")
}
