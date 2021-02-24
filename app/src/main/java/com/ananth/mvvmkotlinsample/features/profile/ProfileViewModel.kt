package com.ananth.mvvmkotlinsample.features.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ananth.mvvmkotlinsample.data.local.database.GithubDatabase
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.repository.ProfileRepository
import com.ananth.mvvmkotlinsample.model.local.ProfileEntity
import com.ananth.mvvmkotlinsample.utils.UserManager
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect


class ProfileViewModel(private val profileRepository: ProfileRepository, private val userManager: UserManager, private val database: GithubDatabase):ViewModel() {

    private val _profileLiveData=MutableLiveData<State<ProfileEntity>>()
    val profileLiveData: LiveData<State<ProfileEntity>>
    get() = _profileLiveData

    fun getUserProfile(userName:String?){
        userManager.setUserName(userName?:"")
        viewModelScope.launch(Dispatchers.IO){
            profileRepository.getUserProfile().collect {
                _profileLiveData.postValue(it)
            }
        }
    }

    fun clearUserName()=userManager.setUserName("")

    fun clearDatabase(){
        GlobalScope.launch(Dispatchers.IO) {
            database.clearAllTables()
        }
    }
}