package com.ananth.mvvmkotlinsample.data.remote


import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.Response


abstract class NetworkBoundResource<T> {

    fun asFlow()=flow<State<T>>{

       emit(State.Loading())
        try {
         val apiResponse=fetchFromNetwork()
         val responseBody=apiResponse.body()
         if(apiResponse.isSuccessful && responseBody!=null){
             emit(State.Success(responseBody))
         }else{
             val jsonObj = JSONObject(apiResponse.errorBody()!!.charStream().readText())
             emit(State.error(jsonObj.getString("message")))
         }
        }catch (e: Exception){
            emit(State.error("Something went wrong!! Try again  later.."))
        }
    }

    protected abstract suspend fun fetchFromNetwork():Response<T>
}