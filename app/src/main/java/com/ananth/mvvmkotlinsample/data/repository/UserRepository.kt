package com.ananth.mvvmkotlinsample.data.repository


import com.ananth.mvvmkotlinsample.data.local.dao.RepositoryDao
import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.local.RepositoryEntity
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * @UserRepository responsible is to fetch repository data from API or remote server and store it in local database.
 * this is act like mediator between database and ViewModel
 * */
class UserRepository (private val githubApiService: GithubApiService, private val userManager: UserManager, private val repositoryDao: RepositoryDao){

    fun getUserRepository(): Flow<State<List<RepositoryEntity>>> {
        return object:NetworkBoundResource<List<RepositoryEntity>>(){
            override suspend fun fetchFromNetwork(): Response<List<RepositoryEntity>> = githubApiService.getGithubUserRepos(userManager.getUserName())
            override suspend fun fetchFromDatabase(): Flow<List<RepositoryEntity>> =repositoryDao.retrieveRepositoryList()

            override suspend fun saveRemoteDataToDatabase(repositoryList: List<RepositoryEntity>) {
                println("TEST5555")
                repositoryDao.insertRepositoryList(repositoryList)
            }

        }.asFlow().flowOn(Dispatchers.IO)
    }
}