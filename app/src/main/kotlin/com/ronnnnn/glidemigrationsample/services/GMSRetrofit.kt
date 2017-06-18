package com.ronnnnn.glidemigrationsample.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.properties.Delegates

/**
 * Created by kokushiseiya on 2017/06/18.
 */
object GMSRetrofit {

    private const val FLICKR_BASE_URL = "https://api.flickr.com/"

    var flickrService: FlickrService by Delegates.notNull()

    fun initialize() {

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(FLICKR_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        flickrService = retrofit.create(FlickrService::class.java)
    }
}