package com.tuankiet.mechat.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

data class Message (@Required @PrimaryKey var id : Long,
                    @Required var name : String,
                    var avatar : String,
                    var messages : Array<MessageContent>) : RealmObject()