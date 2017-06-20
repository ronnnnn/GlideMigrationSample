package com.ronnnnn.glidemigrationsample

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.model.GlideUrl
import com.ronnnnn.glidemigrationsample.services.GMSRetrofit
import java.io.InputStream

/**
 * Created by kokushiseiya on 2017/06/20.
 */
class AppGlideModule : OkHttpGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache(1024 * 1024 * 100)) // 100MB cache
                .setDecodeFormat(DecodeFormat.PREFER_ARGB_8888) // default decode format is PREFER_RGB_565
    }

    override fun registerComponents(context: Context, glide: Glide) {
        val client = GMSRetrofit.okHttpClient
        glide.register(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(client))
    }
}