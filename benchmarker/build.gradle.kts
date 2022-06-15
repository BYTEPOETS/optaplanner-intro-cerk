plugins {
    id(Plugins.KOTLIN)
}

group = "com.bytepoets"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":solver"))
}
