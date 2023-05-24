import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    id("maven-publish")
}

group = "br.com.devsrsouza"
version = "0.7.0"

repositories {
    mavenCentral()
    maven("https://maven.google.com")
    maven("https://jetbrains.bintray.com/trove4j")
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.android.tools:sdk-common:31.1.0-beta02")
    implementation("com.android.tools:common:31.1.0-beta02")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.21")
    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("xpp3:xpp3:1.1.4c")
    implementation("xmlpull:xmlpull:1.1.3.1")

    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
        }
    }
}
