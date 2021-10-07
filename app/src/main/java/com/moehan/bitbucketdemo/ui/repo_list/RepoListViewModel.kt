package com.moehan.bitbucketdemo.ui.repo_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.moehan.bitbucketdemo.model.BitbucketRepoListResponse
import com.moehan.bitbucketdemo.repository.BitbucketRepository
import com.moehan.bitbucketdemo.utils.Outcome
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoListViewModel @Inject constructor(val app: Application, val repository: BitbucketRepository) : AndroidViewModel(app) {

    val repoListOutcome = MutableLiveData<Outcome<BitbucketRepoListResponse>>()

    fun getRepositoryList() {
        repoListOutcome.value = Outcome.loading(true)
        viewModelScope.launch {
            try{
                val response = repository.getRepoList()
                repoListOutcome.value = Outcome.loading(false)
                repoListOutcome.value = Outcome.success(response)
            }catch (exception: Exception){
                repoListOutcome.value = Outcome.loading(false)
                repoListOutcome.value = Outcome.failure(exception)
            }
        }
    }
}