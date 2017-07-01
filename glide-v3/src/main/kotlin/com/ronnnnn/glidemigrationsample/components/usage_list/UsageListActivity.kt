package com.ronnnnn.glidemigrationsample.components.usage_list

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.components.image_list.ImageListActivity
import com.ronnnnn.glidemigrationsample.components.shape_image.ShapeImageActivity
import com.ronnnnn.glidemigrationsample.components.two_image.MultiImageActivity
import com.ronnnnn.glidemigrationsample.extentions.bindView
import com.ronnnnn.glidemigrationsample.extentions.startActivityWithSlideIn
import com.ronnnnn.glidemigrationsample.models.UsageType
import com.ronnnnn.glidemigrationsample.views.SimpleItemDecoration

class UsageListActivity : AppCompatActivity(), UsageListRecyclerAdapter.UsageListRecyclerAdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_list)

        bindView<Toolbar>(R.id.toolbar).run {
            setTitle(R.string.app_name)
            setTitleTextColor(Color.WHITE)
        }
        bindView<RecyclerView>(R.id.usage_list_recycler_view).run {
            layoutManager = LinearLayoutManager(context)
            adapter = UsageListRecyclerAdapter(context, this@UsageListActivity)
            addItemDecoration(SimpleItemDecoration(
                    context,
                    R.color.usage_list_divider_color,
                    context.resources.getDimensionPixelSize(R.dimen.margin_12)
            ))
        }
    }

    override fun onItemClicked(position: Int) {
        val usageType = UsageType.values()[position]

        when (usageType) {
            UsageType.ImageRequestPriority -> {
                startActivityWithSlideIn(MultiImageActivity.createIntent(this))
            }

            UsageType.ShapeImageViewWithBadPractice,
            UsageType.ShapeImageViewWithGoodPractice -> {
                startActivityWithSlideIn(ShapeImageActivity.createIntent(this, usageType))
            }

            else -> {
                startActivityWithSlideIn(ImageListActivity.createIntent(this, usageType))
            }
        }
    }
}
