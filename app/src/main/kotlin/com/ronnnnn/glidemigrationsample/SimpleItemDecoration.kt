package com.ronnnnn.glidemigrationsample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView

/**
 * Created by kokushiseiya on 2017/06/17.
 */
class SimpleItemDecoration(private val context: Context, @ColorRes private val colorId: Int, private val margin: Int = 0) : RecyclerView.ItemDecoration() {

    private val dividerHeight: Int = context.resources.getDimensionPixelSize(R.dimen.divider_height)
    private val dividerPaint: Paint = Paint().apply {
        color = ContextCompat.getColor(context, colorId)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val left: Float = parent.paddingLeft.toFloat()
        val right: Float = left + parent.width

        (0..parent.childCount - 1).forEach { index ->
            parent.getChildAt(index)?.let {
                val bottom: Float = it.bottom.toFloat()
                val dividerStart = left + margin
                val dividerEnd = right - margin

                if (dividerStart < dividerEnd) {
                    c.drawRect(dividerStart, bottom, dividerEnd, bottom + dividerHeight, dividerPaint)
                } else {
                    c.drawRect(left, bottom, right, bottom + dividerHeight, dividerPaint)
                }
            }
        }
    }
}