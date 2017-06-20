package com.ronnnnn.glidemigrationsample.extentions

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

/**
 * Created by kokushiseiya on 2017/06/17.
 */
fun <T> View.bindView(@IdRes resourceId: Int): T {
    return findViewById(resourceId) as T
}

fun <T> Activity.bindView(@IdRes resourceId: Int): T {
    return findViewById(resourceId) as T
}
