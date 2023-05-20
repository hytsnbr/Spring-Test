plugins {
    id("spring-boot-conventions")
}

dependencies {
    // Spring Boot Starter
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation(project(":app:base-common"))
}
