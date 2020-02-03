package com.tuankiet.mechat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuankiet.mechat.adapter.MainAdapter
import com.tuankiet.mechat.database.ConversationItem
import com.tuankiet.mechat.database.Message
import com.tuankiet.mechat.database.MessageContent
import io.realm.RealmList
import kotlinx.android.synthetic.main.main_chat_view.*

class ChatFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_chat_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        var  mainAdapter  = MainAdapter(dummiesData())
        rvMainContent.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mainAdapter
        }
    }

    fun dummiesData() : ArrayList<ConversationItem>{
        var conList = ArrayList<ConversationItem>()

        var messageContent1 = RealmList<MessageContent>()
        messageContent1.add(MessageContent(1, RealmList("hi f w d r, f ww y u y lmo","gbf","uutt","fsfs"), 4))

        var messageContent2 = RealmList<MessageContent>()
        messageContent2.add(MessageContent(2, RealmList("rrdddrr"), 2))

        var message1 = Message(0,0, messageContent1)
        var message2 = Message(1,1, messageContent2)

        conList.add(ConversationItem(0,"21/01/2020", RealmList(message1, message2)))

        return conList
    }
}