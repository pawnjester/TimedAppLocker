package com.example.ui.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ui.model.AppModel
import com.example.ui.provider.AppProvider
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val appProvider: AppProvider
) : ViewModel() {

    private val _installedApps = MutableLiveData<LatestUiState<List<AppModel>>>()
    var installedApps: LiveData<LatestUiState<List<AppModel>>> = _installedApps

    fun getInstalledApps() {
        viewModelScope.launch {
            appProvider.getInstalledApps().collect {
                _installedApps.value = LatestUiState.Success(it)
            }
        }
    }

}

sealed class LatestUiState<out T : Any> {
    data class Success<out T : Any>(val apps: T) : LatestUiState<T>()
    object Loading : LatestUiState<Nothing>()
    object Empty : LatestUiState<Nothing>()
    data class Error(val exception: String) : LatestUiState<Nothing>()
}