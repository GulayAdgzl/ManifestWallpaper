package com.android.manifestwallpaper.ui.fragment


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.android.manifestwallpaper.adapter.RecyclerViewAdapter
import com.android.manifestwallpaper.base.BaseFragment
import com.android.manifestwallpaper.databinding.FragmentHomeBinding
import com.android.manifestwallpaper.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    private val viewmodel:HomeViewModel by viewModels()
    override fun initViewModel() {
        lifecycleScope.launch {
            viewmodel.homePage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager=GridLayoutManager(context,3)
        binding.wallRecyclerView.layoutManager=layoutManager
        binding.wallRecyclerView.adapter=recyclerViewAdapter
    }

    override var recyclerViewAdapter: RecyclerViewAdapter= RecyclerViewAdapter()



}