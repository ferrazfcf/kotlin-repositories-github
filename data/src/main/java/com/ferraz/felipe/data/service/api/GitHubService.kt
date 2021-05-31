package com.ferraz.felipe.data.service.api

import com.ferraz.felipe.data.service.response.GitHubRepositoriesResponse
import com.ferraz.felipe.domain.entities.GitHubRepositories
import retrofit2.http.GET

interface GitHubService {

    @GET("search/repositories?q=language:kotlin&sort=stars&page=1")
    suspend fun getGitHubRepositories() : GitHubRepositoriesResponse
}