package com.ferraz.felipe.data.repositories

import com.ferraz.felipe.data.mapper.GitHubRepositoriesMapper
import com.ferraz.felipe.data.service.api.GitHubService
import com.ferraz.felipe.data.utils.ApiCallHelper
import com.ferraz.felipe.domain.repositories.GitRepoInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GitRepoInfoRepositoryImpl(
    private val service: GitHubService
) : GitRepoInfoRepository {

    override fun getTopStarKotlinGitHubRepositories() = flow {
        emit(ApiCallHelper.safeApiCall {
            GitHubRepositoriesMapper.transform(service.getGitHubRepositories())
        })
    }.flowOn(Dispatchers.IO)
}
