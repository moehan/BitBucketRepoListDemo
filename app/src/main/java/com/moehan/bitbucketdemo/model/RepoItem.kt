package com.moehan.bitbucketdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepoItem(
        @SerializedName("created_on")
        val createdOn: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("fork_policy")
        val forkPolicy: String? = null,
        @SerializedName("full_name")
        val fullName: String? = null,
        @SerializedName("has_issues")
        val hasIssues: Boolean? = null,
        @SerializedName("has_wiki")
        val hasWiki: Boolean? = null,
        @SerializedName("is_private")
        val isPrivate: Boolean? = null,
        @SerializedName("language")
        val language: String? = null,
        @SerializedName("links")
        val repoLinks: RepoLinks? = null,
        @SerializedName("mainbranch")
        val mainBranch: MainBranch? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("owner")
        val owner: Owner? = null,
        @SerializedName("project")
        val project: Project? = null,
        @SerializedName("scm")
        val scm: String? = null,
        @SerializedName("size")
        val size: Int? = null,
        @SerializedName("slug")
        val slug: String? = null,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("updated_on")
        val updatedOn: String? = null,
        @SerializedName("uuid")
        val uuid: String? = null,
        @SerializedName("website")
        val website: String? = null,
        @SerializedName("workspace")
        val workspace: Workspace? = null
) : Parcelable