package com.moehan.bitbucketdemo.model


import com.google.gson.annotations.SerializedName

data class Clone(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("name")
    val name: String? = null
)