package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callButton:Button = findViewById(R.id.callButton)

        callButton.setOnClickListener {     //Context 와 Activity 를 구분해서 생각해야함 (아직잘 모르겠음)
            AlertDialog.Builder(this@MainActivity)        //this 라고만 쓰면 나중에 에러남
            .setTitle("게시판")     //다이얼로그 제목 지정
            .setMessage("2학년을 위한 환영회")   //다이얼로그 메시지 출력
            .setIcon(R.drawable.ic_launcher_foreground)      //다이얼로그 타이틀 아이콘 설정
            .show()      //이거 안하면 안보임 (Toast 의 show 생각)
        }
    }
}

