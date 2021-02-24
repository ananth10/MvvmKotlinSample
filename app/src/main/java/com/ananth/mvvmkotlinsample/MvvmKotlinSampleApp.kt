package com.ananth.mvvmkotlinsample

import android.app.Application
import com.ananth.mvvmkotlinsample.di.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


open class MvvmKotlinSampleApp: Application(){

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidContext(applicationContext)
            modules(
                networkModules,
                storageModule,
                userManagerModule,
                repositoryModules,
                viewModelModules,
                databaseModules
            )
        }
    }
}