package com.ananth.mvvmkotlinsample.features.followings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.repository.FollowingsRepository
import com.ananth.mvvmkotlinsample.model.local.FollowingsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * @FollowingsViewModel responsible for preparing and managing the following data for FollowingsFragment
 * @param followingsRepository - responsible for providing following data
 *
 * */
class FollowingsViewModel(val followingsRepository: FollowingsRepository):ViewModel() {

    private val _followingsLiveData=MutableLiveData<State<List<FollowingsEntity>>>()
    val followingsLiveData:LiveData<State<List<FollowingsEntity>>>
    get() = _followingsLiveData
    val followingList=MutableLiveData<List<FollowingsEntity>>()

    fun getUserFollowings(){
        viewModelScope.launch(Dispatchers.IO) {
            followingsRepository.getUserFollowings().collect {
                _followingsLiveData.postValue(it)
            }
        }
    }
}