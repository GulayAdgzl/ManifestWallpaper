package com.android.manifestwallpaper.network

import com.android.manifestwallpaper.model.Wallpaper
import com.android.manifestwallpaper.util.TOKEN
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") clientId:String=TOKEN,
        @Query("page") page:Int,
        @Query("per_page") perPage:Int=30

    ):List<Wallpaper>
}