package com.ronnnnn.glidemigrationsample_glidev4.components.transparent_image

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.ronnnnn.glidemigrationsample_glidev4.GlideApp
import com.ronnnnn.glidemigrationsample_glidev4.R
import com.ronnnnn.glidemigrationsample_glidev4.extentions.bindView
import com.ronnnnn.glidemigrationsample_glidev4.models.UsageType
import com.ronnnnn.glidemigrationsample_glidev4.views.MarkdownBottomSheetView

/**
 * Created by kokushiseiya on 2017/06/23.
 */
class TransparentImageActivity : AppCompatActivity() {

    companion object {
        private const val KEY_USAGE_TYPE = "key_usage_type"

        fun createIntent(context: Context, usageType: UsageType): Intent =
                Intent(context, TransparentImageActivity::class.java).apply {
                    putExtra(KEY_USAGE_TYPE, usageType)
                }
    }

    private var usageType: UsageType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transparent_image)

        usageType = intent.getSerializableExtra(KEY_USAGE_TYPE) as? UsageType

        val imageView: ImageView = bindView(R.id.image_view)

        when (usageType) {
            UsageType.TransparentImageWithBadPractice -> {
                GlideApp.with(this)
                        .load(R.drawable.ic_android_black_36dp)
                        .placeholder(R.drawable.image_placeholder)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView)
            }

            UsageType.TransparentImageWithGoodPractice -> {
                GlideApp.with(this)
                        .load(R.drawable.ic_android_black_36dp)
                        .placeholder(R.drawable.image_placeholder)
                        .transition(DrawableTransitionOptions().crossFade(
                                DrawableCrossFadeFactory.Builder()
                                        .setCrossFadeEnabled(true)
                                        .build()
                        ))
                        // or
                        // .transition(DrawableTransitionOptions().transition(android.R.anim.fade_in))
                        .into(imageView)
            }
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
                    // no-op
                }
            })
        }
    }
}