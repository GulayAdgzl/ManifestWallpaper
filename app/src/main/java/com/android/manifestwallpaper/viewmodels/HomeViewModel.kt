package com.android.manifestwallpaper.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.android.manifestwallpaper.repository.MainRepository
import com.android.manifestwallpaper.ui.paging.HomePagingSource

class HomeViewModel:ViewModel() {
   private val repository=MainRepository()

    val homePage=Pager(config = PagingConfig(pageSize = 30),
    pagingSourceFactory = {
        HomePagingSource(repository.retroService())
    }).flow.cachedIn(viewModelScope)
}