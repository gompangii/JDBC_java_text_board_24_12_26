plugins {
    id("java")
}

group = "com.sbs.java.jdbc.board"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    //implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.33'
    implementation("mysql:mysql-connector-java:8.0.33")
    compileOnly("org.projectlombok:lombok:1.18.36")
}

tasks.test {
    useJUnitPlatform()
}