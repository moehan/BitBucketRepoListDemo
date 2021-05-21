package com.moehan.bitbucketdemo.extensions

import android.app.Application
import android.content.Context

/** Load Json File Stored in assets folder */
fun Context.loadJSONFromAsset(fileName: String): String? = assets.open(fileName).bufferedReader().use { it.readText() }

