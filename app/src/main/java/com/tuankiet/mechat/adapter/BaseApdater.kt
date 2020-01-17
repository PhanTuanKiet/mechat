package com.tuankiet.mechat.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

open abstract class BaseAdapter() : RecyclerView.Adapter<BaseViewHolder>() {


    abstract fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int) : BaseViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return createViewHolderInstance(parent, viewType)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.onBindData()
    }
}