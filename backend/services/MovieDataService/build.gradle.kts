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
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation ("org.springframework.boot:spring-boot-starter-logging")

}
