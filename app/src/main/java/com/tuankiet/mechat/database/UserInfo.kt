package com.tuankiet.mechat.database

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

data class UserInfo(
    @PrimaryKey var id : Long = 0,
    var name : String? = "",
    var avatar : String = ""
) : RealmObject()