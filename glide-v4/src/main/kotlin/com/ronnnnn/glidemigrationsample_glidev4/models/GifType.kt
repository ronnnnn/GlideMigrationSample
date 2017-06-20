package com.ronnnnn.glidemigrationsample_glidev4.models

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/06/19.
 */
data class GifType(
        @Json(name = "fixed_height_downsampled")
        val gifInfo: GifInfo
)
