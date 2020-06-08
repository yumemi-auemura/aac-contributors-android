import com.android.build.gradle.internal.dsl.BuildType

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

apply(plugin = "dagger.hilt.android.plugin")

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"
    defaultConfig {
        applicationId = "com.github.auemura.aaccontributors"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        debug {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }
        debugMinify {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        mock {}
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        testBuildType = "mock"
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.KotlinX.coroutinesCore)
    implementation(Dependencies.KotlinX.coroutinesAndroid)
    testImplementation(Dependencies.KotlinX.Test.coroutinesTest)

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.livedata)
    implementation(Dependencies.AndroidX.viewModel)
    implementation(Dependencies.AndroidX.viewModelSavedState)

    // Dagger2 https://github.com/google/dagger
    api(Dependencies.Google.dagger)
    kapt(Dependencies.Google.daggerCompiler)

    // Dagger2 Hilt
    implementation(Dependencies.Google.hiltAndroid)
    kapt(Dependencies.Google.hiltAndroidCompiler)

    // AndroidX + Dagger Hilt
    implementation(Dependencies.AndroidX.hiltCommon)
    implementation(Dependencies.AndroidX.hiltLifecycleViewModel)
    kapt(Dependencies.AndroidX.hiltCompiler)

    // AndroidX + Dagger Hilt
    implementation(Dependencies.AndroidX.hiltWork)

    testImplementation(Dependencies.Test.jUnit)

    androidTestImplementation(Dependencies.AndroidX.Test.jUnit)
    androidTestImplementation(Dependencies.AndroidX.Test.espresso)
}

fun NamedDomainObjectContainer<BuildType>.debug(body: BuildType.() -> Unit) {
    getByName("debug") { body(this) }
}

fun NamedDomainObjectContainer<BuildType>.debugMinify(body: BuildType.() -> Unit) {
    create("debugMinify") {
        initWith(getByName("debug"))
        matchingFallbacks = mutableListOf("debug")
        body(this)
    }
}

fun NamedDomainObjectContainer<BuildType>.mock(body: BuildType.() -> Unit) {
    create("mock") {
        initWith(getByName("debug"))
        matchingFallbacks = mutableListOf("debug")
        body(this)
    }
}

fun NamedDomainObjectContainer<BuildType>.release(body: BuildType.() -> Unit) {
    getByName("release") { body(this) }
}