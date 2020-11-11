import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}
group = "me.khalithartmann"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()

}
dependencies {
    testImplementation(kotlin("test-junit5"))
    implementation("org.simplejavamail:simple-java-mail:6.4.4")
    implementation("org.simplejavamail:batch-module:6.4.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")


}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
