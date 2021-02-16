package com.ananth.mvvmkotlinsample.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun isNetworkAvailable(context:Context):Boolean?{
    var isConnected:Boolean?=false
    var connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork:NetworkInfo?=connectivityManager.activeNetworkInfo
    if (activeNetwork!=null && activeNetwork.isConnected)
        isConnected=true
    return isConnected
}