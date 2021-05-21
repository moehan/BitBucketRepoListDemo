package com.moehan.bitbucketdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainBranch(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null
): Parcelable