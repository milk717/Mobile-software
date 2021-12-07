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


class ToolbarFragment : Fragment() {

    private var activityCallBack: ToolBarListener? = null

    interface ToolBarListener{
        fun onButtonClick(textSize:Int,text:String)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            if(context is ToolBarListener){
                activityCallBack = context
            }
        }catch (e:ClassCastException){
            throw ClassCastException(context.toString()+"must be implement ToolBarListener")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_toolbar, container, false)
        var seekBarValue = 20
        val seekBar: SeekBar = rootView.findViewById(R.id.seekBar)
        val editText:EditText = rootView.findViewById(R.id.editText)
        val button: Button = rootView.findViewById(R.id.button)

        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarValue = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) { }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { }
        })
        button.setOnClickListener {
            activityCallBack?.onButtonClick(seekBarValue,editText.text.toString())
        }
        return rootView
    }


}