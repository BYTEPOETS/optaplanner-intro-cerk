plugins {
    id(Plugins.KOTLIN)
}

group = "com.bytepoets"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(KotlinCore.KOTLIN_STD_LIB)
    implementation(project(":solver"))
    implementation(Logging.LOGBACK_CLASSIC)
    implementation(Benchmarking.OPTAPLANNER_BENCHMARK)
}
