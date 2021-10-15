package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class RadioListener : View.OnClickListener{
            override fun onClick(v: View?) {
                if(v == null) return
                var sb = StringBuilder()
                when(v.id){
                    R.id.red -> sb.append((v as RadioButton).text)
                    R.id.blue ->sb.append((v as RadioButton).text)
                    R.id.green ->sb.append((v as RadioButton).text)
                }
                sb.append(" 을(를) 선택했군요. ")
                showToast(sb.toString())
            }
        }
        val radioRed:RadioButton = findViewById(R.id.red)
        val radioBlue:RadioButton = findViewById(R.id.blue)
        val radioGreen:RadioButton = findViewById(R.id.green)
        
        when{
            radioRed.isChecked -> showToast("Red 가 기본 선택되어 있습니다. ")
            radioBlue.isChecked -> showToast("Blue 가 기본 선택되어 있습니다. ")
            radioGreen.isChecked -> showToast("Green 가 기본 선택되어 있습니다. ")
        }

        val lis = RadioListener()
        radioRed.setOnClickListener(lis)
        radioBlue.setOnClickListener(lis)
        radioGreen.setOnClickListener(lis)
    }
    fun showToast(msg:String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}