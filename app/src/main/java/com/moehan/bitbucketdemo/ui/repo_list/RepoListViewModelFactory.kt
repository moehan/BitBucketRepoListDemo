package com.moehan.bitbucketdemo.ui.repo_list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moehan.bitbucketdemo.repository.BitbucketRepository

class RepoListViewModelFactory (private val application: Application, private val repository: BitbucketRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepoListViewModel(application, repository) as T
    }
}
