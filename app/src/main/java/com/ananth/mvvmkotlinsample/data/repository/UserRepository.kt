package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.repository.RepositoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class UserRepository (private val githubApiService: GithubApiService){

    fun getUserRepository(): Flow<State<RepositoryModel>> {
        return object:NetworkBoundResource<RepositoryModel>(){
            override suspend fun fetchFromNetwork(): Response<RepositoryModel> = githubApiService.getGithubUserRepos("")

        }.asFlow().flowOn(Dispatchers.IO)
    }
}