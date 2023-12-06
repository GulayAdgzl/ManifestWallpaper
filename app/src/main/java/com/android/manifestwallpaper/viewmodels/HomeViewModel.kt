package com.android.manifestwallpaper.viewmodels


import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.manifestwallpaper.model.Wallpaper
import com.android.manifestwallpaper.network.RetrofitService
import com.android.manifestwallpaper.ui.paging.HomePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor
    (private val retrofitService:RetrofitService)  :ViewModel() {

    val homePage: Flow<PagingData<Wallpaper>> = Pager(
        config = PagingConfig(pageSize = 10, enablePlaceholders = false),
    pagingSourceFactory = {
        HomePagingSource(retrofitService)
    }).flow

}

