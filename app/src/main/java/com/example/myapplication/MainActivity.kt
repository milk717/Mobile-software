package com.example.myapplication

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    private var sb = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myView: View = findViewById(R.id.myView)
        myView.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                handleTouch(event)
                return true     //확실하게 처리했다.
            }
        })
    }

    private fun handleTouch(m:MotionEvent?){        //세이프콜 해줘야함: onTouch에서 전달하는 값이 null일수도 있어서
        var textView:TextView = findViewById(R.id.textView)
        if(m == null) return
        var x:Float = m.x
        var y:Float = m.y

        when(m.action){
            MotionEvent.ACTION_DOWN -> outMessage("손가락을 누름" ,x,y)
            MotionEvent.ACTION_UP -> outMessage("손가락을 뗌",x,y)
            MotionEvent.ACTION_MOVE -> outMessage("손가락을 이동" ,x,y)
            else -> outMessage("액션 없음",x,y)
        }
        textView.text = sb.toString()
    }
    private fun outMessage(msg:String, x:Float, y:Float){
        var textView:TextView = findViewById(R.id.textView)
        sb.append("%-10s: %.2f %.2f\n".format(msg,x,y))
        textView.text = sb.toString()
    }
}