package com.ronnnnn.glidemigrationsample_glidev4.services.sources

import com.ronnnnn.glidemigrationsample_glidev4.models.response.TrendingGifsResponse
import com.ronnnnn.glidemigrationsample_glidev4.services.GiphyService
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2017/06/19.
 */
class GiphySource(private val giphyService: GiphyService) {

    fun getTrindingGifs(): Single<TrendingGifsResponse>
            = giphyService.getTrendingGifs("dc6zaTOxFJmzC")
}