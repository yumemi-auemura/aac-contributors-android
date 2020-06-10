package com.github.auemura.aaccontributors.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.github.auemura.aaccontributors.core.coroutine.DispatcherProvider
import com.github.auemura.aaccontributors.core.navigation.NavigationEvent
import com.github.auemura.aaccontributors.core.navigation.navigationEventLiveData
import com.github.auemura.aaccontributors.repository.SampleRepository

class MainViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    dispatcherProvider: DispatcherProvider,
    private val sampleRepository: SampleRepository
) : ViewModel() {

    private val _navigation = viewModelScope.navigationEventLiveData<Nav>()
    val navigation: LiveData<Nav>
        get() = _navigation

    val greeting: LiveData<String> = liveData(viewModelScope.coroutineContext) {
        emitSource(sampleRepository.greeting().asLiveData(dispatcherProvider.mainContext))
    }

    fun onSingleClicked() {
        _navigation.value = Nav.OpenSingle
    }

    sealed class Nav : NavigationEvent {
        object OpenSingle : Nav()
    }
}
