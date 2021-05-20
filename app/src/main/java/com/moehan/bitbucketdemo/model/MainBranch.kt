package com.moehan.bitbucketdemo.model


import com.google.gson.annotations.SerializedName

data class MainBranch(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null
)