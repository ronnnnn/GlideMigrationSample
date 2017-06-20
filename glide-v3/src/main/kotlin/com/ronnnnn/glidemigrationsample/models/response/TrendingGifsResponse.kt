package com.ronnnnn.glidemigrationsample.models.response

import com.ronnnnn.glidemigrationsample.models.Gif
import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/06/19.
 */
data class TrendingGifsResponse(
        @Json(name = "data")
        val gifs: List<Gif>
)