package com.ronnnnn.glidemigrationsample.contents.usage_list

import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.extentions.bindView

class UsageListActivity : android.support.v7.app.AppCompatActivity(), com.ronnnnn.glidemigrationsample.UsageListRecyclerAdapter.UsageListRecyclerAdapterListener {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.ronnnnn.glidemigrationsample.R.layout.activity_usage_list)

        bindView<android.support.v7.widget.RecyclerView>(com.ronnnnn.glidemigrationsample.R.id.usage_list_recycler_view).run {
            layoutManager = android.support.v7.widget.LinearLayoutManager(context)
            adapter = com.ronnnnn.glidemigrationsample.UsageListRecyclerAdapter(context, this@UsageListActivity)
            addItemDecoration(com.ronnnnn.glidemigrationsample.view.SimpleItemDecoration(
                    context,
                    R.color.usage_list_divider_color,
                    context.resources.getDimensionPixelSize(R.dimen.margin_12)
            ))
        }
    }

    override fun onItemClicked(position: Int) {

    }
}
