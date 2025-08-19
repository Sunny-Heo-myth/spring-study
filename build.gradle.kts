plugins {
    java
    id("io.spring.dependency-management") version "1.1.6"
    id("org.springframework.boot") version "3.3.2"
}

group = "org.alan"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}


repositories {
    mavenCentral()
}

springBoot {
    mainClass.set("org.alan.toby.TobyApp")
}


dependencies {
    // spring boot starter
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // database & jpa
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.hibernate.validator:hibernate-validator")

    // resilience4j
    implementation("io.github.resilience4j:resilience4j-retry:2.2.0")

    // development tool
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // lombok (pin to a JDK 21–compatible version)
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.test {
    useJUnitPlatform()
}