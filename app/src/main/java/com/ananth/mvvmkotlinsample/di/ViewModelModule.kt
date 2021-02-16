package com.ananth.mvvmkotlinsample.di

import com.ananth.mvvmkotlinsample.features.Repository.RepositoryViewModel
import com.ananth.mvvmkotlinsample.features.followers.FollowersViewModel
import com.ananth.mvvmkotlinsample.features.followings.FollowingsViewModel
import com.ananth.mvvmkotlinsample.features.gists.GistsViewModel
import com.ananth.mvvmkotlinsample.features.profile.ProfileViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules= module {
    viewModel { FollowersViewModel(get()) }
    viewModel { FollowingsViewModel(get()) }
    viewModel { GistsViewModel(get()) }
    viewModel { ProfileViewModel(get(),get()) }
    viewModel { RepositoryViewModel(get()) }
}