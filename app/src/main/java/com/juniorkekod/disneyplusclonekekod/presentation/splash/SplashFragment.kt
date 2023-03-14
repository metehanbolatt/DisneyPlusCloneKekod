package com.juniorkekod.disneyplusclonekekod.presentation.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentSplashBinding


class SplashFragment : Fragment(com.juniorkekod.disneyplusclonekekod.R.layout.fragment_splash) {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSplashBinding.inflate(layoutInflater)

        binding.layout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.bg_fade_out_splash))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delay()
    }

    private fun delay() {

        val timer = object : CountDownTimer(3000, 50) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                findNavController().navigate(R.id.action_splashFragment_to_firstLoginFragment)
            }

        }
        timer.start()
    }
}