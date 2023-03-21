package com.juniorkekod.disneyplusclonekekod.presentation.userselection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentUserSelectBinding


class UserSelectFragment : Fragment() {

    private lateinit var binding: FragmentUserSelectBinding
    private val viewModel by activityViewModels<UserSelectViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserSelectBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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