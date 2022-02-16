plugins {
    kotlin("multiplatform").version("<pluginMarkerVersion>")
}

allprojects {
    repositories {
        maven("$rootDir/../repo")
        mavenLocal()
        mavenCentral()
    }
}

kotlin {
    jvm()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("kt50925:lib:1.0")
                implementation(project(":subproject"))
            }
        }
    }
}