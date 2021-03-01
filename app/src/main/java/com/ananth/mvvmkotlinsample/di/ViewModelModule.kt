package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.features.repository.RepositoryViewModel
import com.ananth.mvvmkotlinsample.features.followers.FollowersViewModel
import com.ananth.mvvmkotlinsample.features.followings.FollowingsViewModel
import com.ananth.mvvmkotlinsample.features.gists.GistsViewModel
import com.ananth.mvvmkotlinsample.features.profile.ProfileViewModel
import com.ananth.mvvmkotlinsample.features.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * @userManagerModule here we are declared ViewModel dependency
 *
 * */
val viewModelModules= module {
    viewModel { FollowersViewModel(get()) }
    viewModel { FollowingsViewModel(get()) }
    viewModel { GistsViewModel(get()) }
    viewModel { ProfileViewModel(get(),get(),get()) }
    viewModel { RepositoryViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}