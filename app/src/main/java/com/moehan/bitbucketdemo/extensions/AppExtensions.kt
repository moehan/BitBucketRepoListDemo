package com.moehan.bitbucketdemo.extensions

import android.app.Application
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/** Load Json File Stored in assets folder */
fun Context.loadJSONFromAsset(fileName: String): String? = assets.open(fileName).bufferedReader().use { it.readText() }

/**
 * Get view model for Fragment
 */
fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>, viewModelFactory: ViewModelProvider.NewInstanceFactory) =
    ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)

/**
 * Shortened view visibility function
 */
fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.remove() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

