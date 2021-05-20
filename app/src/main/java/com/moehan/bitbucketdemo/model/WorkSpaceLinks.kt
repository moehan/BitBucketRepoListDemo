package com.moehan.bitbucketdemo.model


import com.google.gson.annotations.SerializedName

data class WorkSpaceLinks(
    @SerializedName("avatar")
    val avatar: Link? = null,
    @SerializedName("html")
    val html: Link? = null,
    @SerializedName("self")
    val self: Link? = null
)