package com.android.manifestwallpaper.ui.fragment


import com.android.manifestwallpaper.adapter.RecyclerViewAdapter
import com.android.manifestwallpaper.base.BaseFragment
import com.android.manifestwallpaper.databinding.FragmentRandomBinding


class RandomFragment: BaseFragment<FragmentRandomBinding> (
    FragmentRandomBinding::inflate
        ){
    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }


    override var recyclerViewAdapter: RecyclerViewAdapter=RecyclerViewAdapter()

}