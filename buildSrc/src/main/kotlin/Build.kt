object Build {
    private const val buildGradleVersion = "7.0.4"
    const val buildGradleTools = "com.android.tools.build:gradle:$buildGradleVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"
    const val buildKonfigTools = "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${BuildKonfig.version}"
    const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${SqlDelight.sqlDelightVersion}"
}