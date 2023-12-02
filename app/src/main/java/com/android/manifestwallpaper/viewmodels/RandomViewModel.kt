package com.android.manifestwallpaper.viewmodels

import androidx.lifecycle.ViewModel
import com.android.manifestwallpaper.repository.MainRepository

class RandomViewModel:ViewModel() {
    val repository=MainRepository()
}