package com.android.manifestwallpaper.ui.fragment


import com.android.manifestwallpaper.adapter.RecyclerViewAdapter
import com.android.manifestwallpaper.base.BaseFragment
import com.android.manifestwallpaper.databinding.FragmentPopularBinding


class PopularFragment:BaseFragment<FragmentPopularBinding>(
    FragmentPopularBinding::inflate
){
    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }


    override var recyclerViewAdapter: RecyclerViewAdapter=RecyclerViewAdapter()

}