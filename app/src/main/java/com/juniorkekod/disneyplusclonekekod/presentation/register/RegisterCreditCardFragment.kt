package com.juniorkekod.disneyplusclonekekod.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentRegisterCreditCardBinding


class RegisterCreditCardFragment : Fragment() {

    private lateinit var binding: FragmentRegisterCreditCardBinding
    private val args: RegisterCreditCardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterCreditCardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        if (args.type == "ANNUAL") {
            binding.amount.text = getString(R.string.key_campaign_annual)
            binding.type.text = getString(R.string.key_register_year)
        } else {
            binding.amount.text = getString(R.string.key_campaign_monthly)
            binding.type.text = getString(R.string.key_register_month)
        }
    }

}