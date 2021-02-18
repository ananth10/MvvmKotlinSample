package com.ananth.mvvmkotlinsample.data.repository



import com.ananth.mvvmkotlinsample.data.remote.NetworkBoundResource
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.ananth.mvvmkotlinsample.model.remote.gists.GistsModel
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class GistsRepository(private val githubApiService: GithubApiService, private val userManager: UserManager) {

    fun getUserGists():Flow<State<List<GistsModel.GistsModelItem>>>{

        return object :NetworkBoundResource<List<GistsModel.GistsModelItem>>(){
            override suspend fun fetchFromNetwork(): Response<List<GistsModel.GistsModelItem>> =githubApiService.getGithubGists(userManager.getUserName())

        }.asFlow().flowOn(Dispatchers.IO)
    }
}