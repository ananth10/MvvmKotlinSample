package com.ananth.mvvmkotlinsample.data.remote.api


import com.ananth.mvvmkotlinsample.model.local.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {

    @GET("users/{username}")
    suspend fun getGithubUserInfo(@Path("username") userName:String): Response<ProfileEntity>

    @GET("users/{username}/followers")
    suspend fun getGithubUserFollowers(@Path("username") userName: String): Response<List<FollowersEntity>>

    @GET("users/{username}/following")
    suspend fun getGithubUserFollowings(@Path("username") userName: String): Response<List<FollowingsEntity>>

    @GET("users/{username}/repos")
    suspend fun getGithubUserRepos(@Path("username") userName: String): Response<List<RepositoryEntity>>

    @GET("users/{username}/gists")
    suspend fun getGithubGists(@Path("username") userName: String): Response<List<GistsEntity>>

}