package com.ananth.mvvmkotlinsample.features.followings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.repository.FollowingsRepository
import com.ananth.mvvmkotlinsample.model.remote.followings.FollowingsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FollowingsViewModel(val followingsRepository: FollowingsRepository):ViewModel() {

    private val _followingsLiveData=MutableLiveData<State<List<FollowingsModel.FollowingsModelItem>>>()
    val followingsLiveData:LiveData<State<List<FollowingsModel.FollowingsModelItem>>>
    get() = _followingsLiveData
    val followingList=MutableLiveData<List<FollowingsModel.FollowingsModelItem>>()

    fun getUserFollowings(){
        viewModelScope.launch(Dispatchers.IO) {
            followingsRepository.getUserFollowings().collect {
                _followingsLiveData.postValue(it)
            }
        }
    }
}