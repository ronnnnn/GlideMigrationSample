package com.ronnnnn.glidemigrationsample_glidev42

import android.app.Application
import com.ronnnnn.glidemigrationsample_glidev42.services.GMSRetrofit
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/06/17.
 */
class GMSApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        GMSRetrofit.initialize()
    }
}