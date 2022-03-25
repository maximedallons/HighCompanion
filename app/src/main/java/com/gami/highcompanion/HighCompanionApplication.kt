package com.gami.highcompanion

import android.app.Application
import com.gami.highcompanion.data.DaysDatabase

class HighCompanionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DaysDatabase.getDatabase(baseContext)
    }

    override fun onTerminate() {
        super.onTerminate()
        DaysDatabase.disconnectDatabase()
    }
}