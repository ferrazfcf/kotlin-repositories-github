package com.ferraz.felipe.domain.usecases

import com.ferraz.felipe.domain.repositories.GitRepoInfoRepository

class GetTopStarKotlinGitHubRepositoriesUseCase(private val gitRepoRepository: GitRepoInfoRepository) {
    operator fun invoke() = gitRepoRepository.getTopStarKotlinGitHubRepositories()
}
