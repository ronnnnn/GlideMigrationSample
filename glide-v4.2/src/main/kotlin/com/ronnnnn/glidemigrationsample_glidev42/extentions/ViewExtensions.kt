package com.ronnnnn.glidemigrationsample_glidev42.extentions

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

/**
 * Created by kokushiseiya on 2017/06/17.
 */
fun <T : View> View.bindView(@IdRes resourceId: Int): T =
        findViewById(resourceId)

fun <T : View> Activity.bindView(@IdRes resourceId: Int): T =
        findViewById(resourceId)
