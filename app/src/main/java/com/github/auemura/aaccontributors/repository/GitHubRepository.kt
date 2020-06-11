package com.github.auemura.aaccontributors.repository

import com.github.auemura.aaccontributors.client.github.GitHubApiService
import com.github.auemura.aaccontributors.client.github.model.ContributorResponse
import com.github.auemura.aaccontributors.domain.github.ContributorEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor(
    private val gitHubApiService: GitHubApiService
) {
    fun getContributors(groupName: String, repoName: String): Flow<List<ContributorEntity>> = flow {
        val result = gitHubApiService.getContributors(groupName = groupName, repoName = repoName)
        emit(result.toEntity())
    }
}

private fun ContributorResponse.toEntity(): List<ContributorEntity> {
    return map {
        ContributorEntity(
            id = it.id,
            login = it.login,
            avatarUrl = it.avatarUrl,
            contributions = it.contributions ?: 0
        )
    }
}
