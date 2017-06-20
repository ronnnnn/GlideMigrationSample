package com.ronnnnn.glidemigrationsample_glidev4.services.sources

import com.ronnnnn.glidemigrationsample_glidev4.models.response.RecentPhotosResponse
import com.ronnnnn.glidemigrationsample_glidev4.services.FlickrService
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2017/06/18.
 */
class FlickerSource(private val flickrService: FlickrService) {

    fun getRecentPhotos(): Single<RecentPhotosResponse> =
            flickrService.getRecentPhotos("flickr.photos.getRecent", "json", "b752e0023264f464d7be7a903d846a97", 1)
}