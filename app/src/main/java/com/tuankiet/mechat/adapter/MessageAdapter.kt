package com.tuankiet.mechat.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
import com.tuankiet.mechat.database.ContentData
import com.tuankiet.mechat.database.MessageContent
import io.realm.RealmList
import kotlinx.android.synthetic.main.chat_item.view.*
import kotlinx.android.synthetic.main.message_item.view.*
import java.util.ArrayList

class MessageAdapter(var itemList: RealmList<ContentData>) : BaseAdapter() {
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
            val content = item as ContentData
            itemView.tvContent.text = splitWords(content.textMessage)
            val background  = itemView.background as GradientDrawable
            if (content.userId == 0L) {
                itemView.tvContent.rotationY = 180f
                background.setColor(ContextCompat.getColor(itemView.context, R.color.chat_bubble_gray))
            } else {
                background.setColor(ContextCompat.getColor(itemView.context, R.color.chat_bubble_blue))
            }

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