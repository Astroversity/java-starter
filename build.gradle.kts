plugins {
    application
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("io.ktor:ktor-jackson:1.6.7")
    implementation("io.ktor:ktor-server-core:1.6.7")
    implementation("io.ktor:ktor-server-netty:1.6.7")
    implementation("org.projectlombok:lombok:1.18.22")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.0.1")
    testImplementation("io.kotest:kotest-runner-junit5:5.0.1")
    testImplementation("io.ktor:ktor-client-cio:1.6.7")
    testImplementation("io.ktor:ktor-client-core:1.6.7")
    testImplementation("io.ktor:ktor-client-jackson:1.6.7")
    testImplementation("io.mockk:mockk:1.12.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

application {
    mainClass.set("com.cruftbusters.java_starter.ApplicationKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
