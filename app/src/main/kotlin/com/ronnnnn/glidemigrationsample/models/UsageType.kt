package com.ronnnnn.glidemigrationsample.models

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.extentions.loadImage
import java.io.Serializable

/**
 * Created by kokushiseiya on 2017/06/17.
 */
enum class UsageType: Serializable {
    BasicUsage,
    Placeholder {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    Error {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error)
                    .into(imageView)
        }
    }
    ;

    open fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
        imageView.loadImage(context, imageString)
    }
}