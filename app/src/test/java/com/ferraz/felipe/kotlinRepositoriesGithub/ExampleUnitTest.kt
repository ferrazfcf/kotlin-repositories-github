package com.ferraz.felipe.kotlinRepositoriesGithub

import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val coroutineWithRetryRule = CoroutineWithRetryRule(3)

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isWrong() {
        assertEquals(4, 2 + 3)
    }
}