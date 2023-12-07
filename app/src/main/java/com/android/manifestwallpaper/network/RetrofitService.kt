package com.android.manifestwallpaper.network

import com.android.manifestwallpaper.model.Wallpaper
import retrofit2.http.GET
import retrofit2.http.Query



interface  RetrofitService{

   @GET("GulayAdgzl/character-api/main/books.json")
    suspend fun getPhotos(
        @Query("page") page:Int,
    ):List<Wallpaper>
}

