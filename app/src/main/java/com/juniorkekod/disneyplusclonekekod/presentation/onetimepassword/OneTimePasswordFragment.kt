package com.juniorkekod.disneyplusclonekekod.presentation.onetimepassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentOneTimePasswordBinding
import com.juniorkekod.disneyplusclonekekod.presentation.common.clickableText
import com.juniorkekod.disneyplusclonekekod.presentation.common.userInfo

class OneTimePasswordFragment : Fragment() {
    private var _binding: FragmentOneTimePasswordBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<OneTimePasswordViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOneTimePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners(){
        binding.otpPinCustomEt.setOnInputDigitsListener(::setOnInputListener)
        binding.otpForgotPinTv.clickableText(R.string.otp_forgot_pin_tv,requireContext(),::forgotOtpClick)
    }

    private fun setOnInputListener(value : String){
        val code = "1234"
        if (value == code) {
            //TODO pin dogru ise yapılacak
        } else {
            requireContext().userInfo(R.string.otp_pin_error_toast)
        }
    }

    private fun forgotOtpClick(){
        //TODO pin unuttum denildiginde yapılacak
    }
}
