package com.ananth.mvvmkotlinsample.features.followers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ananth.mvvmkotlinsample.binding.BindingAdapter
import com.ananth.mvvmkotlinsample.databinding.ItemLayoutFollowersBinding
import com.ananth.mvvmkotlinsample.model.local.FollowersEntity

class FollowersAdapter:RecyclerView.Adapter<FollowersAdapter.FollowersItemViewHolder>(), BindingAdapter.RecyclerBindingContract<List<FollowersEntity>> {

   private var followersList=ArrayList<FollowersEntity>()

   inner class FollowersItemViewHolder(private val itemLayoutFollowersBinding: ItemLayoutFollowersBinding):RecyclerView.ViewHolder(itemLayoutFollowersBinding.root)
   {
       fun bindItem(followersModelItem:FollowersEntity){
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

    override fun setData(data: List<FollowersEntity>) {
        followersList=data as ArrayList<FollowersEntity>
        notifyDataSetChanged()
    }


}