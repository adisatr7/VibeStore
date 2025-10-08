package com.example.innotechstore.ui.screen.yourorder

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.innotechstore.data.local.entity.Checkout
import com.example.innotechstore.data.repository.InnotechStoreRepository

class YourOrderViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {

    val checkoutItems: LiveData<List<Checkout>> = repository.getAllCheckout()


}