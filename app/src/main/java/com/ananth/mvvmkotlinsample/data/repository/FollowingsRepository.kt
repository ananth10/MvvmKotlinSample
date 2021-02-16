package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.followings.FollowingsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class FollowingsRepository(private val githubApiService: GithubApiService) {

    fun getUserFollowings():Flow<State<FollowingsModel>>{

        return object : NetworkBoundResource<FollowingsModel>(){
            override suspend fun fetchFromNetwork(): Response<FollowingsModel> = githubApiService.getGithubUserFollowings("")

        }.asFlow().flowOn(Dispatchers.IO)
    }

}