package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.profile.ProfileModel
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class ProfileRepository(private val userManager:UserManager,private val githubApiService: GithubApiService) {


    fun getUserProfile():Flow<State<ProfileModel>>{
        return object:NetworkBoundResource<ProfileModel>(){
            override suspend fun fetchFromNetwork(): Response<ProfileModel> = githubApiService.getGithubUserInfo(userManager.getUserName())

        }.asFlow().flowOn(Dispatchers.IO)
    }
}