package com.tuankiet.mechat

import android.app.Application
import com.tuankiet.mechat.database.RealmHelper

class MCApplication : Application() {

    val realmHelper = RealmHelper()

    override fun onCreate() {
        super.onCreate()

        realmHelper.onCreate(this)
    }
}