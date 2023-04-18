package com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.MovieItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies  = mutableListOf<MovieData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(movieItemBinding)
    }

    fun updateItems(newMovies: List<MovieData>) {
        movies.apply {
            clear()
            addAll(newMovies)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movies[position])
    }
}