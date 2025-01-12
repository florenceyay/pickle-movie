plugins {
	kotlin("jvm") version "1.8.0" apply false
	id("org.springframework.boot") version "3.0.0" apply false
	id("io.spring.dependency-management") version "1.1.0" apply false
}

subprojects {
	apply(plugin = "io.spring.dependency-management")

	repositories {
		mavenCentral()
	}
}
