plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate:hibernate-core:6.3.1.Final")
    implementation("mysql:mysql-connector-java:8.0.18")
    implementation("org.apache.logging.log4j:log4j-core:2.12.1")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")
    implementation("org.hibernate.validator:hibernate-validator-annotation-processor:8.0.1.Final")
    implementation("org.glassfish.expressly:expressly:5.0.0")
    implementation ("jakarta.validation:jakarta.validation-api:3.1.0-M1") // Use the latest version available
    implementation ("jakarta.persistence:jakarta.persistence-api:3.2.0-M1")

}

tasks.test {
    useJUnitPlatform()
}