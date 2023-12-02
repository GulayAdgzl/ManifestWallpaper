package com.android.manifestwallpaper.repository

import com.android.manifestwallpaper.network.RetrofitApi
import com.android.manifestwallpaper.network.RetrofitService

class MainRepository {
    fun retroService():RetrofitService=RetrofitApi.apiService
}