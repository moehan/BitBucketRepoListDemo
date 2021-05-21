package com.moehan.bitbucketdemo.di

import android.app.Application
import com.moehan.bitbucketdemo.ui.repo_list.RepoListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class,DataModule::class])
interface AppComponent {

    fun inject(application: Application)
    fun inject(repoListFragment: RepoListFragment)
}