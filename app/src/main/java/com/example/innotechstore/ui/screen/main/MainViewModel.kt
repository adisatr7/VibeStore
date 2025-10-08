package com.example.innotechstore.ui.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.innotechstore.data.repository.InnotechStoreRepository
import com.example.innotechstore.model.LoginResponse

class MainViewModel (
    private val repository: InnotechStoreRepository
) : ViewModel() {
    fun getSession() : LiveData<LoginResponse> {
        return repository.getSession().asLiveData()
    }
}