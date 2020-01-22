package com.tuankiet.mechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    fun dummiesData() : ArrayList<Conversation>{
        var conList = ArrayList<Conversation>()

        var messageContent1 = RealmList<MessageContent>()
        messageContent1.add(MessageContent(0, RealmList("aaa","ddd","fsfs"), 3))
        messageContent1.add(MessageContent(1, RealmList("ddd","gbf","uutt","fsfs"), 4))

        var messageContent2 = RealmList<MessageContent>()
        messageContent2.add(MessageContent(2, RealmList("rrrr","ddd"), 2))
        messageContent2.add(MessageContent(3, RealmList("oppp","uutt","fsfs"), 3))

        var message1 = Message(0,"Me","", messageContent1)
        var message2 = Message(1,"Soooozz","", messageContent2)

        conList.add(Conversation(0,"21/01/2020", RealmList(message1, message2)))

        return conList
    }
}
