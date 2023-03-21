package com.juniorkekod.disneyplusclonekekod.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private var isSelectedCheckbox: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigatePage()
    }

    private fun navigatePage() {
        binding.continueButton.setOnClickListener {

            val emailAddressText = binding.emailText.text.toString()

            if (emailAddressText.isEmpty()) {
                Toast.makeText(requireContext(), R.string.warning_space_line, Toast.LENGTH_SHORT)
                    .show()

            } else if (!emailAddressText.contains('@')) {
                Toast.makeText(requireContext(), R.string.valid_email_address, Toast.LENGTH_SHORT)
                    .show()

            } else {
                val action = RegisterFragmentDirections.homeToMemberShipFragment(
                    emailAddressText, isSelectedCheckbox)
                findNavController().navigate(action)

            }
        }

        binding.selectedCheckbox.setOnCheckedChangeListener { _, isChecked ->
            isSelectedCheckbox = isChecked
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}