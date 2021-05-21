package com.moehan.bitbucketdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectLinks(
    @SerializedName("avatar")
    val avatar: Link? = null,
    @SerializedName("html")
    val html: Link? = null,
    @SerializedName("self")
    val self: Link? = null
): Parcelable