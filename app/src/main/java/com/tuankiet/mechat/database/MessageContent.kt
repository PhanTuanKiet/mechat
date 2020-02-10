package com.tuankiet.mechat.database

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class MessageContent(
    @PrimaryKey
    var id : Long = 0,
    var content : RealmList<ContentData>? = null
) : RealmObject()