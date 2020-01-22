package com.tuankiet.mechat.database

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Conversation(@PrimaryKey var id : Long = 0,
                        var date : String? = "",
                        var messages : RealmList<Message>? = null) : RealmObject()