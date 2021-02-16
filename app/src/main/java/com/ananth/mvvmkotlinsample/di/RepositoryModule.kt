package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.data.repository.*
import org.koin.dsl.module

val repositoryModules= module {

    single { UserRepository(get()) }
    single { FollowersRepository(get()) }
    single { FollowingsRepository(get()) }
    single { GistsRepository(get()) }
    single { ProfileRepository(get(),get()) }
}