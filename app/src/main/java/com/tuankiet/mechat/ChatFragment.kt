package com.tuankiet.mechat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuankiet.mechat.adapter.MainAdapter
import com.tuankiet.mechat.database.Conversation
import com.tuankiet.mechat.database.Message
import com.tuankiet.mechat.database.MessageContent
import io.realm.RealmList
import kotlinx.android.synthetic.main.main_message_layout.*

class ChatFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_message_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        var  mainAdapter  = MainAdapter(dummiesData())
        rvConversations.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mainAdapter
        }
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