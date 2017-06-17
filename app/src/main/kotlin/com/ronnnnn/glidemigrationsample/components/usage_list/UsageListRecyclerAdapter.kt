package com.ronnnnn.glidemigrationsample.components.usage_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.UsageType
import com.ronnnnn.glidemigrationsample.extentions.bindView

/**
 * Created by kokushiseiya on 2017/06/17.
 */
class UsageListRecyclerAdapter(private val context: Context, private val listener: UsageListRecyclerAdapterListener? = null) : RecyclerView.Adapter<UsageListRecyclerAdapter.ViewHolder>() {

    override fun getItemCount(): Int = UsageType.values().size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_usage_list_recycler_view, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBindView(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.bindView(R.id.title_text_view)

        fun onBindView(position: Int) {
            itemView.setOnClickListener {
                listener?.onItemClicked(position)
            }

            val usageType = UsageType.values()[position]
            titleTextView.text = usageType.name
        }
    }

    interface UsageListRecyclerAdapterListener {
        fun onItemClicked(position: Int)
    }
}