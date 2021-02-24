package com.ananth.mvvmkotlinsample.features.gists


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ananth.mvvmkotlinsample.binding.BindingAdapter
import com.ananth.mvvmkotlinsample.databinding.ItemLayoutGistsBinding
import com.ananth.mvvmkotlinsample.model.local.GistsEntity

class GistsAdapter (): RecyclerView.Adapter<GistsAdapter.GistsItemViewHolder>(), BindingAdapter.RecyclerBindingContract<List<GistsEntity>> {

    private var gistsList=ArrayList<GistsEntity>()
    inner class GistsItemViewHolder(private var itemLayoutGistsBinding: ItemLayoutGistsBinding):RecyclerView.ViewHolder(itemLayoutGistsBinding.root){

        fun bindItem(gistsModelItem: GistsEntity){
            with(itemLayoutGistsBinding){
                dataModel=gistsModelItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistsItemViewHolder {
       return GistsItemViewHolder(ItemLayoutGistsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
       return gistsList.size
    }

    override fun onBindViewHolder(holder: GistsItemViewHolder, position: Int) {
       val gistsDataItem = gistsList[position]
       holder.bindItem(gistsDataItem)
    }

    override fun setData(data: List<GistsEntity>) {
       gistsList=data as ArrayList<GistsEntity>
       notifyDataSetChanged()
    }
}