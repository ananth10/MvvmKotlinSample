package com.ananth.mvvmkotlinsample.features.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.repository.UserRepository
import com.ananth.mvvmkotlinsample.model.remote.repository.RepositoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoryViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _repositoryLiveData=MutableLiveData<State<List<RepositoryModel.RepositoryDataItem>>>()
    val repositoryLiveData:LiveData<State<List<RepositoryModel.RepositoryDataItem>>>
    get() = _repositoryLiveData
    val repositoryList= MutableLiveData<List<RepositoryModel.RepositoryDataItem>>()
    fun getUserRepository(){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUserRepository().collect {
                _repositoryLiveData.postValue(it)
            }
        }
    }


}