package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.local.dao.FollowersDao
import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.local.FollowersEntity
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * @FollowersRepository responsible is to fetch followers data from API or remote server and store it in local database.
 * this is act like mediator between database and ViewModel
 * */
class FollowersRepository(private val githubApiService: GithubApiService, private val userManager: UserManager,private val followersDa:FollowersDao) {

    fun getUserFollowers(): Flow<State<List<FollowersEntity>>> {

        return object : NetworkBoundResource<List<FollowersEntity>>() {
            override suspend fun fetchFromNetwork(): Response<List<FollowersEntity>> =
                githubApiService.getGithubUserFollowers(userManager.getUserName())

            override suspend fun fetchFromDatabase(): Flow<List<FollowersEntity>> = followersDa.retrieveFollowersList()

            override suspend fun saveRemoteDataToDatabase(followersList: List<FollowersEntity>) {
                followersDa.insertFollowersList(followersList)
            }
        }.asFlow().flowOn(Dispatchers.IO)
    }
}