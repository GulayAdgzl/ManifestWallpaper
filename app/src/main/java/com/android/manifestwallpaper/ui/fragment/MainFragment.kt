package com.android.manifestwallpaper.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.manifestwallpaper.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private val tabTitles= listOf("Home","Popular","Random","Categories")
    private val fragments= listOf(HomeFragment(),PopularFragment(),RandomFragment(),CategoriesFragment())
    private lateinit var binding:FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMainBinding.inflate(layoutInflater,container,false)
        initTabLayout()
        return binding.root
    }

    private fun initTabLayout(){
        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position ->
            tab.text=tabTitles[position]
        }.attach()
    }
}