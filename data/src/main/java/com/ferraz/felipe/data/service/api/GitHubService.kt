package com.ferraz.felipe.data.service.api

import com.ferraz.felipe.data.service.response.GitHubRepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GitHubService {

    @GET("search/repositories")
    suspend fun getGitHubRepositories(
        @QueryMap queryMap: HashMap<String, String>
    ) : GitHubRepositoriesResponse
}
