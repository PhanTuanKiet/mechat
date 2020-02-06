package com.tuankiet.mechat.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.graphics.drawable.ShapeDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.TextView
import com.tuankiet.mechat.R

class ChatBubble : ViewGroup {

    constructor(context: Context) : super(context){
      init(context, null)
    }

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs){
        init(context, attrs)
    }

    lateinit var textView: TextView

    fun init (context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context)
            .inflate(R.layout.message_item,this, true)

        textView = findViewById(R.id.tvContent)

        val attributeSet = context.obtainStyledAttributes(attrs, R.styleable.custom_message_item)
        attributeSet.recycle()
    }

    fun setColor(color : String) {
       val background : ShapeDrawable = textView.background as ShapeDrawable
        background.paint.color = Color.parseColor(color)

    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
