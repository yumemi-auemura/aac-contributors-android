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
import com.github.auemura.aaccontributors.core.status.Status
import com.github.auemura.aaccontributors.domain.github.ContributorEntity
import com.github.auemura.aaccontributors.repository.GitHubRepository

class MainViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    dispatcherProvider: DispatcherProvider,
    private val gitHubRepository: GitHubRepository
) : ViewModel() {

    private val _navigation = viewModelScope.navigationEventLiveData<Nav>()
    val navigation: LiveData<Nav>
        get() = _navigation

    val contributors: LiveData<Status<List<ContributorEntity>>> = liveData(viewModelScope.coroutineContext) {
        emitSource(
            gitHubRepository
                .getContributors("googlesamples", "android-architecture-components")
                .asLiveData(dispatcherProvider.mainContext)
        )
    }

    fun onSingleClicked(contributor: ContributorEntity) {
        _navigation.value = Nav.OpenSingle(contributor)
    }

    sealed class Nav : NavigationEvent {
        data class OpenSingle(val contributor: ContributorEntity) : Nav()
    }
}
