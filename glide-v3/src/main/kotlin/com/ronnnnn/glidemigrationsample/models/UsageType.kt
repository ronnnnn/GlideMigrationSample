package com.ronnnnn.glidemigrationsample.models

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.animation.ViewPropertyAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.ronnnnn.glidemigrationsample.R
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation
import java.io.Serializable

/**
 * Created by kokushiseiya on 2017/06/17.
 */
enum class UsageType(val contentType: ContentType, mdFileName: String) : Serializable {
    BasicUsage(ContentType.Photo, "v3_basic_usage.md"),
    Placeholder(ContentType.Photo, "v3_placeholder.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    Error(ContentType.Photo, "v3_error.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error)
                    .into(imageView)
        }
    },
    CrossFade(ContentType.Photo, "v3_cross_fade.md") {
        // same behavior with "Placeholder" section
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .crossFade()
                    .into(imageView)
        }
    },
    CrossFadeWithDuration(ContentType.Photo, "v3_cross_fade_with_duration.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .crossFade(1000) // default duration is 300
                    .into(imageView)
        }
    },
    NotAnimate(ContentType.Photo, "v3_not_animate.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .dontAnimate()
                    .into(imageView)
        }
    },
    Resize(ContentType.Photo, "v3_resize.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .override(200, 200) // resize image (in pixel) not ImageView before displaying in the target
                    .into(imageView)
        }
    },
    CenterCrop(ContentType.Photo, "v3_center_crop.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .centerCrop()
                    .into(imageView)
        }
    },
    FitCenter(ContentType.Photo, "v3_fit_center.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .fitCenter()
                    .into(imageView)
        }
    },
    Gif(ContentType.Gif, "v3_gif.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    GifOnly(ContentType.Gif, "v3_gif_only.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .asGif()
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error) // this error will be called the source is not gif
                    .into(imageView)
        }
    },
    FastLoadGif(ContentType.Gif, "v3_fast_load_gif.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageView)
        }
    },
    GifAsBitmap(ContentType.Gif, "v3_gif_as_bitmap.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .asBitmap() // gif will show as a regular image even if the url ends with .gif
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    NoMemoryCache(ContentType.Photo, "v3_no_memory_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .skipMemoryCache(true) // default is false
                    .into(imageView)
        }
    },
    NoDiskCache(ContentType.Photo, "v3_no_disk_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.NONE) // default is RESULT
                    .into(imageView)
        }
    },
    NoCache(ContentType.Photo, "v3_no_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(imageView)
        }
    },
    CacheOriginalImage(ContentType.Photo, "v3_cache_original_image.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageView)
        }
    },
    ImageRequestPriority(ContentType.Photo, "v3_image_request_priority.md"),
    BitmapTarget(ContentType.Photo, "v3_bitmap_target.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            val target = object : SimpleTarget<Bitmap>() {
                override fun onLoadStarted(placeholder: Drawable?) {
                    imageView.setImageDrawable(placeholder)
                }

                override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                    Palette.from(resource).generate { palette ->
                        val color = palette?.getVibrantColor(ContextCompat.getColor(context, R.color.color_primary))
                                ?: ContextCompat.getColor(context, R.color.color_primary)
                        imageView.setImageBitmap(resource)
                        imageView.setColorFilter(color)
                    }
                }
            }

            Glide.with(context)
                    .load(imageString)
                    .asBitmap()
                    .placeholder(R.drawable.image_placeholder)
                    .into(target)
        }
    },
    SpecificSizeTarget(ContentType.Photo, "v3_specific_size_target.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            val target = object : SimpleTarget<Bitmap>(200, 200) {
                override fun onLoadStarted(placeholder: Drawable?) {
                    imageView.setImageDrawable(placeholder)
                }

                override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                    imageView.setImageBitmap(resource)
                }
            }

            Glide.with(context)
                    .load(imageString)
                    .asBitmap()
                    .placeholder(R.drawable.image_placeholder)
                    .into(target)
        }
    },
    CustomTransformation(ContentType.Photo, "v3_custom_transformation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .bitmapTransform(BlurTransformation(context, 10))
                    .into(imageView)
        }
    },
    MultiTransformations(ContentType.Photo, "v3_multi_transformation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .bitmapTransform(GrayscaleTransformation(context), BlurTransformation(context, 10))
                    .into(imageView)
        }
    },
    SlideInAnimation(ContentType.Photo, "v3_slide_in_animation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .animate(android.R.anim.slide_in_left)
                    .into(imageView)
        }
    },
    ZoomInAnimation(ContentType.Photo, "v3_zoom_in_animation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .animate(R.anim.zoom_in)
                    .into(imageView)
        }
    },
    CustomClassAnimation(ContentType.Photo, "v3_custom_class_animation.md") {
        val animationObject = ViewPropertyAnimation.Animator { view ->
            view.alpha = 0f

            val fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
            fadeAnim.duration = 3000
            fadeAnim.start()
        }

        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .animate(animationObject) // this animation affect not only ImageView but also whole View
                    .into(imageView)
        }
    },
    ShapeImageViewWithBadPractice(ContentType.Photo, "v3_shape_image_view_with_bad_practice.md"),
    ShapeImageViewWithGoodPractice(ContentType.Photo, "v3_shape_image_view_with_good_practice.md")
    ;

    open fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
        Glide.with(context)
                .load(imageString)
                .into(imageView)
    }
}