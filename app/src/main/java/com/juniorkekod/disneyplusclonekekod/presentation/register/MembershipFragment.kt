package com.juniorkekod.disneyplusclonekekod.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentMembershipBinding


class MembershipFragment : Fragment() {
    private var _binding: FragmentMembershipBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<MembershipFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMembershipBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigatePage()
    }

    private fun navigatePage() {
        binding.acceptAndContinueButton.setOnClickListener {

            val emailAddress = args.emailAddress
            val action = MembershipFragmentDirections.actionMembershipFragmentToCreatePasswordFragment(emailAddress,args.isSelectedCheckbox)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}