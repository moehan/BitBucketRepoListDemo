package com.moehan.bitbucketdemo

import android.app.Application
import android.content.Context
import com.moehan.bitbucketdemo.di.*

class BitbucketDemoApplication : Application(){

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .dataModule(DataModule())
            .build()
    }

    companion object {
        operator fun get(context: Context) : BitbucketDemoApplication = context.applicationContext as BitbucketDemoApplication
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    fun appComponent(): AppComponent = appComponent
}