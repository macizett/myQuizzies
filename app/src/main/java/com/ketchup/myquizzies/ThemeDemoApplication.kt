package com.ketchup.myquizzies

import com.google.android.material.color.DynamicColors
import android.app.Application

class ThemeDemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}