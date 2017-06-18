package com.ronnnnn.glidemigrationsample

import android.app.Application
import com.ronnnnn.glidemigrationsample.services.GMSRetrofit
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