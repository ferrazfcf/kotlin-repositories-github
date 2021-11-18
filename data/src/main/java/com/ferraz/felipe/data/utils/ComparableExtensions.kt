package com.ferraz.felipe.data.utils

infix fun <T : Comparable<T>> T?.greaterThan(other: T): Boolean =
    safeLet(this, other) { v1, v2 -> v1 > v2 } ?: false