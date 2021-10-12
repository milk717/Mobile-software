package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //메소드 안에 클래스를 생성하는 것 : 중첩 클래스
        class BtnListener : View.OnClickListener{
            override fun onClick(v: View?){
                //(어디다띄울거니,메시지는 뭐니,얼마동안보여줄거니).이와같은 다이얼로그 창은 show()메소드로 띄워주기
                Toast.makeText(applicationContext,"버튼이 눌렸습니다",Toast.LENGTH_SHORT).show()
            }
        }

        var btnView: Button = findViewById(R.id.btnView)
        //val lis = BtnListener()
        btnView.setOnClickListener(BtnListener())        //괄호 안에 리스너 객체 등록시켜줘야함
    }
}