package com.juniorkekod.disneyplusclonekekod.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.SearchHistoryItemBinding

class SearchHistoryAdapter: RecyclerView.Adapter<SearchHistoryAdapter.SearchHistoryViewHolder>() {

    private var searchHistoryList = listOf<String>()

    class SearchHistoryViewHolder(val binding: SearchHistoryItemBinding): RecyclerView.ViewHolder(binding.root)

    fun setSearchHistoryList(newSearchHistoryList: List<String>) {
        searchHistoryList = newSearchHistoryList
        notifyItemRangeChanged(0, searchHistoryList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder {
        val binding = SearchHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        val item = searchHistoryList[position]
        holder.binding.historyText.text = item
    }

    override fun getItemCount() = searchHistoryList.size
}