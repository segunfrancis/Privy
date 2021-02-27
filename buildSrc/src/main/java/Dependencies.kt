object Versions {
    const val kotlin = "1.4.21"
    const val gradle = "7.0.0-alpha05"
    const val navigation = "2.3.3"
    const val appcompat = "1.3.0-beta01"
    const val legacy = "1.0.0"
    const val constraint = "2.1.0-alpha2"
    const val material = "1.3.0"
    const val coreKtx = "1.5.0-beta01"
    const val workManager = "2.5.0"
    const val lifecycle = "2.3.0"
    const val coroutines = "1.4.1"
    const val room = "2.2.6"
    const val koin = "2.2.2"

    /* Tests */
    const val junit = "4.13.2"
    const val junitExt = "1.1.2"
    const val espresso = "3.3.0"
}

object Apps {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildTools = "30.0.3"
    const val applicationId = "com.segunfrancis.privy"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Dependencies {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
}

object TestDependencies {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}