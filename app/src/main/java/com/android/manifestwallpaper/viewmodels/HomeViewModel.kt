package com.android.manifestwallpaper.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.manifestwallpaper.model.Wallpaper
import com.android.manifestwallpaper.repository.MainRepository
import com.android.manifestwallpaper.ui.paging.HomePagingSource
import kotlinx.coroutines.flow.Flow

class HomeViewModel:ViewModel() {
   private val repository=MainRepository()

    val homePage: Flow<PagingData<Wallpaper>>  =Pager(config = PagingConfig(pageSize = 40, enablePlaceholders = false),
    pagingSourceFactory = {
        HomePagingSource(repository.retroService())
    }).flow.cachedIn(viewModelScope)
}