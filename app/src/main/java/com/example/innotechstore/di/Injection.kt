package com.example.innotechstore.di

import android.content.Context
import android.location.Geocoder
import com.example.innotechstore.data.local.database.InnotechStoreRoomDatabase
import com.example.innotechstore.data.remote.retrofit.ApiConfig
import com.example.innotechstore.data.repository.InnotechStoreRepository
import com.example.innotechstore.util.SessionPreferences
import com.example.innotechstore.util.dataStore
import com.google.android.gms.location.LocationServices
import java.util.Locale

object Injection {
    fun provideRepository(context: Context): InnotechStoreRepository {
        val user = SessionPreferences.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        val cartDao = InnotechStoreRoomDatabase.getDatabase(context).cartDao()
        val favoriteDao = InnotechStoreRoomDatabase.getDatabase(context).favouriteDao()
        val orderDao = InnotechStoreRoomDatabase.getDatabase(context).orderDao()
        val checkoutDao = InnotechStoreRoomDatabase.getDatabase(context).checkoutDao()
        val notificationDao = InnotechStoreRoomDatabase.getDatabase(context).notificationDao()
        val userLocationDao = InnotechStoreRoomDatabase.getDatabase(context).userLocationDao()
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        val geocoder = Geocoder(context, Locale.getDefault())
        return InnotechStoreRepository.getInstance(
            apiService,
            user,
            cartDao,
            favoriteDao,
            orderDao,
            checkoutDao,
            notificationDao,
            userLocationDao,
            fusedLocationClient,
            geocoder,
        )
    }
}