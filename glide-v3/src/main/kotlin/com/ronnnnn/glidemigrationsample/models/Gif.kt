package com.ronnnnn.glidemigrationsample.models

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/06/19.
 */
data class Gif(
        @Json(name = "images")
        val gifType: GifType) : Content()
