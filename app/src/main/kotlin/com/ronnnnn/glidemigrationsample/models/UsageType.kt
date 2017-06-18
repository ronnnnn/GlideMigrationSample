package com.ronnnnn.glidemigrationsample.models

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ronnnnn.glidemigrationsample.R
import java.io.Serializable

/**
 * Created by kokushiseiya on 2017/06/17.
 */
enum class UsageType : Serializable {
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
    },
    CrossFade {
        // same behavior with "Placeholder" section
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .crossFade()
                    .into(imageView)
        }
    },
    CrossFadeWithDuration {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .crossFade(1000) // default duration is 300
                    .into(imageView)
        }
    },
    NotAnimate {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .dontAnimate()
                    .into(imageView)
        }
    }
    ;

    open fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
        Glide.with(context)
                .load(imageString)
                .into(imageView)
    }
}