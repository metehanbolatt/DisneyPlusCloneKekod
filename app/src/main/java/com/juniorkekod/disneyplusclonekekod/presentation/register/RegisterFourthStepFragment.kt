package com.juniorkekod.disneyplusclonekekod.presentation.register

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
        val countText = "4"

        val combinedStepCount = getString(
            R.string.key_step_count,
            stepText,
            countText
        )

        binding.stepTextView.text = combinedStepCount

        //MONTHLY TEXT
        val monthlyPriceText = getString(R.string.key_campaign_monthly)
        val monthText = getString(R.string.key_register_month)
        val combinedMonthlyText = getString(
            R.string.key_purchase_type,
            monthlyPriceText,
            monthText
        )

        setYearAndMonthColor(
            combinedMonthlyText,
            monthText,
            RegisterCreditCardFragment.PurchaseTypes.MONTHLY
        )

        //ANNUAL TEXT
        val annualPriceText = getString(R.string.key_campaign_annual)
        val yearText = getString(R.string.key_register_year)
        val combinedYearlyText = getString(
            R.string.key_purchase_type,
            annualPriceText,
            yearText
        )

        setYearAndMonthColor(
            combinedYearlyText,
            yearText,
            RegisterCreditCardFragment.PurchaseTypes.ANNUAL
        )
    }

    private fun setListeners() {
        binding.monthlyTextView.setOnClickListener {
            showCreditCardScreen(RegisterCreditCardFragment.PurchaseTypes.MONTHLY)
        }

        binding.annualTextView.setOnClickListener {
            showCreditCardScreen(RegisterCreditCardFragment.PurchaseTypes.ANNUAL)
        }
    }

    private fun setYearAndMonthColor(
        combinedText: String,
        coloredText: String,
        type: RegisterCreditCardFragment.PurchaseTypes
    ) {
        val colorOfText = ContextCompat.getColor(requireContext(), R.color.white_45_opacity)

        val startingIndexOfText = combinedText.indexOf(coloredText)
        val endingIndexOfText = combinedText.length

        if (type == RegisterCreditCardFragment.PurchaseTypes.MONTHLY) {
            binding.monthlyTextView.text = SpannableStringBuilder(combinedText).apply {
                setSpan(
                    ForegroundColorSpan(colorOfText),
                    startingIndexOfText,
                    endingIndexOfText,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }

        if (type == RegisterCreditCardFragment.PurchaseTypes.ANNUAL) {
            binding.annualTextView.text = SpannableStringBuilder(combinedText).apply {
                setSpan(
                    ForegroundColorSpan(colorOfText),
                    startingIndexOfText,
                    endingIndexOfText,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
    }

    private fun showCreditCardScreen(type: RegisterCreditCardFragment.PurchaseTypes) {
        val action: NavDirections
        if (type == RegisterCreditCardFragment.PurchaseTypes.MONTHLY) {
            action =
                RegisterFourthStepFragmentDirections.actionRegisterFourthStepFragmentToRegisterCreditCardFragment(
                    RegisterCreditCardFragment.PurchaseTypes.MONTHLY
                )

        } else {
            action =
                RegisterFourthStepFragmentDirections.actionRegisterFourthStepFragmentToRegisterCreditCardFragment(
                    RegisterCreditCardFragment.PurchaseTypes.ANNUAL
                )
        }
        findNavController().navigate(action)
    }

}