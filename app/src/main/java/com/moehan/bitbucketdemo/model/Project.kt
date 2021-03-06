package com.moehan.bitbucketdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Project(
        @SerializedName("key")
    val key: String? = null,
        @SerializedName("links")
    val links: ProjectLinks? = null,
        @SerializedName("name")
    val name: String? = null,
        @SerializedName("type")
    val type: String? = null,
        @SerializedName("uuid")
    val uuid: String? = null
) : Parcelable