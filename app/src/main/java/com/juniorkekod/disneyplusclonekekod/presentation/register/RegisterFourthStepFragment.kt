package com.juniorkekod.disneyplusclonekekod.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentRegisterFourthStepBinding


class RegisterFourthStepFragment : Fragment() {

    private lateinit var binding: FragmentRegisterFourthStepBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterFourthStepBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        setListeners()
    }

    private fun setView() {
        val stepText = getString(R.string.key_step)

        val sb = StringBuilder()
        sb.append(stepText)
        sb.append(" 4/4")
        val result = sb.toString()

        binding.stepTextView.text = result
    }

    private fun setListeners() {
        binding.monthlyLayout.setOnClickListener {
            showCreditCardScreen("MONTHLY")
        }

        binding.annualLayout.setOnClickListener {
            showCreditCardScreen("ANNUAL")
        }
    }

    private fun showCreditCardScreen(type: String) {
        val action: NavDirections
        if (type == "MONTHLY") {
            action =
                RegisterFourthStepFragmentDirections.actionRegisterFourthStepFragmentToRegisterCreditCardFragment(
                    "MONTHLY"
                )

        } else {
            action =
                RegisterFourthStepFragmentDirections.actionRegisterFourthStepFragmentToRegisterCreditCardFragment(
                    "ANNUAL"
                )
        }
        findNavController().navigate(action)
    }

}