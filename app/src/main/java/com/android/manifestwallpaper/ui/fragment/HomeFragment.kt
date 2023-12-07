package com.android.manifestwallpaper.ui.fragment



import android.app.Dialog
import android.app.WallpaperManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.manifestwallpaper.adapter.RecyclerViewAdapter
import com.android.manifestwallpaper.databinding.DialogLoadingBinding
import com.android.manifestwallpaper.databinding.FragmentHomeBinding
import com.android.manifestwallpaper.util.BlurHashDecoder
import com.android.manifestwallpaper.util.SetWallpaperTask
import com.android.manifestwallpaper.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewmodel:HomeViewModel by viewModels()

    @Inject
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    @Inject
    lateinit var wallpaperManager:WallpaperManager






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            wallRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            wallRecyclerView.adapter = recyclerViewAdapter




            swipeRefreshLayout.setOnRefreshListener {
                recyclerViewAdapter.refresh()
            }

            viewLifecycleOwner.lifecycleScope.launch {
                viewmodel.homePage.collectLatest { pagingData ->
                    recyclerViewAdapter.submitData(pagingData)

                }
            }
            viewLifecycleOwner.lifecycleScope.launch {
                recyclerViewAdapter
                    .loadStateFlow.collectLatest { loadStates ->
                    swipeRefreshLayout.isRefreshing = loadStates.refresh is LoadState.Loading
                }
            }



            recyclerViewAdapter.setOnItemClickListener {



                val loading = Dialog(requireContext())
                val bindingLoading = DialogLoadingBinding.inflate(layoutInflater)
                loading.setContentView(bindingLoading.root)
                loading.setCancelable(false)
                lifecycleScope.launch {

                    loading.show()
                    if (SetWallpaperTask(it.urls.large,wallpaperManager).execute())
                    {
                        loading.dismiss()

                        Toast.makeText(requireContext() , "The wallpaper has been successfully changed." , Toast.LENGTH_SHORT).show()

                    }else
                    {
                        loading.dismiss()
                        Toast.makeText(requireContext(), "error" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

}