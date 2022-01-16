plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    id(Plugins.hilt)
}

android {
    compileSdk = Application.compileSdk
    defaultConfig {
        applicationId = Application.applicationId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc01"
    }
}

dependencies {
    implementation(project(Modules.shared))
    implementation(Material.material)
    implementation(AndroidX.appCompact)

    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.activity)
    implementation(Compose.navigation)



    implementation(Ktor.android)

    //hilt injection and hilt compose
    implementation(Hilt.hiltAndroid)
    implementation(Hilt.navigationCompose)
    kapt(Hilt.hiltCompiler)

    //load image
    implementation(Coil.coil)

    //pager for implement tab layout
    implementation(Accompanist.pager)
}