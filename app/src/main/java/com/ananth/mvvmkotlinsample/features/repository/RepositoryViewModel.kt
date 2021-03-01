package com.ananth.mvvmkotlinsample.features.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.repository.UserRepository
import com.ananth.mvvmkotlinsample.model.local.RepositoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * @RepositoryViewModel responsible for preparing and managing the repository data for RepositoryFragment
 * @param userRepository - responsible for providing repository data
 *
 * */
class RepositoryViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _repositoryLiveData=MutableLiveData<State<List<RepositoryEntity>>>()
    val repositoryLiveData:LiveData<State<List<RepositoryEntity>>>
    get() = _repositoryLiveData
    val repositoryList= MutableLiveData<List<RepositoryEntity>>()
    fun getUserRepository(){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUserRepository().collect {
                _repositoryLiveData.postValue(it)
            }
        }
    }


}