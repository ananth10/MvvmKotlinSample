package com.ananth.mvvmkotlinsample.model.local

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Entity(primaryKeys = ["id"], tableName = "Repository")
@Parcelize
data class RepositoryEntity(
        var archive_url: String?="",
        var archived: Boolean?=false,
        var assignees_url: String?="",
        var blobs_url: String?="",
        var branches_url: String?="",
        var clone_url: String?="",
        var collaborators_url: String?="",
        var comments_url: String?="",
        var commits_url: String?="",
        var compare_url: String?="",
        var contents_url: String?="",
        var contributors_url: String?="",
        var created_at: String?="",
        var default_branch: String?="",
        var deployments_url: String?="",
        var description: String?="",
        var disabled: Boolean?=false,
        var downloads_url: String?="",
        var events_url: String?="",
        var fork: Boolean?=false,
        var forks: Int?=0,
        var forks_count: Int?=0,
        var forks_url: String?="",
        var full_name: String?="",
        var git_commits_url: String?="",
        var git_refs_url: String?="",
        var git_tags_url: String?="",
        var git_url: String?="",
        var has_downloads: Boolean?=false,
        var has_issues: Boolean?=false,
        var has_pages: Boolean?=false,
        var has_projects: Boolean?=false,
        var has_wiki: Boolean?=false,
        var homepage: String?="",
        var hooks_url: String?="",
        var html_url: String?="",
        var id: Int?=0,
        var issue_comment_url: String?="",
        var issue_events_url: String?="",
        var issues_url: String?="",
        var keys_url: String?="",
        var labels_url: String?="",
        var language: String?="",
        var languages_url: String?="",
        var license: License?=null,
        var merges_url: String?="",
        var milestones_url: String?="",
        var mirror_url: String?="",
        var name: String?="",
        var node_id: String?="",
        var notifications_url: String?="",
        var open_issues: Int?=0,
        var open_issues_count: Int?=0,
        var owner: OwnerEntity?=null,
        var `private`: Boolean?=false,
        var pulls_url: String?="",
        var pushed_at: String?="",
        var releases_url: String?="",
        var size: Int?=0,
        var ssh_url: String?="",
        var stargazers_count: Int?=0,
        var stargazers_url: String?="",
        var statuses_url: String?="",
        var subscribers_url: String?="",
        var subscription_url: String?="",
        var svn_url: String?="",
        var tags_url: String?="",
        var teams_url: String?="",
        var trees_url: String?="",
        var updated_at: String?="",
        var url: String?="",
        var watchers: Int?=0,
        var watchers_count: Int?=0
    ):Parcelable
  {     @Entity(primaryKeys = ["spdx_id"],tableName = "license")
        @Parcelize
        data class License(
            var key: String?="",
            var name: String?="",
            var node_id: String?="",
            var spdx_id: String?="",
            var url: String?=""
        ):Parcelable
    }
