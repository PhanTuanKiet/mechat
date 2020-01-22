package com.tuankiet.mechat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuankiet.mechat.R
import io.realm.RealmList
import kotlinx.android.synthetic.main.message_item.view.*

class MessageAdapter(var itemList: RealmList<String>) : BaseAdapter() {
    override fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.message_item, viewGroup,false)
        return ItemListViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.onBindData(itemList[position]!!)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemListViewHolder(itemView: View): BaseViewHolder(itemView) {
        override fun onBindData(item: Any) {
            val messageContent = item as String
            itemView.tvContent.text = messageContent
        }
    }
}