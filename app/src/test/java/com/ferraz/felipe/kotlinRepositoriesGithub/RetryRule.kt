package com.ferraz.felipe.kotlinRepositoriesGithub

import com.ferraz.felipe.data.utils.greaterThan
import org.junit.AssumptionViolatedException
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.MultipleFailureException
import org.junit.runners.model.Statement
import java.util.*
import org.junit.internal.AssumptionViolatedException as JUnitInternalAssumptionViolatedException

open class RetryRule constructor() : TestWatcher() {

    private var mRetryMax: Int = 1
    private var mTryCount: Int = 0

    private var mSuccess = false

    private val mErrors: MutableList<Throwable> = ArrayList()

    constructor(retryMax: Int = 0) : this() {
        if(retryMax greaterThan MIN_TRIES) {
            mRetryMax = retryMax
        }
    }

    private fun statement(base: Statement, description: Description?) = object : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            mErrors.clear()

            mStartingQuietly(description)
            mEvaluate(base, description)
            mFinishedQuietly(description)

            assertThrowableList()
        }
    }

    private fun assertThrowableList() {
        mErrors.onEach {
            it.printStackTrace()
        }.takeIf { mSuccess }?.clear()
        MultipleFailureException.assertEmpty(mErrors)
    }

    private fun mEvaluate(base: Statement, description: Description?) {
        if(++mTryCount greaterThan mRetryMax) {
            RuntimeException("${description?.displayName}: Giving up after $mRetryMax failures.").printStackTrace()
            return
        }
        kotlin.runCatching {
            base.evaluate()
            mSucceededQuietly(description)
            println(mTryCount)
            if (mTryCount == 1) throw Throwable("TEST")
        }.getOrElse { error ->
            mErrorQuietly(error, description)
            mEvaluate(base, description)
        }
    }

    private fun mErrorQuietly(error: Throwable, description: Description?) {
        mErrors.add(error)
        kotlin.runCatching {
            handleError(error, description)
        }.getOrElse { e ->
            mErrors.add(e)
        }
    }

    private fun handleError(error: Throwable, description: Description?) {
        when (error) {
            is AssumptionViolatedException ->
                skipped(error, description)
            is JUnitInternalAssumptionViolatedException ->
                skipped(error as AssumptionViolatedException, description)
            else ->
                failed(error, description)
        }
    }

    private fun mStartingQuietly(description: Description?) {
        kotlin.runCatching {
            starting(description)
        }.getOrElse { e ->
            mErrors.add(e)
        }
    }

    private fun mSucceededQuietly(description: Description?) {
        kotlin.runCatching {
            succeeded(description)
            mSuccess = true
        }.getOrElse { e ->
            mErrors.add(e)
        }
    }

    private fun mFinishedQuietly(description: Description?) {
        kotlin.runCatching {
            finished(description)
        }.getOrElse { e ->
            mErrors.add(e)
        }
    }

    override fun apply(base: Statement, description: Description?): Statement {
        return statement(base, description)
    }

    companion object {
        private const val MIN_TRIES = 1
    }
}