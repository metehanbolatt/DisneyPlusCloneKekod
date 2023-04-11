package com.juniorkekod.disneyplusclonekekod.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.DiscoverItemBinding

class DiscoverAdapter: RecyclerView.Adapter<DiscoverAdapter.DiscoverHolder>() {

    private var discoverList = listOf<DiscoverUIModel>()

    class DiscoverHolder(val binding: DiscoverItemBinding): RecyclerView.ViewHolder(binding.root)

    fun setDiscoverList(newDiscoverList: List<DiscoverUIModel>) {
        discoverList = newDiscoverList
        notifyItemRangeChanged(0, discoverList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverHolder {
        val binding = DiscoverItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiscoverHolder(binding)
    }

    override fun onBindViewHolder(holder: DiscoverHolder, position: Int) {
        val item = discoverList[position]
        holder.binding.discoverImage.setImageDrawable(ContextCompat.getDrawable(holder.binding.discoverImage.context, item.discoverImage))
    }

    override fun getItemCount() = discoverList.size
}