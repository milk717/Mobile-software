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

        val callButton: Button = findViewById(R.id.callButton)

        callButton.setOnClickListener {     //Context 와 Activity 를 구분해서 생각해야함 (아직잘 모르겠음)
            AlertDialog.Builder(this@MainActivity)        //this 라고만 쓰면 나중에 에러남
                .setTitle("확인 메시지")     //다이얼로그 제목 지정
                .setMessage("앱을 종료하겠습니까?")   //다이얼로그 메시지 출력
                .setIcon(R.drawable.ic_baseline_thumb_up_alt_24)      //다이얼로그 타이틀 아이콘 설정
                .setPositiveButton("예") { _, _ ->
                    finish()
                }
                .setNeutralButton("취소") { _, _ ->
                    Toast.makeText(applicationContext, "명령을 취소하였습니다.", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("아니요") { _, _ ->
                    Toast.makeText(applicationContext, "앱을 계속 사용합니다", Toast.LENGTH_SHORT).show()
                }
                .show()      //이거 안하면 안보임 (Toast 의 show 생각)
        }
    }
}

