package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.utils.UserManager
import org.koin.dsl.module

val userManagerModule= module {
    single { UserManager(get()) }
}