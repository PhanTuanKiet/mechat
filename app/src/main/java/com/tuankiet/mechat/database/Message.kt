package com.tuankiet.mechat.database

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Message (@PrimaryKey var id : Long = 0,
                    var userId : Long = 0,
                    var messages : RealmList<String>? = null) : RealmObject()