package com.kit.smartcity.utils

import android.os.Handler
import android.os.Looper

object DebounceHandler {
    val handler = Handler(Looper.getMainLooper())
    fun handle(runnable: Runnable, delay: Long = 280L) {
        handler.postDelayed(runnable, delay)
    }
}