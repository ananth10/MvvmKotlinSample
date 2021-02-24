package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.local.dao.ProfileDao
import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.local.ProfileEntity
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class ProfileRepository(private val userManager:UserManager,private val githubApiService: GithubApiService, private val profileDao: ProfileDao) {


    fun getUserProfile():Flow<State<ProfileEntity>>{
        return object:NetworkBoundResource<ProfileEntity>(){
            override suspend fun fetchFromNetwork(): Response<ProfileEntity> = githubApiService.getGithubUserInfo(userManager.getUserName())

            override suspend fun fetchFromDatabase(): Flow<ProfileEntity> =profileDao.retrieveProfileData()

            override suspend fun saveRemoteDataToDatabase(profileEntity: ProfileEntity) {
             profileDao.insertProfileData(profileEntity)
            }


        }.asFlow().flowOn(Dispatchers.IO)
    }
}