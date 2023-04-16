package com.juniorkekod.disneyplusclonekekod.presentation.common

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.juniorkekod.disneyplusclonekekod.R

fun Context.userInfo(
    @StringRes message: Int,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(
        this, getString(message),
        duration
    ).show()
}

fun TextView.clickableText(
    @StringRes resString: Int,
    context: Context,
    clickHighOrder: () -> Unit
) {
    val resourceString = context.getString(resString)
    val spannable = SpannableString(resourceString)
    val clickable : ClickableSpan = object : ClickableSpan(){
        override fun onClick(widget: View) {
            clickHighOrder.invoke()
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.color = ContextCompat.getColor(context, R.color.otp_clickable_span_tv)
            ds.isUnderlineText = false
        }
    }
    spannable.setSpan(
        clickable,
        0,
        resourceString.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    this.text = spannable
    this.movementMethod = LinkMovementMethod.getInstance()
}

fun AppCompatImageView.downloadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}

fun View.invisible() { this.isVisible = false }
fun View.visible() { this.isVisible = true }