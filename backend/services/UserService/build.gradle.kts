plugins {
    id("org.springframework.boot")
    kotlin("jvm")
}
sourceSets {
    test {
        java {
            srcDirs("src/test/java")
        }
    }
}
tasks.test {
    useJUnitPlatform()
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("org.springframework.boot:spring-boot-starter-oauth2-client") // OAuth2 Login
    implementation("org.springframework.boot:spring-boot-starter-security") // Security

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    implementation("org.projectlombok:lombok:1.18.30")  // Lombok for reducing boilerplate code
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

