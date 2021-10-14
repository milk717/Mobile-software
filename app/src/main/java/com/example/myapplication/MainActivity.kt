package com.example.myapplication

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wholeLayout: ConstraintLayout = findViewById(R.id.whole_layout)
        wholeLayout.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                handleTouch(event)
                return true
            }
        })
    }

    private fun handleTouch(m:MotionEvent?){        //세이프콜 해줘야함: onTouch에서 전달하는 값이 null일수도 있어서
        if (m == null) return
        val pointerCount:Int = m.pointerCount
        var textView:TextView = findViewById(R.id.textView)
        var textView2:TextView = findViewById(R.id.textView2)

        for (i in 0 until pointerCount){
            val x:Float = m.getX(i)
            val y:Float = m.getY(i)
            val id:Int = m.getPointerId(i)
            val actionIndex:Int = m.actionIndex
            var actionString:String = ""

            when(m.action){
                MotionEvent.ACTION_DOWN -> actionString = "Down"
                MotionEvent.ACTION_UP -> actionString = "UP"
                MotionEvent.ACTION_POINTER_UP -> actionString = "POINTER_UP"
                MotionEvent.ACTION_POINTER_DOWN -> actionString = "POINTER_DOWN"
                MotionEvent.ACTION_MOVE -> actionString = "MOVE"
            }
            var message:String = "Action $actionString,Index:$actionIndex, ID:$id"
            if(id == 0)
                textView.text = outMessage(message,x,y)
            else
                textView2.text = outMessage(message,x,y)

        }
    }
    private fun outMessage(msg:String, x:Float, y:Float) = "%s : %.2f %.2f".format(msg,x,y)
}