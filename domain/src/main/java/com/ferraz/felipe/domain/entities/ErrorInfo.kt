package com.ferraz.felipe.domain.entities

data class ErrorInfo(
    val message: String,
    val errors: List<ErrorDetails>
)

data class ErrorDetails (
    val message: String,
    val resource: String,
    val field: String,
    val code: String
)
