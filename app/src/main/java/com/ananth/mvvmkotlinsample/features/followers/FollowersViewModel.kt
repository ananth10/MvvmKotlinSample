package com.ananth.mvvmkotlinsample.features.followers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.repository.FollowersRepository
import com.ananth.mvvmkotlinsample.model.remote.followers.FollowersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FollowersViewModel(private val followersRepository: FollowersRepository):ViewModel() {

    private val _followersLiveData=MutableLiveData<State<FollowersModel>>()
    val followersLiveData:LiveData<State<FollowersModel>>
    get() = _followersLiveData

    fun getUserFollowers(){
        viewModelScope.launch(Dispatchers.IO) {
            followersRepository.getUserFollowers().collect {
                _followersLiveData.value=it
            }
        }
    }
}