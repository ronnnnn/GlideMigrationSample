package com.ronnnnn.glidemigrationsample.components.image_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.extentions.bindView
import com.ronnnnn.glidemigrationsample.models.Photo
import com.ronnnnn.glidemigrationsample.models.UsageType

/**
 * Created by kokushiseiya on 2017/06/17.
 */
class ImageListActivity : AppCompatActivity(), ImageListPresenter.ImageListView {

    companion object {
        private const val KEY_USAGE_TYPE = "key_usage_type"

        fun createIntent(context: Context, usageType: UsageType): Intent =
                Intent(context, ImageListActivity::class.java).apply {
                    putExtra(KEY_USAGE_TYPE, usageType)
                }
    }

    private var usageType: UsageType? = null

    private lateinit var adapter: ImageListRecyclerAdapter
    private lateinit var presenter: ImageListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list)

        presenter = ImageListPresenter(this)

        usageType = intent.getSerializableExtra(KEY_USAGE_TYPE) as? UsageType

        bindView<RecyclerView>(R.id.image_recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            usageType?.let {
                this@ImageListActivity.adapter = ImageListRecyclerAdapter(context, it)
                adapter = this@ImageListActivity.adapter
            }
        }

        presenter.getRecentPhotos()
    }

    override fun setPhotos(photoList: List<Photo>) {
        adapter.setItems(photoList)
    }
}