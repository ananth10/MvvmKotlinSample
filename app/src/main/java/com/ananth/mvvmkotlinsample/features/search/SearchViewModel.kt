package com.ananth.mvvmkotlinsample.features.search

import androidx.lifecycle.ViewModel
import com.ananth.mvvmkotlinsample.utils.UserManager

/**
 * @SearchViewModel responsible for preparing and managing the search data for SearchFragment
 * @param userManager - responsible for providing user cached information
 *
 * */
class SearchViewModel(private val userManager: UserManager):ViewModel() {

    fun isUserLoggedIn()=userManager.getUserName().isNotEmpty()

    fun getUserName()=userManager.getUserName()
}