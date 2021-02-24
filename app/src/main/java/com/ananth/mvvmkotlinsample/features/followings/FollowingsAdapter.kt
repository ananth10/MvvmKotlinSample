package com.ananth.mvvmkotlinsample.features.followings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ananth.mvvmkotlinsample.binding.BindingAdapter
import com.ananth.mvvmkotlinsample.databinding.ItemLayoutFollowingsBinding
import com.ananth.mvvmkotlinsample.model.local.FollowingsEntity

class FollowingsAdapter:RecyclerView.Adapter<FollowingsAdapter.FollowingsItemViewHolder>(), BindingAdapter.RecyclerBindingContract<List<FollowingsEntity>> {

    private var followingsList=ArrayList<FollowingsEntity>()

    inner class FollowingsItemViewHolder(private val itemLayoutFollowingsBinding:ItemLayoutFollowingsBinding):RecyclerView.ViewHolder(itemLayoutFollowingsBinding.root){

        fun bindItem(followingsModelItem: FollowingsEntity){
             with(itemLayoutFollowingsBinding){
                 dataModel=followingsModelItem
             }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingsItemViewHolder {
        return FollowingsItemViewHolder(ItemLayoutFollowingsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
       return followingsList.size
    }

    override fun onBindViewHolder(holder: FollowingsItemViewHolder, position: Int) {
      val followingsModelItem=followingsList[position]
      holder.bindItem(followingsModelItem)
    }

    override fun setData(data: List<FollowingsEntity>) {
       followingsList=data as ArrayList<FollowingsEntity>
       notifyDataSetChanged()
    }
}