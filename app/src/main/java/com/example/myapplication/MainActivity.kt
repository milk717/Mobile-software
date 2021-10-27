package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val editText: EditText = findViewById(R.id.editText)
        val editText2:EditText = findViewById(R.id.editText1)
        var res:String = ""     //계산 값을 문자열로 바꿔 저장할 변수

        radioGroup.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                var resFloat:Float = 1.0f
                var str:String = editText.text.toString()
                when(val radioId = radioGroup.checkedRadioButtonId){
                    R.id.radioButton -> resFloat = ((str.toFloat() * 1.8f) + 32)       //섭씨 화씨 체크된 경우
                    R.id.radioButton2 -> resFloat = ((str.toFloat() - 32) / 1.8f)      //화씨 섭씨 체크된 경우
                    else->resFloat = 1.0f
                }
                res = resFloat.toString()
            }
        })

        btn.setOnClickListener {        //버튼 누르면
            editText2.setText(res)      //값 표시
        }
    }

}

