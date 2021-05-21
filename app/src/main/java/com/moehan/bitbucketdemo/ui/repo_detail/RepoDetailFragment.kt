package com.moehan.bitbucketdemo.ui.repo_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.moehan.bitbucketdemo.R
import com.moehan.bitbucketdemo.databinding.FragmentRepoDetailsBinding
import com.moehan.bitbucketdemo.extensions.goToWebLink
import com.moehan.bitbucketdemo.extensions.toAnotherDateFormat

class RepoDetailFragment : Fragment() {

    private val args: RepoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRepoDetailsBinding.inflate(inflater, container, false)
        populateData(binding)
        return binding.root
    }

    private fun populateData(binding : FragmentRepoDetailsBinding){
        binding.repo = args.repo.copy(
            createdOn = args.repo.createdOn?.toAnotherDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZZZZ", "dd MMM yyyy, HH:mm"),
            updatedOn = args.repo.updatedOn?.toAnotherDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZZZZ", "dd MMM yyyy, HH:mm")
        )

        args.repo.owner?.links?.avatar?.let {
            Glide
                .with(binding.root.context)
                .load(it)
                .centerCrop()
                .placeholder(R.drawable.ic_person)
                .into(binding.ivOwnerAvatar)
        }

        binding.linkClickedListener = object : OnLinkClickedListener {
            override fun onLinkClicked(link: String) {
                requireActivity().goToWebLink(link)
            }
        }
    }
}

interface OnLinkClickedListener{
    fun onLinkClicked(link: String)
}