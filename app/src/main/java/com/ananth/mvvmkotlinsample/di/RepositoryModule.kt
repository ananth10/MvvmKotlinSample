package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.data.repository.*
import org.koin.dsl.module

val repositoryModules= module {

    single { UserRepository(get(),get(),get()) }
    single { FollowersRepository(get(),get(),get()) }
    single { FollowingsRepository(get(),get(),get()) }
    single { GistsRepository(get(),get(),get()) }
    single { ProfileRepository(get(),get(),get()) }
}