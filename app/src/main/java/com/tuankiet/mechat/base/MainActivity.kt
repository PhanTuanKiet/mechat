package com.tuankiet.mechat.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tuankiet.mechat.R
import com.tuankiet.mechat.UserFragment
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var realm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val realmHelper = RealmHelper()
//        realmHelper.deleteCurrentDatabase()

        val fragment = UserFragment()

        val ft = supportFragmentManager.beginTransaction()
        ft.add(fragmentContainer.id, fragment, "user")
        ft.commit()
    }

}
