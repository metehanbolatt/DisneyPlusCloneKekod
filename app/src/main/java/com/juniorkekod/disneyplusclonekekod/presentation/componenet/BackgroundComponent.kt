package com.juniorkekod.disneyplusclonekekod.presentation.componenet

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.juniorkekod.disneyplusclonekekod.databinding.BackgroundLayoutBinding


class BackgroundComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attributeSet, defStyleAttr) {


    private val _binding =
        BackgroundLayoutBinding.inflate(LayoutInflater.from(context), this, false)

    init {

        addView(_binding.root)

    }
}
