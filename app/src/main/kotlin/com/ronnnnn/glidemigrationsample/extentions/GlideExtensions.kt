package com.ronnnnn.glidemigrationsample.extentions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by kokushiseiya on 2017/06/17.
 */
fun ImageView.loadImage(context: Context, imageUrl: String) {
    Glide.with(context)
            .load(imageUrl)
            .into(this)
}
