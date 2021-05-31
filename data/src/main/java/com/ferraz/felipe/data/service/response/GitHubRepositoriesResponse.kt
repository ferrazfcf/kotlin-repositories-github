package com.ferraz.felipe.data.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubRepositoriesResponse(
    @Json(name = "total_count") val totalCount: Int,
    @Json(name = "items") val items: List<GitRepositoryInfoResponse>
)
