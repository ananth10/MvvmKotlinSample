package com.ananth.mvvmkotlinsample.di

import android.app.Application
import androidx.room.Room
import com.ananth.mvvmkotlinsample.data.local.dao.*
import com.ananth.mvvmkotlinsample.data.local.database.GithubDatabase
import com.ananth.mvvmkotlinsample.utils.DATABASE_NAME
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * @databaseModules here we are declared database dependency
 * */
val databaseModules= module {


    fun provideDatabase(application: Application):GithubDatabase{
       return Room.databaseBuilder(application,GithubDatabase::class.java,DATABASE_NAME)
           .fallbackToDestructiveMigration()
           .build()
    }

    fun provideProfileDao(database: GithubDatabase):ProfileDao{
        return database.getProfileDao()
    }

    fun provideRepositoryDao(database: GithubDatabase):RepositoryDao{
        return database.getRepositoryDao()
    }

    fun provideGistsDao(database: GithubDatabase):GistsDao{
        return database.getGistsDao()
    }

    fun provideFollowersDao(database: GithubDatabase):FollowersDao{
        return database.getFollowersDao()
    }

    fun provideFollowingsDao(database: GithubDatabase):FollowingsDao{
        return database.getFollowingsDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideProfileDao(get()) }
    single { provideRepositoryDao(get()) }
    single { provideGistsDao(get()) }
    single { provideFollowingsDao(get()) }
    single { provideFollowersDao(get()) }
}