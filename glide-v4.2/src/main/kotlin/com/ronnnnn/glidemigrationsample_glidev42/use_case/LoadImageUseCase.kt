package com.ronnnnn.glidemigrationsample_glidev42.use_case

import com.ronnnnn.glidemigrationsample_glidev42.models.Gif
import com.ronnnnn.glidemigrationsample_glidev42.models.Photo
import com.ronnnnn.glidemigrationsample_glidev42.services.GMSRetrofit
import com.ronnnnn.glidemigrationsample_glidev42.services.sources.FlickerSource
import com.ronnnnn.glidemigrationsample_glidev42.services.sources.GiphySource
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2017/06/18.
 */
class LoadImageUseCase {

    private val flickerSource: FlickerSource = FlickerSource(GMSRetrofit.flickrService)
    private val giphySource: GiphySource = GiphySource(GMSRetrofit.giphyService)

    fun getRecentPhotos(): Single<List<Photo>> =
            flickerSource.getRecentPhotos()
                    .map { it.photos }
                    .map { it.photoList }

    fun getTrendingGifs(): Single<List<Gif>> =
            giphySource.getTrindingGifs()
                    .map { it.gifs }
}