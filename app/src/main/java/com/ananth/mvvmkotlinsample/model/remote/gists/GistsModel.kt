package com.ananth.mvvmkotlinsample.model.remote.gists


import com.squareup.moshi.Json

class GistsModel : ArrayList<GistsModel.GistsModelItem>(){
    data class GistsModelItem(
        @Json(name = "comments")
        val comments: Int? = null,
        @Json(name = "comments_url")
        val commentsUrl: String? = null,
        @Json(name = "commits_url")
        val commitsUrl: String? = null,
        @Json(name = "created_at")
        val createdAt: String? = null,
        @Json(name = "description")
        val description: String? = null,
        @Json(name = "files")
        val files: Files? = null,
        @Json(name = "forks_url")
        val forksUrl: String? = null,
        @Json(name = "git_pull_url")
        val gitPullUrl: String? = null,
        @Json(name = "git_push_url")
        val gitPushUrl: String? = null,
        @Json(name = "html_url")
        val htmlUrl: String? = null,
        @Json(name = "id")
        val id: String? = null,
        @Json(name = "node_id")
        val nodeId: String? = null,
        @Json(name = "owner")
        val owner: Owner? = null,
        @Json(name = "public")
        val `public`: Boolean? = null,
        @Json(name = "truncated")
        val truncated: Boolean? = null,
        @Json(name = "updated_at")
        val updatedAt: String? = null,
        @Json(name = "url")
        val url: String? = null,
        @Json(name = "user")
        val user: Any? = null
    ) {
        data class Files(
            @Json(name = "gistfile1.md")
            val gistfile1Md: Gistfile1Md? = null
        ) {
            data class Gistfile1Md(
                @Json(name = "filename")
                val filename: String? = null,
                @Json(name = "language")
                val language: String? = null,
                @Json(name = "raw_url")
                val rawUrl: String? = null,
                @Json(name = "size")
                val size: Int? = null,
                @Json(name = "type")
                val type: String? = null
            )
        }
    
        data class Owner(
            @Json(name = "avatar_url")
            val avatarUrl: String? = null,
            @Json(name = "events_url")
            val eventsUrl: String? = null,
            @Json(name = "followers_url")
            val followersUrl: String? = null,
            @Json(name = "following_url")
            val followingUrl: String? = null,
            @Json(name = "gists_url")
            val gistsUrl: String? = null,
            @Json(name = "gravatar_id")
            val gravatarId: String? = null,
            @Json(name = "html_url")
            val htmlUrl: String? = null,
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "login")
            val login: String? = null,
            @Json(name = "node_id")
            val nodeId: String? = null,
            @Json(name = "organizations_url")
            val organizationsUrl: String? = null,
            @Json(name = "received_events_url")
            val receivedEventsUrl: String? = null,
            @Json(name = "repos_url")
            val reposUrl: String? = null,
            @Json(name = "site_admin")
            val siteAdmin: Boolean? = null,
            @Json(name = "starred_url")
            val starredUrl: String? = null,
            @Json(name = "subscriptions_url")
            val subscriptionsUrl: String? = null,
            @Json(name = "type")
            val type: String? = null,
            @Json(name = "url")
            val url: String? = null
        )
    }
}