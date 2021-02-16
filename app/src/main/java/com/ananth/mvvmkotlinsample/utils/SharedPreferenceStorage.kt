package com.ananth.mvvmkotlinsample.utils

import android.content.Context

class SharedPreferenceStorage(context: Context):Storage{

    private val sharedPreferences=context.getSharedPreferences("github_app",Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
       with(sharedPreferences.edit()){
           putString(key,value)
           apply()
       }
    }

    override fun getString(key: String): String {
      return sharedPreferences.getString(key,"")?:""
    }

}