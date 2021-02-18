package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.followers.FollowersModel
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class FollowersRepository(private val githubApiService: GithubApiService, private val userManager: UserManager) {

    fun getUserFollowers(): Flow<State<List<FollowersModel.FollowersModelItem>>> {

        return object : NetworkBoundResource<List<FollowersModel.FollowersModelItem>>() {
            override suspend fun fetchFromNetwork(): Response<List<FollowersModel.FollowersModelItem>> =
                githubApiService.getGithubUserFollowers(userManager.getUserName())
        }.asFlow().flowOn(Dispatchers.IO)
    }
}