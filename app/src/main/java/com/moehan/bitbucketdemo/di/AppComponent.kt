package com.moehan.cartracksampleapp.di

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class,DataModule::class])
interface AppComponent {

    fun inject(application: Application)
}