package com.ananth.mvvmkotlinsample.utils

interface Storage {

    fun setString(key:String,value:String)
    fun getString(key: String):String
}