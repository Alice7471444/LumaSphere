@file:Suppress("DEPRECATION")
package com.lumasphere.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LumaSphereApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}