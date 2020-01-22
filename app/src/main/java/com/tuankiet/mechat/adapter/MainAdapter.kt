package com.tuankiet.mechat.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
import com.tuankiet.mechat.database.Conversation
import kotlinx.android.synthetic.main.main_message_layout.view.*


class MainAdapter (val itemList: ArrayList<Conversation>): BaseAdapter() {


    override fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.main_message_layout, viewGroup,false)
        return ItemListViewHolder(v)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.onBindData(itemList[position])

    }

    class ItemListViewHolder(itemView: View): BaseViewHolder(itemView) {
        override fun onBindData(item: Any) {
            val conversation = item as Conversation
            itemView.tvDatetime.text = conversation.date
            val conversationAdapter = ConversationAdapter(conversation.messages!!)
            val childLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL,
                false)
            itemView.rvConversations.apply {
                layoutManager = childLayoutManager
                adapter = conversationAdapter
            }
        }
    }
}
