plugins {
    kotlin("jvm") version "1.4.31"
}

group = "game"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.javalin", "javalin", "3.13.4")
    implementation("org.slf4j", "slf4j-simple", "1.7.30")

    testImplementation("junit", "junit", "4.12")
}