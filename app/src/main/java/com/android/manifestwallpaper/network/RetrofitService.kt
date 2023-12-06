package com.android.manifestwallpaper.network

import com.android.manifestwallpaper.model.Wallpaper
import retrofit2.http.GET
import retrofit2.http.Query


/*interface RetrofitService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") clientId:String=TOKEN,
        @Query("page") page:Int,
        @Query("per_page") perPage:Int=5

    ):List<Wallpaper>
}
*/
interface  RetrofitService{
   //@GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
   @GET("GulayAdgzl/character-api/main/books.json")
    suspend fun getPhotos(
        @Query("page") page:Int,
    ):List<Wallpaper>
}

