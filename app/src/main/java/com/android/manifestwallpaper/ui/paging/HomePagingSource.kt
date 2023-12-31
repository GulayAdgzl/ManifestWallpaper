package com.android.manifestwallpaper.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.manifestwallpaper.model.Wallpaper
import com.android.manifestwallpaper.network.RetrofitService

class HomePagingSource (
    private val apiService:RetrofitService
            ): PagingSource<Int, Wallpaper>(){

    override fun getRefreshKey(state: PagingState<Int, Wallpaper>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Wallpaper> {
        return try{
            val page=params.key ?: 1
            val photos=apiService.getPhotos(page = page)
            LoadResult.Page(
                data=photos,
                prevKey = if(page == 1) null else page -1,
                nextKey = if(photos.isEmpty()) null else page +1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }



}