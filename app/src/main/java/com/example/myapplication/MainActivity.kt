package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sb = StringBuilder()
        val radioGroup:RadioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                sb.delete(0,sb.length)
                var radioButton:RadioButton = findViewById(checkedId)
                sb.append(radioButton.text)
                sb.append("를 선택했군요.")
            }
        })

        var id:Int =radioGroup.checkedRadioButtonId
        when(id){
            R.id.red->showToast("Red 가 기본 선택")
            R.id.blue->showToast("blue 가 기본 선택")
            R.id.green->showToast("green 가 기본 선택")
        }

        val btn:Button = findViewById(R.id.button)
        btn.setOnClickListener{
            showToast(sb.toString())
        }
    }
    fun showToast(msg:String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}