package com.android.manifestwallpaper.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.manifestwallpaper.R
import com.android.manifestwallpaper.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}