package com.github.auemura.aaccontributors.repository

import com.github.auemura.aaccontributors.client.github.GitHubApiService
import com.github.auemura.aaccontributors.client.github.model.ContributorResponse
import com.github.auemura.aaccontributors.core.status.Status
import com.github.auemura.aaccontributors.domain.github.ContributorEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor(
    private val gitHubApiService: GitHubApiService
) {

    fun getContributors(groupName: String, repoName: String): Flow<Status<List<ContributorEntity>>> = flow {
        emit(Status.Loading)
        try {
            gitHubApiService.getContributors(groupName = groupName, repoName = repoName).apply {
                emit(Status.Success(this.toEntity()))
            }
        } catch (e: Throwable) {
            emit(Status.Failure(e))
        }
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
