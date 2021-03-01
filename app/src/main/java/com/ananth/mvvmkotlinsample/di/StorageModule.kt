package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.utils.SharedPreferenceStorage
import com.ananth.mvvmkotlinsample.utils.Storage
import org.koin.dsl.module

/**
 * @storageModule here we are declared storage dependency
 *
 * */
val storageModule= module {
    single { SharedPreferenceStorage(get()) as Storage }
}