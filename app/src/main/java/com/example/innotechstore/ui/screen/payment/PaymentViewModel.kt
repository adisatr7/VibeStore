package com.example.innotechstore.ui.screen.payment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innotechstore.data.repository.InnotechStoreRepository
import kotlinx.coroutines.launch

class PaymentViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {
    val latestCheckout = repository.getLatestCheckout()

    private val _selectedPaymentId = MutableLiveData<Int?>()
    val selectedPaymentId: LiveData<Int?> get() = _selectedPaymentId

    fun selectPayment(id: Int) {
        _selectedPaymentId.value = id
    }

    fun addPaymentMethodToCheckout(paymentMethod: String){
        latestCheckout.value?.let { checkout ->
            viewModelScope.launch {
                repository.updatePaymentMethodCheckout(checkout.id, paymentMethod)
            }
        }
    }
}