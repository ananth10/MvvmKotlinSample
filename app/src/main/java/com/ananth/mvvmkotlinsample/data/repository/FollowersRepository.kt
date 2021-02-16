package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.followers.FollowersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class FollowersRepository(private val githubApiService: GithubApiService) {

    fun getUserFollowers(): Flow<State<FollowersModel>> {

        return object :NetworkBoundResource<FollowersModel>(){
            override suspend fun fetchFromNetwork(): Response<FollowersModel> =githubApiService.getGithubUserFollowers("")
        }.asFlow().flowOn(Dispatchers.IO)
    }
}