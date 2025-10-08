package com.example.innotechstore.ui.screen.payment.success_payment

import androidx.lifecycle.ViewModel
import com.example.innotechstore.data.repository.InnotechStoreRepository

class SuccessPaymentViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {
    val latestCheckout = repository.getLatestCheckout()
}