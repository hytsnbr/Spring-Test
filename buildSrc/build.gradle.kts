plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.2.2")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.4")
}
