package com.android.manifestwallpaper.viewmodels

import androidx.lifecycle.ViewModel
import com.android.manifestwallpaper.repository.MainRepository

class CategoriesViewModel:ViewModel() {
    val repository=MainRepository()
}