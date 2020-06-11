object Dependencies {

    private const val kotlinVersion = "1.3.72"
    private const val coreVersion = "1.3.0"
    private const val appCompatVersion = "1.1.0"
    private const val constraintLayoutVersion = "1.1.3"
    private const val jUnitExtVersion = "1.1.1"
    private const val espressoVersion = "3.2.0"
    private const val jUnitVersion = "4.13"

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
    }

    object KotlinX {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6"
        const val kotlinxSerializationRuntime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0"

        object Test {
            const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.6"
        }
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${coreVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${appCompatVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0"
        const val hiltCommon = "androidx.hilt:hilt-common:1.0.0-SNAPSHOT"
        const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-SNAPSHOT"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0-SNAPSHOT"
        const val hiltWork = "androidx.hilt:hilt-work:1.0.0-SNAPSHOT"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.0-beta01"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.3.0-beta01"

        object Test {
            const val jUnit = "androidx.test.ext:junit:${jUnitExtVersion}"
            const val espresso = "androidx.test.espresso:espresso-core:${espressoVersion}"
        }
    }

    object Google {
        const val dagger = "com.google.dagger:dagger:2.28"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:2.28"
        const val hiltAndroid = "com.google.dagger:hilt-android:2.28-alpha"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"
    }

    object Airbnb {
        const val epoxy = "com.airbnb.android:epoxy:4.0.0-beta4"
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:4.0.0-beta4"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.8.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.5.0"
        const val kotlinxSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.5.0"
    }

    object Test {
        const val jUnit = "junit:junit:${jUnitVersion}"
    }
}
