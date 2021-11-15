package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.fragment.app.Fragment

class ToolbarFragment : Fragment(),SeekBar.OnSeekBarChangeListener {
    private var seekValue = 10
    var activityCallback:ToolbarListener? =null

    interface ToolbarListener{
        fun onButtonClick(fontSize:Int, text:String)
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_toolbar, container, false)
        var seekBar:SeekBar = rootView.findViewById(R.id.seekBar1)
        seekBar.setOnSeekBarChangeListener(this)

        var editText:EditText = rootView.findViewById(R.id.editText1)
        var button: Button = rootView.findViewById(R.id.button1)
        button.setOnClickListener {
            activityCallback?.onButtonClick(seekValue, editText.text.toString())
        }
        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            if(context is ToolbarListener){
                activityCallback = context
            }
        }catch (e:ClassCastException){
            throw ClassCastException(context.toString()+
                        "must implement ToolbarListener()")
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekValue = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) { }

    override fun onStopTrackingTouch(seekBar: SeekBar?) { }
}