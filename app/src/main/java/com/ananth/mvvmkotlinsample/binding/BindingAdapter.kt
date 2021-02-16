package com.ananth.mvvmkotlinsample.binding

import android.view.View
import android.widget.ImageView
import androidx.core.text.htmlEncode
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.BlurTransformation
import com.ananth.mvvmkotlinsample.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show:Boolean=false){
        view.visibility= if(show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadProfileImage(imageView: ImageView, imageUrl:String?){
        imageView.load(imageUrl) {
            placeholder(R.drawable.noimage)
            error(R.drawable.noimage)
        }
    }

    @JvmStatic
    @BindingAdapter("backgroundImageUrl")
    fun loadProfileBackgroundImage(imageView: ImageView, imageUrl:String?){
        imageView.load(imageUrl) {
            placeholder(R.drawable.noimage)
            error(R.drawable.noimage)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
                transformations(BlurTransformation(imageView.context,8f))
            }
        }
    }
}
