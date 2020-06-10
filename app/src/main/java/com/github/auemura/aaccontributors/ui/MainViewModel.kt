package com.github.auemura.aaccontributors.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.github.auemura.aaccontributors.coroutine.DispatcherProvider
import com.github.auemura.aaccontributors.repository.SampleRepository

class MainViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    dispatcherProvider: DispatcherProvider,
    private val sampleRepository: SampleRepository
) : ViewModel() {

    val greeting: LiveData<String> = liveData(viewModelScope.coroutineContext) {
        emitSource(sampleRepository.greeting().asLiveData(dispatcherProvider.mainContext))
    }
}
