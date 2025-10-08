package com.example.innotechstore.ui.screen.address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innotechstore.data.local.entity.UserLocation
import com.example.innotechstore.data.repository.InnotechStoreRepository
import kotlinx.coroutines.launch

class AddressViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {
    val allUserLocations: LiveData<List<UserLocation>> = repository.getAllUsersLocation()

    private val _selectedItemId = MutableLiveData<Int?>()
    val selectedItemId: LiveData<Int?> get() = _selectedItemId

    fun selectItem(id: Int) {
        _selectedItemId.value = id
    }

    fun deleteItem(id: Int) {
        viewModelScope.launch {
            repository.deleteUsersLocation(id)
        }
    }
}