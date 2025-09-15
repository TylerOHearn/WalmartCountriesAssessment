package com.example.walmartcountriesassessment

import android.app.Application
import timber.log.Timber

class TimberInit: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("App created")
    }
}