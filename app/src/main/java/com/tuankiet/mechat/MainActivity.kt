package com.tuankiet.mechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.delete
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var realm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        realm = Realm.getDefaultInstance()

        val fragment = ChatFragment()

        val ft = supportFragmentManager.beginTransaction()
        ft.add(fragmentContainer.id, fragment, "user")
        ft.commit()
    }

}
