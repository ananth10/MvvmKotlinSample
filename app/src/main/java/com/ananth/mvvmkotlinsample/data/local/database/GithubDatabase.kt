package com.ananth.mvvmkotlinsample.data.local.database

import android.content.Context
import androidx.room.*
import com.ananth.mvvmkotlinsample.data.local.converter.Converters
import com.ananth.mvvmkotlinsample.data.local.converter.GistsFileTypeConverter
import com.ananth.mvvmkotlinsample.data.local.converter.OwnerTypeConverter
import com.ananth.mvvmkotlinsample.data.local.converter.RepositoryLicenseTypeConverter
import com.ananth.mvvmkotlinsample.data.local.dao.*
import com.ananth.mvvmkotlinsample.model.local.*
import com.ananth.mvvmkotlinsample.utils.DATABASE_NAME

@Database(entities = [FollowingsEntity::class,FollowersEntity::class,ProfileEntity::class,GistsEntity::class,RepositoryEntity::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class,GistsFileTypeConverter::class,OwnerTypeConverter::class,RepositoryLicenseTypeConverter::class)
abstract class GithubDatabase:RoomDatabase() {

    abstract fun getProfileDao(): ProfileDao
    abstract fun getFollowersDao(): FollowersDao
    abstract fun getFollowingsDao(): FollowingsDao
    abstract fun getRepositoryDao(): RepositoryDao
    abstract fun getGistsDao(): GistsDao

    companion object{
        @Volatile
        private var instance: GithubDatabase?=null

        fun getInstance(context: Context): GithubDatabase {
            return instance
                ?: synchronized(this){
                instance
                    ?: Room.databaseBuilder(context,
                        GithubDatabase::class.java,DATABASE_NAME).build().also {
                    instance =it
                }
            }
        }
    }


}