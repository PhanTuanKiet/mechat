package com.tuankiet.mechat.database

import android.content.Context
import io.realm.Realm
import io.realm.Realm.getDefaultInstance
import io.realm.Realm.setDefaultConfiguration
import io.realm.RealmConfiguration
import io.realm.RealmObject
import java.util.*

class RealmHelper {

    fun onCreate (context: Context ){
        Realm.init(context)

        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()

        setDefaultConfiguration(config)
    }

    fun getRealmInstance() : Realm {
        return getDefaultInstance()
    }

    fun deleteCurrentDatabase(){
        val defaultRealm = getRealmInstance()
        defaultRealm.close()
        Realm.deleteRealm(defaultRealm.configuration)
    }

    fun addNewData(data : RealmObject){
        val currentRealm = getRealmInstance()
        currentRealm.executeTransaction {
            val dataClass = data.javaClass
            val currentIdNum = it.where(data.javaClass).max("id")
            val nextId : Int
            if (currentIdNum == null)
                nextId = 1
            else
                nextId = currentIdNum.toInt() + 1
            it.copyToRealm(data)
        }
    }

}