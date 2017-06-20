package com.ronnnnn.glidemigrationsample_glidev4.services

import com.ronnnnn.glidemigrationsample_glidev4.models.response.TrendingGifsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kokushiseiya on 2017/06/19.
 */
interface GiphyService {

    @GET("v1/gifs/trending")
    fun getTrendingGifs(
            @Query("api_key")
            apiKey: String
    ): Single<TrendingGifsResponse>
}