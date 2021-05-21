package com.moehan.bitbucketdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Link(
    @SerializedName("href")
    val href: String? = null
) : Parcelable