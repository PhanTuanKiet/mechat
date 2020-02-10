package com.tuankiet.mechat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
import com.tuankiet.mechat.database.ContentData
import com.tuankiet.mechat.database.Message
import io.realm.RealmList
import kotlinx.android.synthetic.main.conversation_layout.view.*

class ConversationAdapter (var itemList : RealmList<Message>) : BaseAdapter(){

    override fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.conversation_layout, viewGroup,false)
        return ItemListViewHolder(v)    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.onBindData(itemList[position]!!)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemListViewHolder(itemView: View): BaseViewHolder(itemView) {
        override fun onBindData(item: Any) {
            val messageItem = item as Message
            val userId = messageItem.userId
            if(userId == 0L)
                itemView.rotationY = 180f
            lateinit var messageAdapter : MessageAdapter
            var contentList : RealmList<ContentData> = RealmList()
            (messageItem.messages)!!.forEach {
                val contentData = ContentData(userId, it)
                contentList!!.add(contentData)
            }
            itemView.rvMessages.apply {
                messageAdapter = MessageAdapter(contentList)
                layoutManager = getChildLayoutManager(itemView.context)
                adapter = messageAdapter
            }
        }
    }
}