package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val editText: EditText = findViewById(R.id.editText)
        var extras= intent.extras ?: null
        if(intent.hasExtra(EXTRA_MESSAGE_STR)){
            var msg:String? = extras?.getString(EXTRA_MESSAGE_STR)
            editText.setText("수신 메시지는 $msg")
        }

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val data = Intent() //메인에서 서브 호출시 인텐트객체 불러올땐 파라미터 필요하지만 반대는 필요없다.
            val returnString = editText.text.toString()
            //메인에서 서브로 데이터 전달하는 것과 동일하게 putExtra(key, value) 전달하기
            data.putExtra(RETURN_MESSAGE_STR, returnString)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }

}