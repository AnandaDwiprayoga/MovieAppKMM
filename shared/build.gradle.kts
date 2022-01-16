import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id("com.android.library")
    id(Plugins.buildKonfig)
    id(Plugins.sqlDelight)
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    //iosSimulatorArm64() sure all ios dependencies support this target

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosMovieApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Ktor.core)
                implementation(Ktor.clientSerialization)
                implementation(Ktor.logging)
                implementation(SqlDelight.runtime)
                implementation(SqlDelight.sqlDelightCoroutines)
            }
        }
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test-common"))
//                implementation(kotlin("test-annotations-common"))
//            }
//        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.android)
                implementation(SqlDelight.androidDriver)
            }
        }
//        val androidTest by getting {
//            dependencies {
//                implementation(kotlin("test-junit"))
//                implementation("junit:junit:4.13.2")
//            }
//        }
        val iosX64Main by getting
        val iosArm64Main by getting
        //val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)

            dependencies {
                implementation(Ktor.ios)
                implementation(SqlDelight.nativeDriver)
            }
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            //iosSimulatorArm64Main.dependsOn(this)
        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        //val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            //iosSimulatorArm64Test.dependsOn(this)
//        }
    }
}

buildkonfig {
    packageName = "com.pasukanlangit.id.moviekmm"
    val key: String = gradleLocalProperties(rootDir).getProperty("API_KEY")
    defaultConfigs {
        buildConfigField(
            Type.STRING,
            "API_KEY",
            key
        )
    }
}


android {
    compileSdk = Application.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
    }
}

sqldelight {
    database("AflixDatabase"){
        packageName = "com.pasukanlangit.id.moviekmm.datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}