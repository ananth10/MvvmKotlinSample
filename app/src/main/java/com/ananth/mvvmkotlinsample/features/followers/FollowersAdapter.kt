package com.ananth.mvvmkotlinsample.features.followers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ananth.mvvmkotlinsample.binding.BindingAdapter
import com.ananth.mvvmkotlinsample.databinding.ItemLayoutFollowersBinding
import com.ananth.mvvmkotlinsample.model.remote.followers.FollowersModel

class FollowersAdapter:RecyclerView.Adapter<FollowersAdapter.FollowersItemViewHolder>(), BindingAdapter.RecyclerBindingContract<List<FollowersModel.FollowersModelItem>> {

   private var followersList=ArrayList<FollowersModel.FollowersModelItem>()

   inner class FollowersItemViewHolder(private val itemLayoutFollowersBinding: ItemLayoutFollowersBinding):RecyclerView.ViewHolder(itemLayoutFollowersBinding.root)
   {
       fun bindItem(followersModelItem:FollowersModel.FollowersModelItem){
           with(itemLayoutFollowersBinding){
               dataModel=followersModelItem
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersItemViewHolder {
        return FollowersItemViewHolder(ItemLayoutFollowersBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
       return followersList.size
    }

    override fun onBindViewHolder(holder: FollowersItemViewHolder, position: Int) {
       val followersModelItem=followersList[position]
       holder.bindItem(followersModelItem)
    }

    override fun setData(data: List<FollowersModel.FollowersModelItem>) {
        followersList=data as ArrayList<FollowersModel.FollowersModelItem>
        notifyDataSetChanged()
    }


}