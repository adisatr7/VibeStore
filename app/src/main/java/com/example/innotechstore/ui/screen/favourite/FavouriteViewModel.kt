package com.example.innotechstore.ui.screen.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.innotechstore.data.local.entity.Favourite
import com.example.innotechstore.data.repository.InnotechStoreRepository

class FavouriteViewModel(
    private val repository: InnotechStoreRepository
) : ViewModel() {
    val allFavorites: LiveData<List<Favourite>> = repository.getAllFavourites()
}