package com.ferraz.felipe.data.mapper

import com.ferraz.felipe.data.service.response.GitRepositoryInfoResponse
import com.ferraz.felipe.domain.entities.GitRepositoryInfo

object GitRepositoryInfoMapper : BaseMapperRepository<GitRepositoryInfoResponse, GitRepositoryInfo> {

    override fun transform(type: GitRepositoryInfoResponse): GitRepositoryInfo {
        return GitRepositoryInfo(
            type.id,
            type.name
        )
    }
}
