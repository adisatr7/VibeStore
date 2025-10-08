package com.example.innotechstore.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.innotechstore.data.local.entity.Cart
import com.example.innotechstore.data.repository.InnotechStoreRepository

class HomeViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel(){
    val cartItems: LiveData<List<Cart>> = repository.getAllCartItems()
    val unreadNotificationCount: LiveData<Int> = repository.getUnReadNotification()
}