package com.ferraz.felipe.domain.entities

data class GitHubRepositories(
    val totalCount: Int,
    val items: List<GitRepositoryInfo>
)
