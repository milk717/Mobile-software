package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //        타입은 배열인데 <String>타입의 배열이다.
        val items:Array<String> = resources.getStringArray(R.array.colors)

        val callButton: Button = findViewById(R.id.callButton)
        callButton.setOnClickListener {     //Context 와 Activity 를 구분해서 생각해야함 (아직잘 모르겠음)
            AlertDialog.Builder(this@MainActivity)        //this 라고만 쓰면 나중에 에러남
                .setTitle("확인 메시지")     //다이얼로그 제목 지정
                .setIcon(R.drawable.ic_baseline_thumb_up_alt_24)      //다이얼로그 타이틀 아이콘 설정
                //.setMessage("색 선택")       //이거 안지우면 아래에 setItems 안뜸
                .setItems(items) { _, which ->
                    Toast.makeText(
                        applicationContext,
                        "$which, ${items[which]}가 선택됨", Toast.LENGTH_SHORT
                    ).show()
                }
                .show()      //이거 안하면 안보임 (Toast 의 show 생각)
        }
    }
}

