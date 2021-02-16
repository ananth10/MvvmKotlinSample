package com.ananth.mvvmkotlinsample.data.remote

sealed class State<out T> {

    class Loading<out T>:State<T>()
    data class Success<out T>(val data:T):State<T>()
    data class Error<out T>(val errorMessage:String):State<T>()

    companion object{
       fun <T> loading()=Loading<T>()
       fun <T> success(data:T)=Success<T>(data)
       fun <T> error(errorMessage:String)=Error<T>(errorMessage)
    }
}