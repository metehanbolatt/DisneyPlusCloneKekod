package com.juniorkekod.disneyplusclonekekod.presentation.userselection

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.juniorkekod.disneyplusclonekekod.base.BaseFragment
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentUserSelectBinding

class UserSelectFragment : BaseFragment<FragmentUserSelectBinding>(
    FragmentUserSelectBinding::inflate
) {
    private val viewModel by activityViewModels<UserSelectViewModel>()

    override fun setListeners() {

    }

    override fun setObserve() {
        observeListener()

    }


    private fun setAdapter(list: List<UserSelectModel>) {
        val manager = FlexboxLayoutManager(requireContext())
        manager.apply {
            justifyContent = JustifyContent.CENTER
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.FLEX_END
        }

        val adapter = UserSelectRecyclerViewAdapter()

        binding.recyclerViewUserSelectList.layoutManager = manager
        binding.recyclerViewUserSelectList.adapter = adapter
        adapter.submitList(list)
    }

    private fun observeListener() {
        viewModel.getUserList()
        lifecycleScope.launchWhenCreated {
            viewModel.userList.collect{ response ->
                response?.let {
                    setAdapter(it)
                }
            }
        }
    }

}