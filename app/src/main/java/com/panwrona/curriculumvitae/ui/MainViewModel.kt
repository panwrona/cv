package com.panwrona.curriculumvitae.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panwrona.curriculumvitae.entity.CurriculumVitae
import com.panwrona.curriculumvitae.repository.Payload
import com.panwrona.curriculumvitae.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
): ViewModel() {

    val uiData = MutableLiveData<MainUI>()

    init {
        fetchCurriculumVitae()
    }

    fun fetchCurriculumVitae() = viewModelScope.launch {
        uiData.postValue(MainUI.Loading)
        try {
            val response = repository.getCurriculumVitae()
            when(response) {
                is Payload.Success -> uiData.postValue(MainUI.Success(response.value))
                is Payload.GeneralError -> uiData.postValue(MainUI.GeneralError(response.error))
                is Payload.NetworkError -> uiData.postValue(MainUI.NetworkError(response.error))
                is Payload.ServerError -> uiData.postValue(MainUI.ServerError(response.code, response.error))
            }
        } catch(e: Exception) {
            uiData.postValue(MainUI.GeneralError(e.toString()))
        }
    }
}

sealed class MainUI {
    object Loading: MainUI()
    data class Success(val cv: CurriculumVitae): MainUI()
    data class GeneralError(val error: String): MainUI()
    data class NetworkError(val error: String): MainUI()
    data class ServerError(val code: Int, val error: String): MainUI()
}