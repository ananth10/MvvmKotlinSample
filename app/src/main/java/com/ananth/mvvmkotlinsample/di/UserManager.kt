package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.utils.UserManager
import org.koin.dsl.module

/**
 * @userManagerModule here we are declared usermanager dependency
 *
 * */
val userManagerModule= module {
    single { UserManager(get()) }
}