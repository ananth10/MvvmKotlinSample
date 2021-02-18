package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.data.repository.*
import org.koin.dsl.module

val repositoryModules= module {

    single { UserRepository(get(),get()) }
    single { FollowersRepository(get(),get()) }
    single { FollowingsRepository(get(),get()) }
    single { GistsRepository(get(),get()) }
    single { ProfileRepository(get(),get()) }
}