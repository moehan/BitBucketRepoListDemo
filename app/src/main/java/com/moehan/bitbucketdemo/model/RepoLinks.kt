package com.moehan.bitbucketdemo.model


import com.google.gson.annotations.SerializedName

data class RepoLinks(
        @SerializedName("avatar")
        val avatar: Link? = null,
        @SerializedName("branches")
        val branches: Link? = null,
        @SerializedName("clone")
        val clone: List<Clone>? = null,
        @SerializedName("commits")
        val commits: Link? = null,
        @SerializedName("downloads")
        val downloads: Link? = null,
        @SerializedName("forks")
        val forks: Link? = null,
        @SerializedName("hooks")
        val hooks: Link? = null,
        @SerializedName("html")
        val html: Link? = null,
        @SerializedName("issues")
        val issues: Link? = null,
        @SerializedName("pullrequests")
        val pullRequests: Link? = null,
        @SerializedName("self")
        val self: Link? = null,
        @SerializedName("source")
        val source: Link? = null,
        @SerializedName("tags")
        val tags: Link? = null,
        @SerializedName("watchers")
        val watchers: Link? = null
)