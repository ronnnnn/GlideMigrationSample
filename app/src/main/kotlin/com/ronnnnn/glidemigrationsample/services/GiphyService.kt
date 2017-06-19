package com.ronnnnn.glidemigrationsample.services

import com.ronnnnn.glidemigrationsample.models.responce.TrendingGifsResponce
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
    ): Single<TrendingGifsResponce>
}