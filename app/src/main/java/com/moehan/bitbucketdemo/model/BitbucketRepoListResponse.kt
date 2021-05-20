package com.moehan.bitbucketdemo.model


import com.google.gson.annotations.SerializedName

data class BitbucketRepoListResponse(
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("pagelen")
    val pageLength: Int? = null,
    @SerializedName("values")
    val repoItems: List<RepoItem>? = null
)