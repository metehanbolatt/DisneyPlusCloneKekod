package com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentRecommendedBinding
import com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout.adapter.MovieAdapter
import com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout.adapter.MovieData

class RecommendedFragment : Fragment() {


    private var _binding: FragmentRecommendedBinding? = null
    private val binding get() = _binding!!
    private lateinit var movies: List<MovieData>

    private val adapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dummyData()
        initialAdapter()
    }

    private fun dummyData() {
        movies = listOf(
            MovieData("https://images8.alphacoders.com/106/1065658.jpg"),
            MovieData("https://images8.alphacoders.com/106/1065658.jpg"),
            MovieData("https://images3.alphacoders.com/103/1036824.jpg"),
            MovieData("https://images3.alphacoders.com/103/1036824.jpg"),
            MovieData("https://images3.alphacoders.com/103/1036824.jpg"),
            MovieData("https://images3.alphacoders.com/103/1036824.jpg"),
            MovieData("https://images3.alphacoders.com/103/1036824.jpg")
        )
    }

    private fun initialAdapter() {
        binding.apply {
            movieRecylerView.adapter = adapter
            adapter.updateItems(movies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}