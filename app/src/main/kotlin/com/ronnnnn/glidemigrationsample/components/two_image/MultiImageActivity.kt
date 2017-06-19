package com.ronnnnn.glidemigrationsample.components.two_image

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.extentions.bindView
import com.ronnnnn.glidemigrationsample.models.Photo

/**
 * Created by kokushiseiya on 2017/06/19.
 */
class MultiImageActivity : AppCompatActivity(), MultiImagePresenter.MultiImageView {

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

        presenter.loadRecentPhotos()
    }

    override fun setLoadingProgressVisibility(isVisible: Boolean) {
        loadingProgressBar.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

    override fun setImages(photoList: List<Photo>) {
        Glide.with(this)
                .load(photoList[0])
                .placeholder(R.drawable.image_placeholder)
                .priority(Priority.IMMEDIATE)
                .into(firstImageView)

        Glide.with(this)
                .load(photoList[1])
                .placeholder(R.drawable.image_placeholder)
                .priority(Priority.LOW)
                .into(secondImageView)
    }
}