package com.ferraz.felipe.kotlinRepositoriesGithub;

import org.junit.Assert
import org.junit.Test

class Test(var field: Int)

class TestTest {
    @Test
    fun test() {
        val v1 = Test(5)
        val v2 = v1
        val v3 = Test(v2.field)
        v1.field = 10
        println("${v1.field} ${v2.field} ${v3.field}")
    }
}

