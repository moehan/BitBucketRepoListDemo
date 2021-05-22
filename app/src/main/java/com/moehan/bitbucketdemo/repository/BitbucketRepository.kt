package com.moehan.bitbucketdemo.repository

import android.app.Application
import com.google.gson.Gson
import com.moehan.bitbucketdemo.AppConfigurations.useMockDataForTesting
import com.moehan.bitbucketdemo.BuildConfig
import com.moehan.bitbucketdemo.api.BitbucketApi
import com.moehan.bitbucketdemo.extensions.loadJSONFromAsset
import com.moehan.bitbucketdemo.model.BitbucketRepoListResponse

class BitbucketRepository(
    private val application: Application,
    private val gson: Gson,
    private val api: BitbucketApi
) {

    suspend fun getRepoList(): BitbucketRepoListResponse =
        when (BuildConfig.DEBUG && useMockDataForTesting) {
            true -> {
                val mockResponseJson = application.loadJSONFromAsset("mock_bitbucket_repo_list.json")
                val mockResponse = gson.fromJson(mockResponseJson, BitbucketRepoListResponse::class.java)
                mockResponse
            }
            false -> api.getAllRepositories()
        }
}