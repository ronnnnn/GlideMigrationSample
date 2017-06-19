package com.ronnnnn.glidemigrationsample.components.image_list

import com.ronnnnn.glidemigrationsample.models.Gif
import com.ronnnnn.glidemigrationsample.models.Photo
import com.ronnnnn.glidemigrationsample.services.GMSRetrofit
import com.ronnnnn.glidemigrationsample.services.sources.FlickerSource
import com.ronnnnn.glidemigrationsample.services.sources.GiphySource
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2017/06/18.
 */
class ImageListUseCase {

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