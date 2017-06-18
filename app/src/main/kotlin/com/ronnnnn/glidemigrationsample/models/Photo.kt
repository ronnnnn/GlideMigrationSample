package com.ronnnnn.glidemigrationsample.models

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/06/17.
 */
data class Photo(
        val id: String,
        val owner: String,
        val secret: String,
        val server: String,
        val farm: Int,
        val title: String,
        @Json(name = "ispublic")
        val isPublic: Int,
        @Json(name = "isfriend")
        val isFriend: Int,
        @Json(name = "isfamily")
        val isFamily: Int) {

    fun getPhotoUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}
