package com.moehan.bitbucketdemo.ui.repo_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.moehan.bitbucketdemo.BitbucketDemoApplication
import com.moehan.bitbucketdemo.databinding.FragmentRepoListBinding
import com.moehan.bitbucketdemo.extensions.goToWebLink
import com.moehan.bitbucketdemo.extensions.obtainViewModel
import com.moehan.bitbucketdemo.extensions.remove
import com.moehan.bitbucketdemo.model.BitbucketRepoListResponse
import com.moehan.bitbucketdemo.model.RepoItem
import com.moehan.bitbucketdemo.ui.BaseFragment
import com.moehan.bitbucketdemo.utils.Outcome
import javax.inject.Inject


class RepoListFragment : BaseFragment() {

    private val repoListViewModel: RepoListViewModel by injectedVMs()

    private var binding: FragmentRepoListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        initializeViewModel()
    }

    private fun injectDependencies() {
        BitbucketDemoApplication[activity as Context].appComponent().inject(this)
    }

    private fun initializeViewModel() {
        repoListViewModel.repoListOutcome.observe(this, Observer { outcome ->
            when (outcome) {
                is Outcome.Progress -> binding?.isLoading = outcome.loading
                is Outcome.Failure -> binding?.fetchReposFailed = true
                is Outcome.Success -> {
                    binding?.fetchReposFailed = false
                    processResponse(outcome.data)
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepoListBinding.inflate(inflater, container, false)
        binding?.isLoading = false
        binding?.fetchReposFailed = false
        repoListViewModel.getRepositoryList()
        return binding?.root
    }

    private fun processResponse(response: BitbucketRepoListResponse) {

        if (response.repoItems?.isEmpty() == false) {
            binding?.repoListEmpty = false
            showRepoList(response.repoItems)
        }else{
            binding?.repoListEmpty = true
        }

        response.next?.let {link ->
            binding?.btnNext?.setOnClickListener { requireActivity().goToWebLink(link) }
        } ?: binding?.btnNext?.remove()
    }

    private fun showRepoList(repoItems: List<RepoItem>?) {
        val adapter = RepoListAdapter(object : RepoListAdapter.RepoListAdapterListener {
            override fun onRepositorySelected(repo: RepoItem) {
                val action = RepoListFragmentDirections.actionRepoListFragmentToRepoDetailFragment(repo)
                binding?.root?.findNavController()?.navigate(action)
            }
        })
        adapter.submitList(repoItems)
        binding?.rvRepoList?.adapter = adapter
    }


}