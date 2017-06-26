package com.ronnnnn.glidemigrationsample_glidev4.models

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.widget.ImageView
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.ViewPropertyTransition
import com.ronnnnn.glidemigrationsample_glidev4.GlideApp
import com.ronnnnn.glidemigrationsample_glidev4.R
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation
import java.io.Serializable

/**
 * Created by kokushiseiya on 2017/06/17.
 */
enum class UsageType(val contentType: ContentType, val mdFileName: String) : Serializable {
    BasicUsage(ContentType.Photo, "v4_basic_usage.md"),
    Placeholder(ContentType.Photo, "v4_placeholder.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    Error(ContentType.Photo, "v4_error.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error)
                    .into(imageView)
        }
    },
    CrossFade(ContentType.Photo, "v4_cross_fade.md") {
        // same behavior with "Placeholder" section
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView)
        }
    },
    CrossFadeWithDuration(ContentType.Photo, "v4_cross_fade_with_duration.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade(1000)) // default duration is 300
                    .into(imageView)
        }
    },
    NotAnimate(ContentType.Photo, "v4_not_animate.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .dontAnimate()
                    .into(imageView)
        }
    },
    Resize(ContentType.Photo, "v4_resize.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .override(200, 200) // resize image (in pixel) not ImageView before displaying in the target
                    .into(imageView)
        }
    },
    CenterCrop(ContentType.Photo, "v4_center_crop.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .centerCrop()
                    .into(imageView)
        }
    },
    FitCenter(ContentType.Photo, "v4_fit_center.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .fitCenter()
                    .into(imageView)
        }
    },
    Gif(ContentType.Gif, "v4_gif.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    GifOnly(ContentType.Gif, "v4_gif_only.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .asGif()
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error) // this error will be called the source is not gif
                    .into(imageView)
        }
    },
    FastLoadGif(ContentType.Gif, "v4_fast_load_gif.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(imageView)
        }
    },
    GifAsBitmap(ContentType.Gif, "v4_gif_as_bitmap.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .asBitmap() // gif will show as a regular image even if the url ends with .gif
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    NoMemoryCache(ContentType.Photo, "v4_no_memory_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .skipMemoryCache(true) // default is false
                    .into(imageView)
        }
    },
    NoDiskCache(ContentType.Photo, "v4_no_disk_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.NONE) // default is RESULT
                    .into(imageView)
        }
    },
    NoCache(ContentType.Photo, "v4_no_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(imageView)
        }
    },
    CacheOriginalImage(ContentType.Photo, "v4_cache_original_image.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(imageView)
        }
    },
    ImageRequestPriority(ContentType.Photo, "v4_image_request_priority.md"),
    BitmapTarget(ContentType.Photo, "v4_bitmap_target.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            val target = object : SimpleTarget<Bitmap>() {
                override fun onLoadStarted(placeholder: Drawable?) {
                    imageView.setImageDrawable(placeholder)
                }

                override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                    Palette.from(resource).generate { palette ->
                        val color = palette?.getVibrantColor(ContextCompat.getColor(context, R.color.color_primary))
                                ?: ContextCompat.getColor(context, R.color.color_primary)
                        imageView.setImageBitmap(resource)
                        imageView.setColorFilter(color)
                    }
                }
            }

            GlideApp.with(context)
                    .asBitmap()
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(target)
        }
    },
    SpecificSizeTarget(ContentType.Photo, "v4_specific_size_target.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            val target = object : SimpleTarget<Bitmap>(200, 200) {
                override fun onLoadStarted(placeholder: Drawable?) {
                    imageView.setImageDrawable(placeholder)
                }

                override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                    imageView.setImageBitmap(resource)
                }
            }

            GlideApp.with(context)
                    .asBitmap()
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(target)
        }
    },
    CustomTransformation(ContentType.Photo, "v4_custom_transformation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transform(BlurTransformation(10))
                    .into(imageView)
        }
    },
    MultiTransformations(ContentType.Photo, "v4_multi_transformations.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transform(MultiTransformation(GrayscaleTransformation(), BlurTransformation(10)))
                    .into(imageView)
        }
    },
    SlideInAnimation(ContentType.Photo, "v4_slide_in_animation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions().transition(android.R.anim.slide_in_left))
                    .into(imageView)
        }
    },
    ZoomInAnimation(ContentType.Photo, "v4_zoom_in_animation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions().transition(R.anim.zoom_in))
                    .into(imageView)
        }
    },
    CustomClassAnimation(ContentType.Photo, "v4_custom_class_animation.md") {
        val animationObject = ViewPropertyTransition.Animator { view ->
            view.alpha = 0f

            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).apply {
                duration = 300
            }.start()
        }

        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions().transition(animationObject)) // this animation affect not only ImageView but also whole View
                    .into(imageView)
        }
    },
    ShapeImageViewWithBadPractice(ContentType.Photo, "v4_shape_image_view_with_bad_practice.md"),
    ShapeImageViewWithGoodPractice(ContentType.Photo, "v4_shape_image_view_with_good_practice.md"),
    TransparentImageWithBadPractice(ContentType.Photo, "v4_transparent_image_with_bad_practice.md"),
    TransparentImageWithGoodPractice(ContentType.Photo, "v4_transparent_image_with_good_practice.md")
    ;

    open fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
        GlideApp.with(context)
                .load(imageString)
                .into(imageView)
    }
}