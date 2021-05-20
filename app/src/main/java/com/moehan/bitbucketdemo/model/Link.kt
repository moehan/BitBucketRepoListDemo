package com.moehan.bitbucketdemo.model


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href")
    val href: String? = null
)