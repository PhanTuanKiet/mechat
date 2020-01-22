package com.tuankiet.mechat.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBindData(item: Any)
}