package com.tuankiet.mechat.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBindData(item: Any)

    fun getChildLayoutManager(context : Context) : RecyclerView.LayoutManager {
        val childLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,
            false)
        return childLayoutManager
    }

    fun setBackground (drawableId : Int) {
        itemView.background = itemView.context.getDrawable(drawableId)
    }

}