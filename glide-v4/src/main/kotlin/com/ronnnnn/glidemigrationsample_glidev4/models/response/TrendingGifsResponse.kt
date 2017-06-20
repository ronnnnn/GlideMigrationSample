package com.ronnnnn.glidemigrationsample_glidev4.models.response

import com.ronnnnn.glidemigrationsample_glidev4.models.Gif
import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/06/19.
 */
data class TrendingGifsResponse(
        @Json(name = "data")
        val gifs: List<Gif>
)