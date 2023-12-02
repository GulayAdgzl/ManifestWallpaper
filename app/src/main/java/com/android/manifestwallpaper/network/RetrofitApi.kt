package com.android.manifestwallpaper.network

import com.android.manifestwallpaper.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: RetrofitService = retrofit.create(
        RetrofitService::class.java)

}