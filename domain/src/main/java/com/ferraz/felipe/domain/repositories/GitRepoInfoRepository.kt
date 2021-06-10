package com.ferraz.felipe.domain.repositories

import com.ferraz.felipe.domain.entities.GitHubRepositories
import com.ferraz.felipe.domain.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface GitRepoInfoRepository {

    fun getGitHubRepositories(queryMap: HashMap<String, String>) : Flow<ResultWrapper<GitHubRepositories>>
}
