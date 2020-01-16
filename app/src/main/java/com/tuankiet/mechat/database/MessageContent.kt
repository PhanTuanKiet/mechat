package com.tuankiet.mechat.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

data class MessageContent(
    @Required
    @PrimaryKey
    var id : Long,
    var content : Array<String>,
    var amount: Int
) : RealmObject()