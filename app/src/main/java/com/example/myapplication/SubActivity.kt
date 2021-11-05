package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val editText: EditText = findViewById(R.id.editText)

//        var msg:String? = intent.getStringExtra(EXTRA_MESSAGE_STR)
//        editText.setText("수신 메시지는 $msg")

        //bundle 타입은 null safety 필수
        var extras:Bundle? = intent.extras
        
        //Elvis 연산 사용 -> intent.extras 자체에서 null 값을 가질 수도 있다고 작성
        /* Elvis 연산이 의미하는 뜻은 아래와 같다.
        var extrasElvisMean:Bundle? = null
        if (intent == null || intent.extras == null)
            extrasElvisMean = null
        */
        //이게 더 안정적인 코드
        var extras2= intent.extras ?: null
        if(intent.hasExtra(EXTRA_MESSAGE_STR)){
            var msg:String? = extras2?.getString(EXTRA_MESSAGE_STR)
            editText.setText("수신 메시지는 $msg")
        }

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            finish()
        }
    }
}