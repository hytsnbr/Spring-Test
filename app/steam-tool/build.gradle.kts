plugins {
    id("spring-boot-conventions")
}

dependencies {
    // Spring Boot Starter
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Apache Velocity
    implementation("org.apache.velocity:velocity-engine-core:2.4.1")

    // Google Guava
    implementation("com.google.guava:guava:33.3.1-jre")

    implementation(project(":app:base-common"))
}