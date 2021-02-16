package com.ananth.mvvmkotlinsample.utils

import org.koin.core.KoinComponent

class UserManager(private val storage: Storage):KoinComponent {

    fun setUserName(userName:String){
        storage.setString("userName",userName)
    }

    fun getUserName():String{
       return storage.getString("userName")
    }
}