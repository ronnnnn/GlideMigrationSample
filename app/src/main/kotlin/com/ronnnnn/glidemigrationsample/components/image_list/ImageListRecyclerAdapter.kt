package com.ronnnnn.glidemigrationsample.components.image_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.extentions.bindView
import com.ronnnnn.glidemigrationsample.models.Gif
import com.ronnnnn.glidemigrationsample.models.Photo
import com.ronnnnn.glidemigrationsample.models.UsageType

/**
 * Created by kokushiseiya on 2017/06/17.
 */
class ImageListRecyclerAdapter<in T>(private val context: Context, private val usageType: UsageType) : RecyclerView.Adapter<ImageListRecyclerAdapter<T>.ViewHolder>() {

    private val dataList: ArrayList<T> = ArrayList()

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_list_recycler_view, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBind(dataList[position])
    }

    fun setItems(items: List<T>) {
        dataList.clear()
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImageView: ImageView = itemView.bindView(R.id.item_image_view)

        fun onBind(item: T) {
            when(item) {
                is Photo -> {
                    usageType.loadWithGlide(itemView.context, itemImageView, item.getPhotoUrl())
                }

                is Gif -> {
                    usageType.loadWithGlide(itemView.context, itemImageView, item.gifType.gifInfo.gifUrl)
                }
            }
        }
    }
}