package com.moehan.bitbucketdemo.ui.repo_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.moehan.bitbucketdemo.model.BitbucketRepoListResponse
import com.moehan.bitbucketdemo.repository.BitbucketRepository
import com.moehan.bitbucketdemo.utils.Outcome
import kotlinx.coroutines.launch

class RepoListViewModel(val app: Application, val repository: BitbucketRepository) : AndroidViewModel(app) {

    val repoListOutcome = MutableLiveData<Outcome<BitbucketRepoListResponse>>()

    fun getRepositoryList() {
        repoListOutcome.value = Outcome.loading(true)
        viewModelScope.launch {
            try{
                val response = repository.getRepoList()
                repoListOutcome.value = Outcome.success(response)
            }catch (exception: Exception){
                repoListOutcome.value = Outcome.failure(exception)
            }finally {
                repoListOutcome.value = Outcome.loading(false)
            }

        }
    }
}