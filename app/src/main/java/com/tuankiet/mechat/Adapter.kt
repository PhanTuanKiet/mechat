package com.tuankiet.mechat

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.chat_item.view.*




class Adapter(val itemList: ArrayList<String>,val itemAmount: Int): RecyclerView.Adapter<Adapter.ItemListViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemListViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.chat_item, p0,false)
        return ItemListViewHolder(v)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(p0: ItemListViewHolder, p1: Int) {
        return p0.bindItems(itemList[p1],itemAmount)
    }

    class ItemListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : String, amount: Int){
            itemView.tv_chat_content.text = item
            if (amount == 1){
                itemView.tv_chat_content.background = itemView.context.getDrawable(R.drawable.single_shape)
            }
            else if (amount == 2) {

            }
        }
    }
}
