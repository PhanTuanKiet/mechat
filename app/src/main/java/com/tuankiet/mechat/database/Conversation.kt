package com.tuankiet.mechat.database

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Conversation (
    @PrimaryKey var id : Long = 0,
    var user : UserInfo? = UserInfo(),
    var messages : RealmList<ConversationItem>? = null
) : RealmObject()