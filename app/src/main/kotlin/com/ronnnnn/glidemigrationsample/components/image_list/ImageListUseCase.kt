package com.ronnnnn.glidemigrationsample.components.image_list

import com.ronnnnn.glidemigrationsample.models.Photo
import com.ronnnnn.glidemigrationsample.services.GMSRetrofit
import com.ronnnnn.glidemigrationsample.services.sources.FlickerSource
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2017/06/18.
 */
class ImageListUseCase {

    private val source: FlickerSource = FlickerSource(GMSRetrofit.flickrService)

    fun getRecentPhotos(): Single<List<Photo>> =
            source.getRecentPhotos()
                    .map { it.photos }
                    .map { it.photoList }
}