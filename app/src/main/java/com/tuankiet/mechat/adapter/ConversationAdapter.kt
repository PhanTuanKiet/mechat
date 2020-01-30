package com.tuankiet.mechat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
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
            lateinit var messageAdapter : MessageAdapter
            (messageItem.messages)!!.forEach {
                messageAdapter = MessageAdapter(it.content!!)
                itemView.rvMessages.apply {
                    layoutManager = getChildLayoutManager(itemView.context)
                    adapter = messageAdapter
                }
            }
        }
    }
}