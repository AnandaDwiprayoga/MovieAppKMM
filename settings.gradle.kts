pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

//it's suck cause now settings.gradle cannot reference to buildSrc, see the issues https://github.com/gradle/gradle/issues/11090
//so we have to hardcode

rootProject.name = "MovieKmm"
include(":androidMovieApp")
include(":shared")
