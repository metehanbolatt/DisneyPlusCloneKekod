package com.juniorkekod.disneyplusclonekekod.presentation.onetimepassword.component

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.InputType
import android.text.TextPaint
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.juniorkekod.disneyplusclonekekod.R


class OneTimePasswordEdittext @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {
    private var mSpace = 24f
    private var mNumChars = 4f
    private var mLineSpacing = 8f
    private var mClickListener: OnClickListener? = null
    private var mLineStroke = 1f
    private var mLineStrokeSelected = 2f

    //Paint
    private var circleEmptyPaint: TextPaint? = null
    private var rectBackgroundPaint: TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL_AND_STROKE
        textSize = textSize
        color = ContextCompat.getColor(context, R.color.otp_rect_background_gray)
    }
    private val linePaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.otp_focused_line_blue)
        strokeWidth = mLineStrokeSelected
    }
    private var circleEnteredPaint: TextPaint? = null
    private var focusedRectPaint: TextPaint = TextPaint().apply {
        style = Paint.Style.FILL_AND_STROKE
        textSize = textSize
        color = ContextCompat.getColor(context, R.color.otp_rect_focused_background_gray)
    }

    private var textWidths = FloatArray(4)

    private var onInputDigitsListener : ((String) -> Unit)? = null
    companion object {
        private const val MAX_LENGTH = "maxLength"
        private const val XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android"
    }

    init {
        val multi = context.resources.displayMetrics.density
        mLineStroke *= multi
        mLineStrokeSelected *= multi
        mSpace *= multi
        mLineSpacing *= multi
        minHeight = 100
        //Paint
        circleEmptyPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            density = multi
            style = Paint.Style.FILL
            textSize = textSize
            color = ContextCompat.getColor(context, R.color.otp_empty_circle_gray)
        }
        circleEnteredPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            density = multi
            style = Paint.Style.FILL
            textSize = textSize
            color = ContextCompat.getColor(context, R.color.otp_entered_circle_gray)
        }


        //maxLength
        val mMaxLength = attrs?.getAttributeIntValue(XML_NAMESPACE_ANDROID, MAX_LENGTH, 4)
        textWidths = mMaxLength?.let { FloatArray(it) }!!
        mNumChars = mMaxLength.toFloat()

        setBackgroundResource(0)
        inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
        DigitsKeyListener.getInstance("1234567890")
        isFocusable = true
        setTextIsSelectable(false)
        super.setOnClickListener { view ->
            setSelection(text!!.length)
            mClickListener?.let {
                mClickListener?.onClick(view)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val minHeight = (100 * resources.displayMetrics.density).toInt()
        setMeasuredDimension(measuredWidth, maxOf(minHeight, measuredHeight))
    }

    override fun setOnClickListener(l: OnClickListener?) {
        mClickListener = l
    }

    override fun onDraw(canvas: Canvas?) {
        val availableWidth = width - paddingRight - paddingLeft
        val mCharSize: Float = (availableWidth - mSpace * (mNumChars - 1)) / mNumChars
        var startX = paddingLeft
        val bottom = height - paddingBottom
        val text = text
        val textLength = text!!.length
        paint.getTextWidths(getText(), 0, textLength, textWidths)

        var i = 0
        while (i < mNumChars) {
            val middle = startX + mCharSize / 2
            //Rect
            canvas?.drawRoundRect(
                middle - (mCharSize / 2),
                ((bottom - mLineSpacing) / 2) - (mCharSize / 2),
                middle + (mCharSize / 2),
                ((bottom - mLineSpacing) / 2) + (mCharSize / 2),
                5f,
                5f,
                rectBackgroundPaint
            )
            //Empty Circle
            canvas?.drawCircle(
                middle,
                (bottom - mLineSpacing) / 2,
                mCharSize / 8,
                circleEmptyPaint!!
            )
            if (isFocused && i == getText()!!.length) {
                canvas?.drawRoundRect(
                    middle - (mCharSize / 2),
                    ((bottom - mLineSpacing) / 2) - (mCharSize / 2),
                    middle + (mCharSize / 2),
                    ((bottom - mLineSpacing) / 2) + (mCharSize / 2),
                    5f,
                    5f,
                    focusedRectPaint
                )
                canvas?.drawCircle(
                    middle,
                    (bottom - mLineSpacing) / 2,
                    mCharSize / 8,
                    circleEmptyPaint!!
                )
                val heightLine = height - (((bottom - mLineSpacing) / 2) - (mCharSize / 8))
                canvas?.drawLine(
                    middle - (mCharSize / 8),
                    heightLine,
                    middle + (mCharSize / 8),
                    heightLine,
                    linePaint
                )
            }
            if (getText()!!.length > i) {
                canvas?.drawCircle(
                    middle,
                    (bottom - mLineSpacing) / 2,
                    mCharSize / 8,
                    circleEnteredPaint!!
                )
            }
            startX += (mCharSize + mSpace).toInt()
            i++
        }
    }

    fun setOnInputDigitsListener(listener :(String) -> Unit ){
        onInputDigitsListener = listener
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (text?.length == 4){
            onInputDigitsListener?.invoke(text.toString())
        }
    }
}