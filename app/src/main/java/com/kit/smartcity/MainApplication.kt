package com.kit.smartcity

import android.app.Application
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class MainApplication : Application() {
    var firebaseAnalytics: FirebaseAnalytics? = null
    var firebaseAuth: FirebaseAuth? = null

    var mInstance: MainApplication? = null

    override fun onCreate() {
        mInstance = this
        super.onCreate()

        Fresco.initialize(this)
        FirebaseApp.initializeApp(this)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        firebaseAuth = FirebaseAuth.getInstance()

        Log.d("firebase auth", "==== $firebaseAuth")
    }
}