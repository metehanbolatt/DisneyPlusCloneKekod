package com.juniorkekod.disneyplusclonekekod.presentation.onetimepassword.component

import android.content.Context
import android.util.AttributeSet
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView
import com.juniorkekod.disneyplusclonekekod.R

class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {
        init {
            outlineProvider = ViewOutlineProvider.BACKGROUND
            clipToOutline = true
            setBackgroundResource(R.drawable.circle_background_iv)
            scaleType = ScaleType.CENTER_CROP
        }
}