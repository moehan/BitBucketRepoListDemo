package com.moehan.bitbucketdemo.model


import com.google.gson.annotations.SerializedName

data class Owner(
        @SerializedName("account_id")
        val accountId: Any? = null,
        @SerializedName("display_name")
        val displayName: String? = null,
        @SerializedName("links")
        val links: OwnerLinks? = null,
        @SerializedName("nickname")
        val nickname: String? = null,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("username")
        val username: String? = null,
        @SerializedName("uuid")
        val uuid: String? = null
)