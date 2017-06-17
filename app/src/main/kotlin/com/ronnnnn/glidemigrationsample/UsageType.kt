package com.ronnnnn.glidemigrationsample

import android.content.Context
import android.widget.ImageView
import com.ronnnnn.glidemigrationsample.extentions.loadImage
import java.io.Serializable

/**
 * Created by kokushiseiya on 2017/06/17.
 */
enum class UsageType: Serializable {
    BasicUsage
    ;

    open fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
        imageView.loadImage(context, imageString)
    }
}