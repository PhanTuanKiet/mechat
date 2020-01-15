package com.tuankiet.mechat.database

import android.content.Context
import io.realm.Realm
import io.realm.Realm.setDefaultConfiguration
import io.realm.RealmConfiguration



class RealmHelper() {

    fun onCreate (context: Context ){
        Realm.init(context)

        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()

        setDefaultConfiguration(config)
    }
}