package com.moehan.cartracksampleapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application)  {
    @Provides
    @Singleton
    fun app() = application
}