package com.moehan.bitbucketdemo

import androidx.test.platform.app.InstrumentationRegistry
import com.moehan.bitbucketdemo.extensions.loadJSONFromAsset
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

internal fun MockWebServer.enqueueResponse(fileName: String, code: Int) {
    val appContext= InstrumentationRegistry.getInstrumentation().targetContext
    val responseJson = appContext.loadJSONFromAsset(fileName)
    responseJson?.let {
        enqueue(
            MockResponse()
                .setResponseCode(code)
                .setBody(responseJson)
        )
    }
}