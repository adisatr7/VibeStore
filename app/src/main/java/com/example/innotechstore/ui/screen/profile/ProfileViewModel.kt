package com.example.innotechstore.ui.screen.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.innotechstore.data.repository.InnotechStoreRepository
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {
    fun getUsername() : LiveData<String> {
        return repository.getUsername().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            withContext(NonCancellable) {
                repository.logout()
            }
        }
    }
}