package com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ferraz.felipe.domain.entities.GitRepositoryInfo
import com.ferraz.felipe.kotlinRepositoriesGithub.databinding.RepositoryViewHolderBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    private val gitRepositoriesList = mutableListOf<GitRepositoryInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewHolder {
        return RepositoryViewHolder(getRepositoryViewHolderBinding(parent))
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bindView(gitRepositoriesList[position])
    }

    override fun getItemCount() = gitRepositoriesList.size

    private fun getRepositoryViewHolderBinding(parent: ViewGroup) =
        RepositoryViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

    fun addRepositoriesList(repositoriesList: List<GitRepositoryInfo>) {
        this.gitRepositoriesList.addAll(repositoriesList)
        notifyDataSetChanged()
    }

    inner class RepositoryViewHolder(
        private val binding: RepositoryViewHolderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(gitRepository: GitRepositoryInfo) {

        }
    }
}
