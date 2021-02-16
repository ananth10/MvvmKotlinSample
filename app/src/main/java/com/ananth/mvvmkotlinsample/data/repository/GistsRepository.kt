package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.gists.GistsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class GistsRepository(private val githubApiService: GithubApiService) {

    fun getUserGists():Flow<State<GistsModel>>{

        return object :NetworkBoundResource<GistsModel>(){
            override suspend fun fetchFromNetwork(): Response<GistsModel> =githubApiService.getGithubGists("")

        }.asFlow().flowOn(Dispatchers.IO)
    }
}