package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.repository.RepositoryModel
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class UserRepository (private val githubApiService: GithubApiService, private val userManager: UserManager){

    fun getUserRepository(): Flow<State<List<RepositoryModel.RepositoryDataItem>>> {
        return object:NetworkBoundResource<List<RepositoryModel.RepositoryDataItem>>(){
            override suspend fun fetchFromNetwork(): Response<List<RepositoryModel.RepositoryDataItem>> = githubApiService.getGithubUserRepos(userManager.getUserName())

        }.asFlow().flowOn(Dispatchers.IO)
    }
}