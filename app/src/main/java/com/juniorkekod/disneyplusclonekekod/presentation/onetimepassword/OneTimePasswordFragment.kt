package com.juniorkekod.disneyplusclonekekod.presentation.onetimepassword

import android.content.Context
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentOneTimePasswordBinding

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
        binding.otpPinCustomEt.setOnInputDigitsListener {
            val code = "1234"
            if (it == code) {
                //TODO pin dogru ise yapılacak
            } else {
                requireContext().userInfo(R.string.otp_pin_error_toast)
            }
        }
        clickableText(R.string.otp_forgot_pin_tv,::forgotOtpClick,binding.otpForgotPinTv)
    }

    private fun forgotOtpClick(){
        //TODO pin unuttum denildiginde yapılacak
    }

    private fun clickableText(
        @StringRes resString : Int,
        clickHighOrder : () -> Unit,
        clickText : TextView
    ){
        val resourceString = getString(resString)
        val spannable = SpannableString(resourceString)
        val clickable : ClickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
                clickHighOrder.invoke()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(requireContext(),R.color.otp_clickable_span_tv)
                ds.isUnderlineText = false
            }
        }
        spannable.setSpan(
            clickable,
            0,
            resourceString.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        clickText.text = spannable
        clickText.movementMethod = LinkMovementMethod.getInstance()
    }
}

fun Context.userInfo(
    @StringRes message: Int,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(
        this, getString(message),
        duration
    ).show()
}