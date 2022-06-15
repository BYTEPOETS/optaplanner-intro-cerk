plugins {
    id(Plugins.KOTLIN)
}

group = "com.bytepoets"

repositories {
    mavenCentral()
}

dependencies {
    api(Domain.OPTAPLANNER_CORE)

    implementation(KotlinCore.KOTLIN_STD_LIB)
    implementation(Logging.LOGBACK_CLASSIC)

    testImplementation(Testing.KOTEST_ASSERTIONS)
    testImplementation(Testing.JUNIT_JUPITER_API)
    testImplementation(Testing.JUNIT_JUPITER_PARAMS)
    testImplementation(Testing.OPTAPLANNER_TEST)

    testRuntimeOnly(Testing.JUNIT_JUPITER_ENGINE)
}

tasks.test {
    useJUnitPlatform()
}
