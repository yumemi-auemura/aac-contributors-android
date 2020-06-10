package com.github.auemura.aaccontributors

import android.app.Application
import com.github.auemura.aaccontributors.ui.error.ErrorController
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    internal lateinit var errorController: ErrorController

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(errorController.activityLifecycleCallbacks)
    }
}
