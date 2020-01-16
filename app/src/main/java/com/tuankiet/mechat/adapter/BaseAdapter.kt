package com.tuankiet.mechat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuankiet.mechat.R
import java.util.*

open abstract class BaseAdapter() : RecyclerView.Adapter<ItemListViewHolder>() {

    lateinit var viewHolder : RecyclerView.ViewHolder

    abstract fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int) : RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        viewHolder = createViewHolder(parent, viewType)
       return viewHolder
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        return holder.bindItems(itemList[p1])
    }
    }



    class ItemListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems (item : Objects){

        }
    }
}