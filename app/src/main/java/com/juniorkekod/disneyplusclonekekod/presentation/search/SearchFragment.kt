package com.juniorkekod.disneyplusclonekekod.presentation.search

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import com.juniorkekod.disneyplusclonekekod.base.BaseFragment
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val discoverAdapter by lazy { DiscoverAdapter() }
    private val searchHistoryAdapter by lazy { SearchHistoryAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindUI()
        backPressedControl()

    }

    private fun bindUI() {

        discoverAdapter.setDiscoverList(DummyDataForDiscover.dummyDiscoverList)
        binding.discoverRv.adapter = discoverAdapter

        searchHistoryAdapter.setSearchHistoryList(DummyDataForDiscover.dummyHistoryList)
        binding.searchHistoryRv.adapter = searchHistoryAdapter

        binding.searchBar.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                v.performClick()
            }
        }
    }

    private fun backPressedControl() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    binding.apply {
                        if (searchHistoryRv.isVisible) {
                            searchBar.performClick()
                            searchBar.clearFocus()
                        } else {
                            // TODO Geri Butonu Ne Yapması Gerekiyorsa Onu Yapacak.
                        }
                    }
                }
            })
    }

    override fun setListeners() {

    }

    override fun setObserve() {

    }

}