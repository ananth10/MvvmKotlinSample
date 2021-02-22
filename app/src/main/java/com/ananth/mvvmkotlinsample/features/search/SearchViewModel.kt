package com.ananth.mvvmkotlinsample.features.search

import androidx.lifecycle.ViewModel
import com.ananth.mvvmkotlinsample.utils.UserManager

class SearchViewModel(private val userManager: UserManager):ViewModel() {

    fun isUserLoggedIn()=userManager.getUserName().isNotEmpty()

    fun getUserName()=userManager.getUserName()
}