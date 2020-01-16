package com.tuankiet.mechat.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuankiet.mechat.R
import com.tuankiet.mechat.database.Conversation
import kotlinx.android.synthetic.main.main_message_layout.view.*


class MainAdapter (val itemList: ArrayList<Conversation>): BaseAdapter() {

    override fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.main_message_layout, viewGroup,false)
        return ItemListViewHolder(v)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {
        return holder.bindItems(itemList[p1])
    }

    class ItemListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : Conversation){
            itemView.tvDatetime.text = item.date
            val conversationAdapter = ConversationAdapter(item.messages)
            itemView.rvConversations.adapter = conversationAdapter
        }
    }
}
