package com.ferraz.felipe.data.mapper

import com.ferraz.felipe.data.service.response.ErrorResponse
import com.ferraz.felipe.domain.entities.ErrorDetails
import com.ferraz.felipe.domain.entities.ErrorInfo

object ErrorMapper : BaseMapperRepository<ErrorResponse, ErrorInfo> {

    override fun transform(type: ErrorResponse): ErrorInfo {
        val subErrorList = mutableListOf<ErrorDetails>()
        type.errors?.forEach {
            subErrorList.add(transformSubError(it))
        }
        return ErrorInfo(type.message, subErrorList)
    }

    private fun transformSubError(errorResponse: ErrorResponse): ErrorDetails =
        ErrorDetails(
            errorResponse.message,
            errorResponse.code!!,
            errorResponse.field!!,
            errorResponse.resource!!
        )
}
