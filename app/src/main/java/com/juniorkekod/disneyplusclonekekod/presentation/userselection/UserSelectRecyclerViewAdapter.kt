package com.juniorkekod.disneyplusclonekekod.presentation.userselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.juniorkekod.disneyplusclonekekod.databinding.UserSelectItemBinding

class UserSelectRecyclerViewAdapter(
) : ListAdapter<UserSelectModel, UserSelectViewHolder>(UserSelectModelDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSelectViewHolder {
        val inf = LayoutInflater.from(parent.context)
        val binding = UserSelectItemBinding.inflate(inf, parent, false)
        return UserSelectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserSelectViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textViewUserName.text = item.userName

    }

    class UserSelectModelDiffCallBack : DiffUtil.ItemCallback<UserSelectModel>() {
        override fun areItemsTheSame(oldItem: UserSelectModel, newItem: UserSelectModel): Boolean {
            return oldItem.userName == newItem.userName;
        }

        override fun areContentsTheSame(
            oldItem: UserSelectModel,
            newItem: UserSelectModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}

class UserSelectViewHolder(var binding: UserSelectItemBinding) :
    RecyclerView.ViewHolder(binding.root)
