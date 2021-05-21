package com.moehan.bitbucketdemo

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.moehan.bitbucketdemo.extensions.toAnotherDateFormat

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import kotlin.math.exp

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.moehan.bitbucketdemo", appContext.packageName)
    }
}