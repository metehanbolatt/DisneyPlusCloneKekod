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
        if (args.type == PurchaseTypes.ANNUAL) {
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
        } else {
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


        binding.paymentLayout.text = SpannableStringBuilder(combinedText).apply {
            setSpan(
                ForegroundColorSpan(colorOfText),
                startingIndexOfText,
                endingIndexOfText,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

    }

    enum class PurchaseTypes {
        ANNUAL,
        MONTHLY
    }

}