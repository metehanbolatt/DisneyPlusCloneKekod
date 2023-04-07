package com.juniorkekod.disneyplusclonekekod.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater : (inflater : LayoutInflater) -> VB
) : Fragment(){

    private var _binding : VB? = null
    protected val binding : VB get() = _binding as VB

    protected abstract fun setListeners()
    protected abstract fun setObserve()
    open fun setAdapter(){}
    open fun setInitialize(){}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObserve()
        setAdapter()
        setInitialize()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}