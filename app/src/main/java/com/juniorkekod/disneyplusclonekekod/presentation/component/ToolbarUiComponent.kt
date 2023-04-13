package com.juniorkekod.disneyplusclonekekod.presentation.component

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.juniorkekod.disneyplusclonekekod.R
import com.juniorkekod.disneyplusclonekekod.databinding.LayoutToolbarBinding

class ToolbarUiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding = LayoutToolbarBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setToolbarBackgroundColor(isVisible: Boolean) {
        if (isVisible) {
            binding.customViewToolbar.background =
                ColorDrawable(ContextCompat.getColor(context, R.color.background_color))
        }
    }

    //Visibility
    fun setOnlyBackIconVisibility(isVisible: Boolean) {
        isVisible.also { binding.toolbarBackIcon.isVisible = it }
    }

    fun setOnlyCancelIconVisibility(isVisible: Boolean) {
        binding.toolbarCancelIcon.isVisible = isVisible
    }

    fun setOnlyTitleVisibility(isVisible: Boolean) {
        binding.toolbarTitle.isVisible = isVisible
    }

    fun setBackAndShareIconVisibility(isVisible: Boolean) {
        binding.toolbarBackIcon.isVisible = isVisible
        binding.toolbarShareIcon.isVisible = isVisible

    }

    fun setBackAndShareIconWithTitleVisibility(isVisible: Boolean) {
        binding.toolbarBackIcon.isVisible = isVisible
        binding.toolbarTitle.isVisible = isVisible
        binding.toolbarShareIcon.isVisible = isVisible

    }

    fun setBackIconWithTitleVisibility(isVisible: Boolean) {
        binding.toolbarBackIcon.isVisible = isVisible
        binding.toolbarTitle.isVisible = isVisible
    }

    fun setBackIconWithSubTitleVisibility(isVisible: Boolean) {
        binding.toolbarBackIcon.isVisible = isVisible
        binding.toolbarSubTitle.isVisible = isVisible
    }

    fun setTitleAndEndTitleVisibility(isVisible: Boolean) {
        binding.toolbarTitle.isVisible = isVisible
        binding.toolbarEndTitle.isVisible = isVisible
    }

    //Text
    fun setTitleText(toolbarTitle: String) {
        binding.toolbarTitle.text = toolbarTitle
    }

    fun setSubTitleText(toolbarSubTitle: String) {
        binding.toolbarSubTitle.text = toolbarSubTitle
    }

    fun setEndTitleText(toolbarEndTitle: String) {
        binding.toolbarEndTitle.text = toolbarEndTitle
    }
}