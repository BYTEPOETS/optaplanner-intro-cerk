
import Domain.OPTAPLANNER_GROUP
import KotlinCore.KOTLIN_GROUP
import Versions.CLIKT_VERSION
import Versions.JUNIT_VERSION
import Versions.KOTEST_VERSION
import Versions.KOTLIN_CSV_VERSION
import Versions.LOGBACK_VERSION
import Versions.OPTAPLANNER_VERSION

object Versions {
    const val KOTLIN_VERSION = "1.6.0"

    const val OPTAPLANNER_VERSION = "8.14.0.Final"

    const val CLIKT_VERSION = "3.3.0"

    const val KOTLIN_CSV_VERSION = "1.1.0"

    const val KOTEST_VERSION = "4.6.1"
    const val JUNIT_VERSION = "5.7.2"

    const val LOGBACK_VERSION = "1.2.10"
}

object Plugins {
    const val KOTLIN = "$KOTLIN_GROUP.jvm"
    const val KAPT = "kapt"
}

object KotlinCore {
    const val KOTLIN_GROUP = "org.jetbrains.kotlin"
    const val KOTLIN_STD_LIB = "$KOTLIN_GROUP:kotlin-stdlib"
    const val KOTLIN_REFLECT = "$KOTLIN_GROUP:kotlin-reflect"
}

object Domain {
    const val OPTAPLANNER_GROUP = "org.optaplanner"
    const val OPTAPLANNER_CORE = "$OPTAPLANNER_GROUP:optaplanner-core:$OPTAPLANNER_VERSION"
}

object Serialization {
    const val KOTLIN_CSV = "com.github.doyaaaaaken:kotlin-csv-jvm:$KOTLIN_CSV_VERSION"

    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"
}

object Cli {
    private const val CLIKT_GROUP = "com.github.ajalt.clikt"
    const val CLIKT = "$CLIKT_GROUP:clikt:$CLIKT_VERSION"
}

object Testing {
    private const val KOTEST_GROUP = "io.kotest"
    const val KOTEST_ASSERTIONS = "$KOTEST_GROUP:kotest-assertions-core-jvm:$KOTEST_VERSION"
    const val KOTEST_PROPERTIES = "$KOTEST_GROUP:kotest-property-jvm:$KOTEST_VERSION"

    private const val JUNIT_GROUP = "org.junit.jupiter"
    const val JUNIT_JUPITER_API = "$JUNIT_GROUP:junit-jupiter-api:$JUNIT_VERSION"
    const val JUNIT_JUPITER_PARAMS = "$JUNIT_GROUP:junit-jupiter-params:$JUNIT_VERSION"
    const val JUNIT_JUPITER_ENGINE = "$JUNIT_GROUP:junit-jupiter-engine:$JUNIT_VERSION"

    const val OPTAPLANNER_TEST = "$OPTAPLANNER_GROUP:optaplanner-test:$OPTAPLANNER_VERSION"
}

object Benchmarking {
    const val OPTAPLANNER_BENCHMARK = "$OPTAPLANNER_GROUP:optaplanner-benchmark:$OPTAPLANNER_VERSION"
}

object Logging {
    const val LOGBACK_GROUP = "ch.qos.logback"
    const val LOGBACK_CLASSIC = "$LOGBACK_GROUP:logback-classic:$LOGBACK_VERSION"
}
