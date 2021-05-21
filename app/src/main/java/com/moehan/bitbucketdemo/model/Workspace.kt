package com.moehan.bitbucketdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Workspace(
        @SerializedName("links")
        val links: WorkSpaceLinks? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("slug")
        val slug: String? = null,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("uuid")
        val uuid: String? = null
) : Parcelable