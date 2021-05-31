package com.ferraz.felipe.data.mapper

import com.ferraz.felipe.data.service.response.GitHubRepositoriesResponse
import com.ferraz.felipe.data.service.response.GitRepositoryInfoResponse
import com.ferraz.felipe.domain.entities.GitHubRepositories
import com.ferraz.felipe.domain.entities.GitRepositoryInfo

object GitHubRepositoriesMapper : BaseMapperRepository<GitHubRepositoriesResponse, GitHubRepositories> {

    override fun transform(type: GitHubRepositoriesResponse): GitHubRepositories {
        return GitHubRepositories (
            type.totalCount,
            transformRepositoryItem(type.items)
        )
    }

    private fun transformRepositoryItem(items: List<GitRepositoryInfoResponse>): List<GitRepositoryInfo> =
        items.map {
            GitRepositoryInfoMapper.transform(it)
        }
}
