package com.juniorkekod.disneyplusclonekekod.presentation.moviedetail.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentParticularsBinding

class ParticularsFragment : Fragment() {


    private var _binding: FragmentParticularsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParticularsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}