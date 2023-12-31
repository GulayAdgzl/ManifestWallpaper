package com.android.manifestwallpaper.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.manifestwallpaper.databinding.ItemRecyclerviewBinding
import com.android.manifestwallpaper.model.Wallpaper
import com.android.manifestwallpaper.util.BlurHashDecoder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import javax.inject.Inject

class RecyclerViewAdapter @Inject constructor() :PagingDataAdapter<Wallpaper,RecyclerViewAdapter.MyViewHolder>( PHOTO_COMPARATOR){
    private lateinit var binding:ItemRecyclerviewBinding

  inner class MyViewHolder():RecyclerView.ViewHolder(binding.root){
      fun bind(photo: Wallpaper?) {
          binding.apply {

              //denem
              val blurHashAsDrawable=BlurHashDecoder.blurHashBitmap(imageView.resources,photo)


              if (photo != null) {

                      imageView.load(photo.urls.small)

                  Log.e("HECTOR" , "small --> "+photo.urls.small)

              } else {
                  //imageView.setImageDrawable(null)
                  imageView.setImageDrawable(blurHashAsDrawable)

              }
              root.setOnClickListener {
                  onItemClickListener?.let {
                      photo?.let { pic -> it(pic) }
                  }
              }

          }
      }

  }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo=getItem(position)

        holder.bind(photo)
    }
    override fun getItemViewType(position : Int) : Int
    {
        return position
    }

    private var onItemClickListener : ((Wallpaper) -> Unit?)? = null

    fun setOnItemClickListener(listener : (Wallpaper) -> Unit)
    {
        onItemClickListener = listener
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        binding=ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder()
    }
    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<Wallpaper>() {
            override fun areItemsTheSame(oldItem: Wallpaper , newItem: Wallpaper): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Wallpaper , newItem: Wallpaper): Boolean {
                return oldItem == newItem
            }
        }
    }


}
