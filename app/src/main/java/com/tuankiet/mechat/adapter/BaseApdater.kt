package com.tuankiet.mechat.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    abstract fun createViewHolderInstance(viewGroup: ViewGroup, viewType: Int) : BaseViewHolder

    abstract override fun onBindViewHolder(holder: BaseViewHolder, position: Int)

    abstract  override fun getItemCount(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return createViewHolderInstance(parent, viewType)
    }

}