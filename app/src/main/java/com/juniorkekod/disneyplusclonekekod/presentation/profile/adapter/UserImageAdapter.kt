package com.juniorkekod.disneyplusclonekekod.presentation.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.AdapterProfileUserImageItemBinding

class UserImageAdapter : RecyclerView.Adapter<UserImageAdapter.UserImageViewHolder>() {
    private val userImageList = mutableListOf<Int>()

    fun updateList(newList : List<Int>){
        userImageList.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }
    class UserImageViewHolder(private val binding : AdapterProfileUserImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(@DrawableRes imageSrc : Int){
            //TODO Model belirlendiğinde düzeltilecek
            binding.adapterProfileUserIv.setImageDrawable(ContextCompat.getDrawable(binding.root.context,imageSrc))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserImageViewHolder {
        val binding = AdapterProfileUserImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserImageViewHolder(binding)
    }

    override fun getItemCount(): Int = userImageList.size

    override fun onBindViewHolder(holder: UserImageViewHolder, position: Int) {
       holder.bind(userImageList[position])
    }
}