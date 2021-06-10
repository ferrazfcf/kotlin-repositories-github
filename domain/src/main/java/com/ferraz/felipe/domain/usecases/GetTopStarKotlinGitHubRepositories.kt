package com.ferraz.felipe.domain.usecases

import com.ferraz.felipe.domain.entities.GitHubRepositories
import com.ferraz.felipe.domain.repositories.GitRepoInfoRepository
import com.ferraz.felipe.domain.utils.QueryConstants
import com.ferraz.felipe.domain.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

class GetTopStarKotlinGitHubRepositoriesUseCase(private val gitRepoRepository: GitRepoInfoRepository) {
    operator fun invoke(page: Int, size: Int): Flow<ResultWrapper<GitHubRepositories>> {
        val queryMap = HashMap<String, String>()
        queryMap["q"] = QueryConstants.LANGUAGE_KOTLIN
        queryMap["sort"] = QueryConstants.SORT_BY_STARS
        queryMap["page"] = "$page"
        queryMap["per_page"] = "$size"
        return gitRepoRepository.getGitHubRepositories(queryMap)
    }
}
