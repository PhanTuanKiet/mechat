package com.tuankiet.mechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM
import androidx.appcompat.widget.Toolbar
import com.tuankiet.mechat.database.Conversation
import com.tuankiet.mechat.database.Message
import com.tuankiet.mechat.database.MessageContent
import io.realm.Realm
import io.realm.RealmList
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
