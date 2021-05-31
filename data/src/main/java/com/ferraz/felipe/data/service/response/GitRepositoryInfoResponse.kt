package com.ferraz.felipe.data.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitRepositoryInfoResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String
)
