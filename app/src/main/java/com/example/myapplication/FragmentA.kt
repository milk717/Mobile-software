package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    var activityCallBack:ButtonListener? = null
    interface ButtonListener{
        fun onButtonClick()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            if(context is ButtonListener){
                activityCallBack = context
            }
        }catch(e:ClassCastException){
            throw ClassCastException(context.toString() +
                    "must implement buttonListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_a, container, false)
        val button: Button = rootView.findViewById(R.id.button)
        button.setOnClickListener {
            activityCallBack?.onButtonClick()
        }
        return rootView
    }

}