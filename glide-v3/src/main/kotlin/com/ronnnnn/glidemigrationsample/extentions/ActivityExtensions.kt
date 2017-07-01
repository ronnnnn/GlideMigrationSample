package com.ronnnnn.glidemigrationsample.extentions

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.ronnnnn.glidemigrationsample.R

/**
 * Created by kokushiseiya on 2017/07/02.
 */

fun AppCompatActivity.startActivityWithSlideIn(intent: Intent) {
    startActivity(intent)
    overridePendingTransition(R.anim.start_slide_in, R.anim.start_slide_out)
}

fun AppCompatActivity.finishActivityWithSlideOut() {
    overridePendingTransition(R.anim.finish_slide_out, R.anim.finish_slide_in)
}