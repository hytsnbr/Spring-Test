plugins {
    java
    idea
}

group = "com.hytsnbr"
version = "0.0.1"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Apache Commons
    implementation("org.apache.commons:commons-lang3:3.18.0")
    implementation("org.apache.commons:commons-collections4:4.5.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
