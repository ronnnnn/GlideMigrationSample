package com.ronnnnn.glidemigrationsample.services.sources

import com.ronnnnn.glidemigrationsample.models.responce.TrendingGifsResponce
import com.ronnnnn.glidemigrationsample.services.GiphyService
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2017/06/19.
 */
class GiphySource(private val giphyService: GiphyService) {

    fun getTrindingGifs(): Single<TrendingGifsResponce>
            = giphyService.getTrendingGifs("dc6zaTOxFJmzC")
}