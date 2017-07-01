package com.ronnnnn.glidemigrationsample_glidev4.components.shape_image

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ronnnnn.glidemigrationsample_glidev4.GlideApp
import com.ronnnnn.glidemigrationsample_glidev4.R
import com.ronnnnn.glidemigrationsample_glidev4.extentions.bindView
import com.ronnnnn.glidemigrationsample_glidev4.extentions.finishActivityWithSlideOut
import com.ronnnnn.glidemigrationsample_glidev4.models.Photo
import com.ronnnnn.glidemigrationsample_glidev4.models.UsageType
import com.ronnnnn.glidemigrationsample_glidev4.views.MarkdownBottomSheetView

/**
 * Created by kokushiseiya on 2017/06/20.
 */
class ShapeImageActivity : AppCompatActivity(), ShapeImagePresenter.ShapeImageView {

    companion object {
        private const val KEY_USAGE_TYPE = "key_usage_type"
        private const val INITIAL_ALPHA = 0.8f

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

        initializeViews()

        presenter.loadRecentPhotos()
    }

    private fun initializeViews() {
        bindView<Toolbar>(R.id.toolbar).run {
            usageType?.let { title = it.title }
            setTitleTextColor(Color.WHITE)
        }
        circleImageView = bindView(R.id.circle_image_view)
        diamondImageView = bindView(R.id.diamond_image_view)
        loadingProgress = bindView(R.id.loading_progress_bar)

        val bottomSheetBackgroundView = bindView<View>(R.id.bottom_sheet_background_view).apply {
            alpha = INITIAL_ALPHA
        }
        val indicatorImageView = bindView<ImageView>(R.id.indicator_image_view)
        val indicatorTextView = bindView<TextView>(R.id.indicator_text_view)
        val markdownBottomSheetView = bindView<MarkdownBottomSheetView>(R.id.markdown_bottom_sheet_view).apply {
            usageType?.let { loadMarkdownFromAsset(it.mdFileName) }
        }
        BottomSheetBehavior.from(markdownBottomSheetView).apply {
            peekHeight = (resources.getDimension(R.dimen.margin_44)
                    + resources.getDimension(R.dimen.text_size_22)
                    + resources.getDimension(R.dimen.margin_8)).toInt()

            setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_EXPANDED -> {
                            indicatorImageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_36dp)
                            indicatorTextView.setText(R.string.hide_code)
                        }

                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            indicatorImageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_36dp)
                            indicatorTextView.setText(R.string.view_code)
                        }
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    bottomSheetBackgroundView.alpha = INITIAL_ALPHA + slideOffset * (1f - INITIAL_ALPHA)
                }
            })
        }
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
                        .circleCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(circleImageView)

                GlideApp.with(this)
                        .load(photoList[1].getPhotoUrl())
                        .placeholder(R.drawable.image_placeholder)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(diamondImageView)
            }

            UsageType.ShapeImageViewWithGoodPractice -> {
                GlideApp.with(this)
                        .load(photoList[0].getPhotoUrl())
                        .placeholder(R.drawable.image_placeholder)
                        .transition(DrawableTransitionOptions().transition(android.R.anim.fade_in))
                        .into(circleImageView)

                GlideApp.with(this)
                        .load(photoList[1].getPhotoUrl())
                        .placeholder(R.drawable.image_placeholder)
                        .transition(DrawableTransitionOptions().transition((android.R.anim.fade_in)))
                        .into(diamondImageView)
            }
        }
    }

    override fun finish() {
        super.finish()
        finishActivityWithSlideOut()
    }
}