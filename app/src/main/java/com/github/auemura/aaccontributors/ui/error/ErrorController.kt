package com.github.auemura.aaccontributors.ui.error

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.AnyThread
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorController @Inject constructor() {

    private val errorHolder = MutableLiveData<String>()

    @AnyThread
    fun notifyException(e: Throwable) {
        errorHolder.postValue(e.message)
    }

    val activityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        }

        override fun onActivityStarted(activity: Activity) {
        }

        override fun onActivityResumed(activity: Activity) {
            if (activity is FragmentActivity) {
                errorHolder.observe(activity) {
                    Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onActivityPaused(activity: Activity) {
            if (activity is FragmentActivity) {
                errorHolder.removeObservers(activity)
            }
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivityDestroyed(activity: Activity) {
        }
    }
}
