package com.tuankiet.mechat.database

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ContentData(
    var userId: Long = 0,
    var textMessage : String = ""
) : RealmObject()