package com.tuankiet.mechat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
import com.tuankiet.mechat.database.Message
import com.tuankiet.mechat.database.MessageContent

class MessageAdapter (var itemList : Array<MessageContent>) :
    RecyclerView.Adapter<MessageAdapter.ItemListViewHolder>() {

    override fun onBindViewHolder(holder: MessageAdapter.ItemListViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ItemListViewHolder(v)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ItemListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : MessageContent) {


        }
    }
}