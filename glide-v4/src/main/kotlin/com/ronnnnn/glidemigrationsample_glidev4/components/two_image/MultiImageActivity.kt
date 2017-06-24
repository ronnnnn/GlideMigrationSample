package com.ronnnnn.glidemigrationsample_glidev4.components.two_image

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Priority
import com.ronnnnn.glidemigrationsample_glidev4.GlideApp
import com.ronnnnn.glidemigrationsample_glidev4.R
import com.ronnnnn.glidemigrationsample_glidev4.extentions.bindView
import com.ronnnnn.glidemigrationsample_glidev4.models.Photo
import com.ronnnnn.glidemigrationsample_glidev4.views.MarkdownBottomSheetView

/**
 * Created by kokushiseiya on 2017/06/19.
 */
class MultiImageActivity : AppCompatActivity(), MultiImagePresenter.MultiImageView {

    companion object {
        fun createIntent(context: Context) = Intent(context, MultiImageActivity::class.java)
    }

    private lateinit var presenter: MultiImagePresenter
    private lateinit var firstImageView: ImageView
    private lateinit var secondImageView: ImageView
    private lateinit var loadingProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_image)

        presenter = MultiImagePresenter(this)

        firstImageView = bindView(R.id.first_image_view)
        secondImageView = bindView(R.id.second_image_view)
        loadingProgressBar = bindView(R.id.loading_progress_bar)

        val indicatorImageView = bindView<ImageView>(R.id.indicator_image_view)
        val indicatorTextView = bindView<TextView>(R.id.indicator_text_view)
        val markdownBottomSheetView = bindView<MarkdownBottomSheetView>(R.id.markdown_bottom_sheet_view).apply {
            loadMarkdownFromAsset("test.md")
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

        presenter.loadRecentPhotos()
    }

    override fun setLoadingProgressVisibility(isVisible: Boolean) {
        loadingProgressBar.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

    override fun setImages(photoList: List<Photo>) {
        GlideApp.with(this)
                .load(photoList[0].getPhotoUrl())
                .placeholder(R.drawable.image_placeholder)
                .priority(Priority.HIGH)
                .into(firstImageView)

        GlideApp.with(this)
                .load(photoList[1].getPhotoUrl())
                .placeholder(R.drawable.image_placeholder)
                .priority(Priority.LOW)
                .into(secondImageView)
    }
}