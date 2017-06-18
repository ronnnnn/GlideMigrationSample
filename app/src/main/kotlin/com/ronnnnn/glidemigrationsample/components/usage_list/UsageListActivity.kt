package com.ronnnnn.glidemigrationsample.components.usage_list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.models.UsageType
import com.ronnnnn.glidemigrationsample.components.image_list.ImageListActivity
import com.ronnnnn.glidemigrationsample.extentions.bindView
import com.ronnnnn.glidemigrationsample.views.SimpleItemDecoration
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class UsageListActivity : AppCompatActivity(), UsageListRecyclerAdapter.UsageListRecyclerAdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_list)

        Observable.just("foo")
                .map { UsageListUseCase().authWithFlickr() }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe { Timber.d("onNext") }

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
        startActivity(ImageListActivity.createIntent(this, UsageType.values()[position]))
    }
}
