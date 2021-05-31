package com.ferraz.felipe.domain.utils

import com.ferraz.felipe.domain.entities.ErrorInfo

sealed class ResultWrapper<out ResponseType> {
    data class Success<out ResponseType> (val value: ResponseType) : ResultWrapper<ResponseType>()
    data class Error(val code: Int? = null, val error: ErrorInfo? = null) : ResultWrapper<Nothing>()
    object NetworkError : ResultWrapper<Nothing>()
}
