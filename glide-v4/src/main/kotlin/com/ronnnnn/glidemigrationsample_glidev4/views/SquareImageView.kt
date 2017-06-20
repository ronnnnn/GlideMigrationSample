package com.ronnnnn.glidemigrationsample_glidev4.views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by kokushiseiya on 2017/06/17.
 */
class SquareImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0) : ImageView(context, attrs, defStyleAttr, defStyleRes) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(measuredWidth, measuredWidth)
    }
}