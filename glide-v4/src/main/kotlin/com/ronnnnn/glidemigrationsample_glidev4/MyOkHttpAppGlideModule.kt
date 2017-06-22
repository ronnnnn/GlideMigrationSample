package com.ronnnnn.glidemigrationsample_glidev4

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.ronnnnn.glidemigrationsample_glidev4.services.GMSRetrofit
import java.io.InputStream

/**
 * Created by kokushiseiya on 2017/06/20.
 */
@GlideModule
class MyOkHttpAppGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache(1024 * 1024 * 100)) // 100MB cache
                .setDefaultRequestOptions(RequestOptions().format(DecodeFormat.PREFER_ARGB_8888)) // default decode format is PREFER_RGB_565
    }

    override fun registerComponents(context: Context?, registry: Registry?) {
        val client = GMSRetrofit.okHttpClient
        registry?.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(client))
    }

    override fun isManifestParsingEnabled(): Boolean = false
}