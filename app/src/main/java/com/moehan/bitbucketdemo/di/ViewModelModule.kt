package com.moehan.bitbucketdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moehan.bitbucketdemo.ui.repo_list.RepoListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel::class)
    abstract fun bindRepoListViewModel(viewModel: RepoListViewModel): ViewModel
}

@Module
internal abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(genericViewModelFactory: GenericViewModelFactory): ViewModelProvider.Factory
}

@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)