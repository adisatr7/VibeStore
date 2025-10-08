package com.example.innotechstore.ui.screen.registration.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innotechstore.data.local.entity.Notification
import com.example.innotechstore.data.repository.InnotechStoreRepository
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {
    fun saveLoginData(username: String, token: String) {
        viewModelScope.launch {
            repository.saveLoginData(username, token)
        }
    }

    fun addNotification(notification: Notification) {
        viewModelScope.launch {
            repository.addNotification(notification)
        }
    }
}