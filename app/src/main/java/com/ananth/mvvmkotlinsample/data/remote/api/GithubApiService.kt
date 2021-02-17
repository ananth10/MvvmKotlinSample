package com.ananth.mvvmkotlinsample.data.remote.api


import com.ananth.mvvmkotlinsample.model.remote.followers.FollowersModel
import com.ananth.mvvmkotlinsample.model.remote.followings.FollowingsModel
import com.ananth.mvvmkotlinsample.model.remote.gists.GistsModel
import com.ananth.mvvmkotlinsample.model.remote.profile.ProfileModel
import com.ananth.mvvmkotlinsample.model.remote.repository.RepositoryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {

    @GET("users/{username}")
    suspend fun getGithubUserInfo(@Path("username") userName:String): Response<ProfileModel>

    @GET("users/{username}/followers")
    suspend fun getGithubUserFollowers(@Path("username") userName: String): Response<FollowersModel>

    @GET("users/{username}/followings")
    suspend fun getGithubUserFollowings(@Path("username") userName: String): Response<FollowingsModel>

    @GET("users/{username}/repos")
    suspend fun getGithubUserRepos(@Path("username") userName: String): Response<List<RepositoryModel.RepositoryDataItem>>

    @GET("users/{username}/gists")
    suspend fun getGithubGists(@Path("username") userName: String): Response<GistsModel>

}