package com.ferraz.felipe.data.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    @Json(name = "message") val message: String,
    @Json(name = "errors") val errors: List<ErrorResponse>? = null,
    @Json(name = "resource") val resource: String? = null,
    @Json(name = "field") val field: String? = null,
    @Json(name = "code") val code: String? = null
)
