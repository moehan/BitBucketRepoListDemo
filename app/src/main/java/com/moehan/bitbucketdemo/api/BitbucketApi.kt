package com.moehan.bitbucketdemo.api

import com.moehan.bitbucketdemo.Endpoints
import com.moehan.bitbucketdemo.model.BitbucketRepoListResponse
import retrofit2.http.GET

interface BitbucketApi {
    @GET(Endpoints.getAllRepositories)
    suspend fun getAllRepositories() = BitbucketRepoListResponse()
}