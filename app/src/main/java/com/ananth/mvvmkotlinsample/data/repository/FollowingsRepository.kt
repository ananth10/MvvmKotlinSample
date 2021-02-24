package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.local.dao.FollowingsDao
import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.local.FollowingsEntity
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class FollowingsRepository(private val githubApiService: GithubApiService,private val userManager: UserManager, private val followingsDao: FollowingsDao) {

    fun getUserFollowings():Flow<State<List<FollowingsEntity>>>{

        return object : NetworkBoundResource<List<FollowingsEntity>>(){
            override suspend fun fetchFromNetwork(): Response<List<FollowingsEntity>> = githubApiService.getGithubUserFollowings(userManager.getUserName())
            override suspend fun fetchFromDatabase(): Flow<List<FollowingsEntity>> =followingsDao.retrieveFollowingsList()
            override suspend fun saveRemoteDataToDatabase(followingsList: List<FollowingsEntity>) {
                followingsDao.insertFollowingsList(followingsList)
            }

        }.asFlow().flowOn(Dispatchers.IO)
    }

}