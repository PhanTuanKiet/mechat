package com.tuankiet.mechat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
import com.tuankiet.mechat.database.Message
import kotlinx.android.synthetic.main.chat_item.view.*
import kotlinx.android.synthetic.main.conversation_layout.view.*

class ConversationAdapter (var itemList : Array<Message>) : RecyclerView.Adapter<ConversationAdapter.ItemListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ItemListViewHolder(v)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        return holder.bindItems(itemList[position])
    }

    class ItemListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : Message) {
            //set avatar

        }
    }
}