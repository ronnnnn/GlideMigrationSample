package com.ronnnnn.glidemigrationsample_glidev4.services

import com.ronnnnn.glidemigrationsample_glidev4.models.response.RecentPhotosResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kokushiseiya on 2017/06/18.
 */
interface FlickrService {

    @GET("services/rest")
    fun getRecentPhotos(
            @Query("method") method: String,
            @Query("format") format: String,
            @Query("api_key") apiKey: String,
            @Query("nojsoncallback") noJsonCallBack: Int
    ): Single<RecentPhotosResponse>
}