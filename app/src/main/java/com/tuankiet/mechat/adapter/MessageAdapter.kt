package com.tuankiet.mechat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
import io.realm.RealmList
import kotlinx.android.synthetic.main.message_item.view.*
import java.util.ArrayList

class MessageAdapter(var itemList: RealmList<String>) : BaseAdapter() {
    override fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.message_item, viewGroup,false)
        return ItemListViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if(itemList.size == 1)
            holder.setBackground(R.drawable.full_corners_shape)
        else {
            if(position == 0)
                holder.setBackground(R.drawable.three_corners_top_shape)
            else if (position == itemList.size -1){
                holder.setBackground(R.drawable.three_corners_bottom_shape)
            } else {
                holder.setBackground(R.drawable.two_corners_shape)
            }
        }
        return holder.onBindData(itemList[position]!!)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemListViewHolder(itemView: View): BaseViewHolder(itemView) {
        override fun onBindData(item: Any) {
            val messageContent = item as String
            itemView.tvContent.text = splitWords(item)
            splitWords(item)
        }


        fun splitWords(item: String): String {
            var split: List<String> = item.split(" ")
            var count = 0
            var resultText = ""
            split.forEach {
                count = count + 1
                resultText = resultText + it + " "
                if (count > 0 && count % 10 == 0) {
                        resultText = resultText + "\n"
                }
            }
            return resultText
        }
    }
}