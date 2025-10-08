package com.example.innotechstore.data.local.database

import androidx.room.TypeConverter
import com.example.innotechstore.data.local.entity.Cart
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromCartList(value: List<Cart>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toCartList(value: String): List<Cart> {
        val gson = Gson()
        val type = object : TypeToken<List<Cart>>() {}.type
        return gson.fromJson(value, type)
    }
}