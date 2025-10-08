package com.example.innotechstore.ui.screen.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innotechstore.data.repository.InnotechStoreRepository
import kotlinx.coroutines.launch

class NotificationViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {
    val notifications = repository.getAllNotifications()

    fun markAsRead(notificationId: Int) {
        viewModelScope.launch {
            repository.markAsRead(notificationId)
        }
    }
}