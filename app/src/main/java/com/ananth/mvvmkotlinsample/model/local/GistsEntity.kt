package com.ananth.mvvmkotlinsample.model.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Gists")
@Parcelize
 data class GistsEntity(
    var comments: Int?=0,
    var comments_url: String?="",
    var commits_url: String?="",
    var created_at: String?="",
    var description: String?="",
    var files: Files?=null,
    var forks_url: String?="",
    var git_pull_url: String?="",
    var git_push_url: String?="",
    var html_url: String?="",
    var id: String?="",
    var node_id: String?="",
    var owner: OwnerEntity?=null,
    var public: Boolean?=false,
    var truncated: Boolean?=false,
    var updated_at: String?="",
    var url: String?="",
    @PrimaryKey(autoGenerate = true) var primaryId: Int=0,
    ):Parcelable
{
        @Entity(tableName = "files")
        @Parcelize
        data class Files(
            var gistfile1: Gistfile1Md?=null
        ) :Parcelable
        {
            @Entity(tableName = "gistsfile1md")
            @Parcelize
            data class Gistfile1Md(
                var filename: String?="",
                var language: String?="",
                var raw_url: String?="",
                var size: Int?=0,
                var type: String?=""
            ):Parcelable
        }
    }
