package com.ananth.mvvmkotlinsample.features.profile

interface ProfileClickEvent {

    fun onRepoClick()
    fun onGistsClick()
    fun onFollowingClick()
    fun onFollowersClick()
}