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

    object AndroidX {
        const val core = "androidx.core:core-ktx:${coreVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${appCompatVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"

        object Test {
            const val jUnit = "androidx.test.ext:junit:${jUnitExtVersion}"
            const val espresso = "androidx.test.espresso:espresso-core:${espressoVersion}"
        }
    }

    object Test {
        const val jUnit = "junit:junit:${jUnitVersion}"
    }
}
