package com.tuankiet.mechat.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

data class Conversation(@Required @PrimaryKey var id : Long,
                        var date : String,
                        var messages : Array<Message>) : RealmObject()