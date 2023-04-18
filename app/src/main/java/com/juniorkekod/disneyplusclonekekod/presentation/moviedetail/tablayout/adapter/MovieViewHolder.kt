package com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout.adapter

import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.MovieItemBinding
import com.juniorkekod.disneyplusclonekekod.presentation.common.downloadImage

class MovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: MovieData){
        binding.apply {
         movieImage.downloadImage(data.backgroundImage)
        }
    }
}