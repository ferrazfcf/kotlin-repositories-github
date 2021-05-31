package com.ferraz.felipe.data.mapper

interface BaseMapperRepository<E, D> {

    fun transform(type: E): D
}
