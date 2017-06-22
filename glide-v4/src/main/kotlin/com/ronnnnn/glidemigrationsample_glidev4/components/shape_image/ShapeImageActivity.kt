package com.ronnnnn.glidemigrationsample_glidev4.components.shape_image

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.ronnnnn.glidemigrationsample_glidev4.R
import com.ronnnnn.glidemigrationsample_glidev4.extentions.bindView
import com.ronnnnn.glidemigrationsample_glidev4.models.Photo
import com.ronnnnn.glidemigrationsample_glidev4.models.UsageType

/**
 * Created by kokushiseiya on 2017/06/20.
 */
class ShapeImageActivity : AppCompatActivity(), ShapeImagePresenter.ShapeImageView {

    companion object {
        private const val KEY_USAGE_TYPE = "key_usage_type"

        fun createIntetnt(context: Context, usageType: UsageType) =
                Intent(context, ShapeImageActivity::class.java).apply {
                    putExtra(KEY_USAGE_TYPE, usageType)
                }
    }

    private lateinit var presenter: ShapeImagePresenter
    private lateinit var circleImageView: ImageView
    private lateinit var diamondImageView: ImageView
    private lateinit var loadingProgress: ProgressBar

    private var usageType: UsageType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape_image)

        usageType = intent.getSerializableExtra(KEY_USAGE_TYPE) as? UsageType

        presenter = ShapeImagePresenter(this)

        circleImageView = bindView(R.id.circle_image_view)
        diamondImageView = bindView(R.id.diamond_image_view)
        loadingProgress = bindView(R.id.loading_progress_bar)

        presenter.loadRecentPhotos()
    }

    override fun toggleLoadingProgressVisibility(isVisible: Boolean) {
        loadingProgress.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

    override fun setImages(photoList: List<Photo>) {
        when (usageType) {
            UsageType.ShapeImageViewWithBadPractice -> {
                GlideApp.with(this)
                        .load(photoList[0].getPhotoUrl())
                        .placeholder(R.drawable.image_placeholder)
                        .transition(BitmapTransitionOptions.withCrossFade())
                        .into(circleImageView)

                GlideApp.with(this)
                        .load(photoList[1].getPhotoUrl())
                        .placeholder(R.drawable.image_placeholder)
                        .transition(BitmapTransitionOptions().transition(android.R.anim.fade_in))
                        .into(diamondImageView)
            }

            UsageType.ShapeImageViewWithGoodPractice -> {
                GlideApp.with(this)
                        .asBitmap()
                        .load(photoList[0].getPhotoUrl())
                        .placeholder(R.drawable.image_placeholder)
                        .transition(BitmapTransitionOptions().transition(android.R.anim.fade_in))
                        .into(circleImageView)

                GlideApp.with(this)
                        .asBitmap()
                        .load(photoList[1].getPhotoUrl())
                        .placeholder(R.drawable.image_placeholder)
                        .transition(BitmapTransitionOptions().transition((android.R.anim.fade_in)))
                        .into(diamondImageView)
            }
        }
    }
}