package com.ronnnnn.glidemigrationsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class UsageListActivity : AppCompatActivity(), UsageListRecyclerAdapter.UsageListRecyclerAdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_list)

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

    }
}
