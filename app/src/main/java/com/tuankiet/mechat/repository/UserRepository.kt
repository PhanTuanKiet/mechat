package com.tuankiet.mechat.repository

import androidx.lifecycle.LiveData
import com.tuankiet.mechat.database.RealmHelper
import com.tuankiet.mechat.database.UserInfo
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults

class UserRepository {

    private var realmInstance : Realm

    private var allUser : RealmResults<UserInfo>

    init {
        val realmHelper = RealmHelper()
        realmInstance = realmHelper.getRealmInstance()
        var userList : RealmResults<UserInfo>
        userList = realmInstance.where(UserInfo::class.java).findAll()
        allUser = userList
    }
}