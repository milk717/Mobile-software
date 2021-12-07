package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class TextFragment : Fragment() {
    lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_text, container, false)
        textView = rootView.findViewById(R.id.textView)
        return rootView
    }
    fun textSet(fontSize:Int,text:String){
        textView.text = text
        textView.textSize = fontSize.toFloat()
    }
}