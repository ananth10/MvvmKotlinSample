package com.ananth.mvvmkotlinsample.features.gists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.data.repository.GistsRepository
import com.ananth.mvvmkotlinsample.model.local.GistsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GistsViewModel(private val gistsRepository: GistsRepository):ViewModel() {

    private val _gistsLiveData=MutableLiveData<State<List<GistsEntity>>>()
    val gistsLiveData: LiveData<State<List<GistsEntity>>>
    get() = _gistsLiveData
    val gistsList=MutableLiveData<List<GistsEntity>>()
    fun getUserGists(){
        viewModelScope.launch(Dispatchers.IO) {
            gistsRepository.getUserGists().collect {
                _gistsLiveData.postValue(it)
            }
        }
    }
}