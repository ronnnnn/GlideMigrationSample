package com.ronnnnn.glidemigrationsample.models

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/06/18.
 */
data class Photos(
        val page: Int,
        val pages: Int,
        val perpage: Int,
        val total: Int,
        @Json(name = "photo")
        val photoList: List<Photo>
)