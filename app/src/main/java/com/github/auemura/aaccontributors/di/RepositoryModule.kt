package com.github.auemura.aaccontributors.di

import com.github.auemura.aaccontributors.client.github.GitHubApiService
import com.github.auemura.aaccontributors.repository.GitHubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGitHubRepository(gitHubApiService: GitHubApiService): GitHubRepository = GitHubRepository(gitHubApiService)
}
