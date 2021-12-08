plugins {
  application
  kotlin("jvm") version "1.6.0"
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
  implementation("com.google.guava:guava:30.1.1-jre")
  implementation("org.projectlombok:lombok:1.18.22")
  annotationProcessor("org.projectlombok:lombok:1.18.22")
  testImplementation("io.mockk:mockk:1.12.1")
  testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
}

application {
  mainClass.set("com.cruftbusters.java_starter.App")
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}
