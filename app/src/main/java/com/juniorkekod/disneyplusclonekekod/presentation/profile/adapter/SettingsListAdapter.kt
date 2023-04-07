package com.juniorkekod.disneyplusclonekekod.presentation.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.AdapterProfileSettingsItemBinding

class SettingsListAdapter : RecyclerView.Adapter<SettingsListAdapter.SettingsViewHolder>() {
    private val settingsList = mutableListOf<String>()
    private var settingsClick : (() -> Unit )? = null
    fun updateList(newList : List<String>){
        settingsList.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }
    fun settingsListClickItem(settingsClick : (() -> Unit)?){
        this.settingsClick = settingsClick
    }
    class SettingsViewHolder(private val binding : AdapterProfileSettingsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title : String,settingsClick: (() -> Unit)?){
            //TODO Model belirlendiğinde düzeltilecek
            binding.adapterProfileSettingsTitleTv.text = title
            binding.root.setOnClickListener {
                settingsClick?.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val binding = AdapterProfileSettingsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SettingsViewHolder(binding)
    }

    override fun getItemCount(): Int = settingsList.size

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        holder.bind(settingsList[position],settingsClick)
    }
}