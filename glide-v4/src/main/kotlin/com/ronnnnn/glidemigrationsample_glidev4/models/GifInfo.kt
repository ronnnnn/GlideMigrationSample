package com.ronnnnn.glidemigrationsample_glidev4.models

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/06/19.
 */
data class GifInfo(
        @Json(name = "url")
        val gifUrl: String,
        @Json(name = "mp4")
        val mp4Url: String
)