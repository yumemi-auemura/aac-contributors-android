buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-beta01")
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
        classpath(kotlin("serialization", version = "1.3.72"))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = uri("https://androidx.dev/snapshots/builds/6543454/artifacts/repository/"))
    }
}

task<Delete>("clean") {
    delete = setOf(rootProject.buildDir)
}
