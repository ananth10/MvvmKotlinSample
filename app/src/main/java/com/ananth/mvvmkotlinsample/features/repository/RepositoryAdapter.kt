package com.ananth.mvvmkotlinsample.features.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ananth.mvvmkotlinsample.binding.BindingAdapter
import com.ananth.mvvmkotlinsample.databinding.ItemLayoutReposBinding
import com.ananth.mvvmkotlinsample.model.remote.repository.RepositoryModel

class RepositoryAdapter ():RecyclerView.Adapter<RepositoryAdapter.RepositoryItemViewHolder>(), BindingAdapter.RecyclerBindingContract<List<RepositoryModel.RepositoryDataItem>>{

  private var repositoryList=ArrayList<RepositoryModel.RepositoryDataItem>()
 inner class RepositoryItemViewHolder(private var itemLayoutReposBinding:ItemLayoutReposBinding):RecyclerView.ViewHolder(itemLayoutReposBinding.root) {

     fun bindItem(repositoryDataItem:RepositoryModel.RepositoryDataItem){
         with(itemLayoutReposBinding){
           dataModel= repositoryDataItem
         }
     }
 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryItemViewHolder {
        return RepositoryItemViewHolder(ItemLayoutReposBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    override fun onBindViewHolder(holder: RepositoryItemViewHolder, position: Int) {
       val repositoryDataItem=repositoryList[position]
       holder.bindItem(repositoryDataItem)
    }

    override fun setData(data: List<RepositoryModel.RepositoryDataItem>) {
        repositoryList= data as ArrayList<RepositoryModel.RepositoryDataItem>
        notifyDataSetChanged()
    }

}