package com.github.auemura.aaccontributors.repository

import com.github.auemura.aaccontributors.client.github.GitHubApiService
import com.github.auemura.aaccontributors.client.github.model.ContributorResponse
import com.github.auemura.aaccontributors.domain.github.ContributorEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor(
    private val gitHubApiService: GitHubApiService
) {
    fun getContributors(groupName: String, repoName: String): Flow<List<ContributorEntity>> = flow {
        //val result = gitHubApiService.getContributors(groupName = groupName, repoName = repoName)
        //emit(result.toEntity())
        val entity = listOf(
            ContributorEntity(1, "", "", 1),
            ContributorEntity(2, "", "", 1),
            ContributorEntity(3, "", "", 1),
            ContributorEntity(4, "", "", 1),
            ContributorEntity(5, "", "", 1),
            ContributorEntity(6, "", "", 1),
            ContributorEntity(7, "", "", 1),
            ContributorEntity(8, "", "", 1),
            ContributorEntity(9, "", "", 1),
            ContributorEntity(10, "", "", 1)
        )
        delay(1_000)
        emit(entity)
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
