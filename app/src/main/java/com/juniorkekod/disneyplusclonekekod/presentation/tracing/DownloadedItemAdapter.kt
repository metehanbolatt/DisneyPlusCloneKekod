package com.juniorkekod.disneyplusclonekekod.presentation.tracing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.ItemDownloadedMovieBinding
import com.juniorkekod.disneyplusclonekekod.databinding.ItemDownloadedSeriesBinding
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadableVideos
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedMovies
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.DownloadedSeries
import com.juniorkekod.disneyplusclonekekod.presentation.tracing.models.VideosType

class DownloadedItemAdapter(private var downloadedVideosList: List<DownloadableVideos>) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var bindingMovies: ItemDownloadedMovieBinding
    private lateinit var bindingSeries: ItemDownloadedSeriesBinding

    inner class DownloadedMoviesViewHolder(binding: ItemDownloadedMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class DownloadedSeriesViewHolder(binding: ItemDownloadedSeriesBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VideosType.MOVIE.value -> {
                bindingMovies = ItemDownloadedMovieBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                DownloadedMoviesViewHolder(bindingMovies)
            }
            VideosType.SERIES.value -> {
                bindingSeries = ItemDownloadedSeriesBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                DownloadedSeriesViewHolder(bindingSeries)
            }
            else -> {
                bindingMovies = ItemDownloadedMovieBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                DownloadedMoviesViewHolder(bindingMovies)
            }
        }
    }

    override fun getItemCount(): Int {
        return downloadedVideosList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (downloadedVideosList[position]) {
            is DownloadedMovies -> {
                bindingMovies.apply {
                    ImageViewDownloadedMovieImage.setImageDrawable(downloadedVideosList[position].image)
                    textViewDownloadedMovieName.text = downloadedVideosList[position].name
                    textViewDownloadedMovieDetail.text =
                        downloadedVideosList[position].name // TODO (Ahmet) ---> This part will be edited with string inputs (size, time).
                    progressBarDownloadedMovieProgress.progress =
                        downloadedVideosList[position].watchProgress ?: 0
                }
            }
            is DownloadedSeries -> {
                bindingSeries.apply {
                    imageViewDownloadedImage.setImageDrawable(downloadedVideosList[position].image)
                    textViewDownloadedName.text = downloadedVideosList[position].name
                    textViewDownloadedSeriesDetail.text =
                        downloadedVideosList[position].name // TODO (Ahmet) ---> This part will be edited with string inputs (size, episodeNumber, time).
                    progressBarDownloadedSeriesProgress.progress =
                        downloadedVideosList[position].watchProgress ?: 0
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (downloadedVideosList[position]) {
            is DownloadedMovies -> VideosType.MOVIE.value
            is DownloadedSeries -> VideosType.SERIES.value
            else -> VideosType.MOVIE.value
        }
    }

    // TODO (Ahmet) ---> Swipe-to-Delete feature will be added.

}
