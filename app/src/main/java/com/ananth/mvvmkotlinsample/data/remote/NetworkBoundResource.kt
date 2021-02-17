package com.ananth.mvvmkotlinsample.data.remote


import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.Response


abstract class NetworkBoundResource<T> {

    fun asFlow()=flow<State<T>>{

       emit(State.Loading())
        try {
            println("TEST11")
         val apiResponse=fetchFromNetwork()
            println("TEST22")
         val responseBody=apiResponse.body()
            println("TEST33")
         if(apiResponse.isSuccessful && responseBody!=null){
             println("SUCCESS::$responseBody")
             emit(State.Success(responseBody))
         }else{
             println("UNSUCCESS::$responseBody")
             val jsonObj = JSONObject(apiResponse.errorBody()!!.charStream().readText())
             emit(State.error(jsonObj.getString("message")))
         }
        }catch (e: Exception){
            println("ERROR::${e.message}")
            emit(State.error("Something went wrong!! Try again  later.."))
        }
    }

    protected abstract suspend fun fetchFromNetwork():Response<T>
}