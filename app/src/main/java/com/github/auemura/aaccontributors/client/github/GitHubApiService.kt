package com.github.auemura.aaccontributors.client.github

import com.github.auemura.aaccontributors.client.github.model.ContributorResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiService {

    @GET("repos/{groupName}/{repoName}/contributors")
    suspend fun getContributors(
        @Path("groupName") groupName: String,
        @Path("repoName") repoName: String
    ): ContributorResponse
}
