package com.ferraz.felipe.data.repositories

import com.ferraz.felipe.data.mapper.GitHubRepositoriesMapper
import com.ferraz.felipe.data.service.api.GitHubService
import com.ferraz.felipe.data.utils.ApiHelper
import com.ferraz.felipe.domain.repositories.GitRepoInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GitRepoInfoRepositoryImpl(
    private val service: GitHubService
) : GitRepoInfoRepository {

    override fun getGitHubRepositories(queryMap: HashMap<String, String>) = flow {
        emit(ApiHelper.responseHandler {
            GitHubRepositoriesMapper.transform(service.getGitHubRepositories(queryMap))
        })
    }.flowOn(Dispatchers.IO)
}
