package com.ferraz.felipe.data.utils

import com.ferraz.felipe.data.mapper.ErrorMapper
import com.ferraz.felipe.data.service.response.ErrorResponse
import com.ferraz.felipe.domain.entities.ErrorInfo
import com.ferraz.felipe.domain.utils.ResultWrapper
import com.squareup.moshi.Moshi
import okio.IOException
import retrofit2.HttpException

object ApiHelper {
    suspend fun <ResponseType> responseHandler(apiCall: suspend () -> ResponseType) : ResultWrapper<ResponseType> =
        kotlin.runCatching {
            ResultWrapper.Success(apiCall())
        }.getOrElse { throwable ->
            responseErrorHandler(throwable)
        }

    private fun responseErrorHandler(throwable: Throwable) = when (throwable) {
        is IOException -> ResultWrapper.NetworkError
        is HttpException -> httpErrorHandler(throwable)
        else -> ResultWrapper.Error()
    }

    private fun httpErrorHandler(throwable: HttpException) = ResultWrapper.Error(
        throwable.code(),
        convertErrorBody(throwable)
    )

    private fun convertErrorBody(httpException: HttpException): ErrorInfo? =
        kotlin.runCatching {
            httpException.response()?.errorBody()?.source()?.let {
                val errorResponse = Moshi.Builder()
                    .build()
                    .adapter(ErrorResponse::class.java)
                    .fromJson(it)
                ErrorMapper.transform(errorResponse!!)
            }
        }.getOrNull()
}
