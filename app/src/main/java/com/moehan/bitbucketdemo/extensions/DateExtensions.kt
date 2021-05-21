package com.moehan.bitbucketdemo.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * to change String to Date
 */
fun String.toDate(format: String): Date? = try {
    SimpleDateFormat(format, Locale.US).parse(this)
} catch (e: Exception) {
    null
}

/**
 * to change Date to String
 */
fun Date.toDateString(format: String): String? = try {
    SimpleDateFormat(format, Locale.US).format(this)
} catch (e: Exception) {
    null
}

fun String.toAnotherDateFormat(oldFormat: String, newFormat: String): String? = try {
    this.toDate(oldFormat)?.toDateString(newFormat)
} catch (e: Exception) {
    null
}