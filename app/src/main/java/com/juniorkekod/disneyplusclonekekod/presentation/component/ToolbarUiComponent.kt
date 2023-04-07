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
        isVisible.also { binding.toolbarCancelIcon.isVisible = it }
    }

    fun setOnlyTitleVisibility(isVisible: Boolean) {
        isVisible.also { binding.toolbarTitle.isVisible = it }
    }

    fun setBackAndShareIconVisibility(isVisible: Boolean) {
        isVisible.also {
            binding.toolbarBackIcon.isVisible = it
            binding.toolbarShareIcon.isVisible = it
        }
    }

    fun setBackAndShareIconWithTitleVisibility(isVisible: Boolean) {
        isVisible.also {
            binding.toolbarBackIcon.isVisible = it
            binding.toolbarTitle.isVisible = it
            binding.toolbarShareIcon.isVisible = it
        }
    }

    fun setBackIconWithTitleVisibility(isVisible: Boolean) {
        isVisible.also {
            binding.toolbarBackIcon.isVisible = it
            binding.toolbarTitle.isVisible = it
        }
    }

    fun setBackIconWithSubTitleVisibility(isVisible: Boolean) {
        isVisible.also {
            binding.toolbarBackIcon.isVisible = it
            binding.toolbarSubTitle.isVisible = it
        }
    }

    fun setTitleAndEndTitleVisibility(isVisible: Boolean) {
        isVisible.also {
            binding.toolbarTitle.isVisible = it
            binding.toolbarEndTitle.isVisible = it
        }
    }

    //Text
    fun setTitleText(string: String) {
        binding.toolbarTitle.text = string
    }

    fun setSubTitleText(string: String) {
        binding.toolbarSubTitle.text = string
    }

    fun setEndTitleText(string: String) {
        binding.toolbarEndTitle.text = string
    }
}