package com.moehan.bitbucketdemo.ui.repo_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.moehan.bitbucketdemo.R
import com.moehan.bitbucketdemo.databinding.ListItemRepoBinding
import com.moehan.bitbucketdemo.extensions.toAnotherDateFormat
import com.moehan.bitbucketdemo.model.RepoItem

class RepoListAdapter(val adapterListener: RepoListAdapterListener) :
    ListAdapter<RepoItem, RepoListAdapter.ViewHolder>(
        RepoDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_repo, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ListItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RepoItem) {
            with(binding) {
                repo = item.copy(
                    createdOn = item.createdOn?.toAnotherDateFormat(
                        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZZZZ",
                        "dd MMM yyyy, HH:mm"
                    )
                )
                executePendingBindings()

                item.owner?.links?.avatar?.let {
                    Glide
                        .with(binding.root.context)
                        .load(it)
                        .centerCrop()
                        .placeholder(R.drawable.ic_person)
                        .into(ivAvatar)
                }

                setClickListener {
                    adapterListener.onRepositorySelected(item)
                }
            }
        }
    }

    interface RepoListAdapterListener {
        fun onRepositorySelected(repo: RepoItem)
    }
}

//This is not needed now. Intended for future pagination list.
private class RepoDiffCallback : DiffUtil.ItemCallback<RepoItem>() {

    override fun areItemsTheSame(
        oldItem: RepoItem,
        newItem: RepoItem
    ): Boolean {
        return oldItem.uuid == newItem.uuid
    }

    override fun areContentsTheSame(
        oldItem: RepoItem,
        newItem: RepoItem
    ): Boolean {
        return oldItem.uuid == newItem.uuid
    }
}