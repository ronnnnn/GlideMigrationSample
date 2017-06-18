package com.ronnnnn.glidemigrationsample.components.usage_list

import java.io.IOException

/**
 * Created by kokushiseiya on 2017/06/17.
 */
class UsageListUseCase {

    companion object {
        private const val FLICKR_REQUEST_TOKEN_END_POINT = "https://www.flickr.com/services/oauth/request_token"
        private const val FLICKR_API_KEY = "b752e0023264f464d7be7a903d846a97"
        private const val FLICKR_API_SECRET = "8b630dd1c94007b5"
        private const val FLICKR_CALLBACK_URL = "https://www.flickr.com/auth-72157682179839884"
    }

    @Throws(IOException::class)
    fun authWithFlickr() {

    }
}