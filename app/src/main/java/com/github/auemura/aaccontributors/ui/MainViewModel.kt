package com.github.auemura.aaccontributors.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.auemura.aaccontributors.repository.SampleRepository

class MainViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val sampleRepository: SampleRepository
) : ViewModel() {

    fun hello(): String = sampleRepository.greeting()
}
