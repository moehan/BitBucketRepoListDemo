package com.moehan.bitbucketdemo.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified VM: ViewModel> injectedActivityVMs(): Lazy<VM> {
        return activityViewModels {
            viewModelFactory
        }
    }

    inline fun <reified VM : ViewModel> injectedVMs(): Lazy<VM> {
        return viewModels {
            viewModelFactory
        }
    }
}