package com.moehan.bitbucketdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Clone(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("name")
    val name: String? = null
): Parcelable