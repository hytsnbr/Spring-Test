import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("spring-boot-conventions")
}

tasks.named<BootJar>("bootJar") {
    enabled = false
}

dependencies {
    // Spring Boot Starter
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc") {
        exclude(group = "com.zaxxer", module = "HikariCP")
    }
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
}
