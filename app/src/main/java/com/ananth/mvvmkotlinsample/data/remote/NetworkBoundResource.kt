package com.ananth.mvvmkotlinsample.data.remote


import kotlinx.coroutines.flow.*
import org.json.JSONObject
import retrofit2.Response


abstract class NetworkBoundResource<ResultType> {

    fun asFlow()=flow<State<ResultType>>{

       emit(State.loading())
        try {
         emit(State.success(fetchFromDatabase().first()))
         val apiResponse=fetchFromNetwork()
         val responseBody=apiResponse.body()
         if(apiResponse.isSuccessful && responseBody!=null){
             saveRemoteDataToDatabase(responseBody)
         }else{
             val jsonObj = JSONObject(apiResponse.errorBody()!!.charStream().readText())
             emit(State.error(jsonObj.getString("message")))
         }
        }catch (e: Exception){
            emit(State.error("Something went wrong!! Try again  later.."))
        }

       /*Retrieve data from database and emit it*/
        emitAll(fetchFromDatabase().map {
            State.success(it)
        })
    }

    protected abstract suspend fun fetchFromNetwork():Response<ResultType>

    protected abstract suspend fun fetchFromDatabase(): Flow<ResultType>

    protected abstract suspend fun saveRemoteDataToDatabase(response:ResultType)
}