package com.moehan.bitbucketdemo.di

import android.app.Application
import com.google.gson.Gson
import com.moehan.bitbucketdemo.api.BitbucketApi
import com.moehan.bitbucketdemo.repository.BitbucketRepository
import com.moehan.bitbucketdemo.ui.repo_list.RepoListViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideBitbucketRepository(application: Application, gson : Gson, api: BitbucketApi)  = BitbucketRepository(application, gson, api)

    @Singleton
    @Provides
    fun provideRepoListViewModelFactory(application: Application, repository: BitbucketRepository) = RepoListViewModelFactory(application, repository)

}