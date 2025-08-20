plugins {
    java
    id("io.spring.dependency-management") version ("1.1.7")
    id("org.springframework.boot") version ("3.4.3")
    id("io.freefair.lombok") version ("8.13")
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

    implementation("org.springframework.kafka:spring-kafka")

    // database & jpa
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.hibernate.validator:hibernate-validator")

    // resilience4j => dependency did not resolved well, given a specific one
    implementation("io.github.resilience4j:resilience4j-spring-boot3:2.2.0")

    // development tool
    developmentOnly("org.springframework.boot:spring-boot-devtools")

//    // lombok (pin to a JDK 21–compatible version)
//    compileOnly("org.projectlombok:lombok:1.18.34")
//    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.test {
    useJUnitPlatform()
}