plugins {
    id("spring-boot-conventions")
}

dependencies {
    // Spring Boot Starter
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Spring Boot Devtools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // H2 Database
    runtimeOnly("com.h2database:h2")

    // Unit Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    implementation(project(":app:steam"))
    implementation(project(":app:todo-info"))
    implementation(project(":app:zipcode"))
}
