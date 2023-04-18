package com.juniorkekod.disneyplusclonekekod.presentation.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentMovieDetailBinding
import com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout.ViewPagerAdapter

class MovieDetailFragment : Fragment(){

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { ViewPagerAdapter(this) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialAdapter()
        createTabLayout()
    }

    private fun initialAdapter() {
        binding.apply {
            viewPager.adapter = adapter
        }
    }

    private fun createTabLayout() {

        binding.apply {
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->

                when (position) {
                    0 -> tab.text = getString(R.string.recommended)

                    1 -> tab.text = getString(R.string.particulars)

                    else -> tab.text = "Sayfa 1"
                }
            }.attach()
        }
    }


}