package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.followings.FollowingsModel
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class FollowingsRepository(private val githubApiService: GithubApiService,private val userManager: UserManager) {

    fun getUserFollowings():Flow<State<List<FollowingsModel.FollowingsModelItem>>>{

        return object : NetworkBoundResource<List<FollowingsModel.FollowingsModelItem>>(){
            override suspend fun fetchFromNetwork(): Response<List<FollowingsModel.FollowingsModelItem>> = githubApiService.getGithubUserFollowings(userManager.getUserName())

        }.asFlow().flowOn(Dispatchers.IO)
    }

}