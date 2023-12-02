package com.android.manifestwallpaper.model

import com.google.gson.annotations.SerializedName

data class UnsplashPhotoUrls(
    @SerializedName("small")
    val small:String,
    @SerializedName("regular")
    val medium:String,
    @SerializedName("raw")
    val large:String
)
