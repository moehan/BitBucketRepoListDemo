package com.moehan.bitbucketdemo.ui.repo_list

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.moehan.bitbucketdemo.BitbucketDemoApplication
import com.moehan.bitbucketdemo.databinding.FragmentRepoListBinding
import com.moehan.bitbucketdemo.extensions.obtainViewModel
import com.moehan.bitbucketdemo.extensions.remove
import com.moehan.bitbucketdemo.model.BitbucketRepoListResponse
import com.moehan.bitbucketdemo.model.RepoItem
import com.moehan.bitbucketdemo.utils.Outcome
import javax.inject.Inject


class RepoListFragment : Fragment() {

    @Inject
    lateinit var repoListViewModelFactory: RepoListViewModelFactory
    private var repoListViewModel: RepoListViewModel? = null

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
        repoListViewModel = obtainViewModel(RepoListViewModel::class.java, repoListViewModelFactory)
        repoListViewModel?.repoListOutcome?.observe(this, Observer { outcome ->
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
        repoListViewModel?.getRepositoryList()
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
            binding?.btnNext?.setOnClickListener {  goToLink(link) }
        } ?: binding?.btnNext?.remove()
    }

    private fun showRepoList(repoItems: List<RepoItem>?) {
        val adapter = RepoListAdapter(object : RepoListAdapter.RepoListAdapterListener {
            override fun onRepositorySelected(repo: RepoItem) {
                // TODO("Not yet implemented")
            }
        })
        adapter.submitList(repoItems)
        binding?.rvRepoList?.adapter = adapter
    }

    private fun goToLink(link: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(link)
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }


}