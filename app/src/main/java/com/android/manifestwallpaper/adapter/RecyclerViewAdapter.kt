package com.android.manifestwallpaper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.manifestwallpaper.R
import com.android.manifestwallpaper.databinding.ItemRecyclerviewBinding
import com.android.manifestwallpaper.model.Wallpaper
import com.android.manifestwallpaper.util.BlurHashDecoder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions

class RecyclerViewAdapter:PagingDataAdapter<Wallpaper,RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding=ItemRecyclerviewBinding.bind(view)



        fun bind(data: Wallpaper?){
            val blurHashAsDrawable=BlurHashDecoder.blurHashBitmap(itemView.resources,data)
            if (data != null) {
                Glide.with(itemView.context)
                    .asBitmap()
                    .load(data.urls.small)
                    .centerCrop()
                    .transition(BitmapTransitionOptions.withCrossFade(80))
                    //.error(R.drawable.ic_baseline_error_24)
                    .error(blurHashAsDrawable)
                    .placeholder(blurHashAsDrawable)
                    .into(binding.imageView)
            }
        }

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,parent,false)
        return MyViewHolder(inflater)
    }
    class DiffUtilCallBack:DiffUtil.ItemCallback<Wallpaper>(){

        override fun areItemsTheSame(oldItem: Wallpaper, newItem: Wallpaper): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Wallpaper, newItem: Wallpaper): Boolean {
            return oldItem == newItem
        }

    }
}