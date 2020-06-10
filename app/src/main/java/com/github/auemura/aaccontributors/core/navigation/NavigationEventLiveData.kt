package com.github.auemura.aaccontributors.core.navigation

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NavigationEventLiveData<T : NavigationEvent>(
    private val coroutineScope: CoroutineScope
) : MutableLiveData<T>() {

    private var busy: Boolean = false

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(
            owner,
            Observer { navigationEvent ->
                navigationEvent?.let {
                    if (busy) return@let
                    coroutineScope.launch(Dispatchers.Main) {
                        busy = true
                        observer.onChanged(navigationEvent)
                        value = null
                        delay(500)
                        busy = false
                    }
                }
            }
        )
    }
}

interface NavigationEvent

fun <T : NavigationEvent> CoroutineScope.navigationEventLiveData(): NavigationEventLiveData<T> {
    return NavigationEventLiveData(this)
}
