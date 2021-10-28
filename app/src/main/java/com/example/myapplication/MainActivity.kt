package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items:Array<String> = resources.getStringArray(R.array.colors)
        var mSelect = -1

        val callButton: Button = findViewById(R.id.callButton)
        callButton.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("확인 메시지")
                .setIcon(R.drawable.ic_baseline_thumb_up_alt_24)

                    //두번째 파라미터 -1하면 아무것도 선택 안된 초기상태
                .setSingleChoiceItems(items, mSelect) { _, which -> //여기서 which 는 어떤 것이 선택되었는지 인덱스 값을 나타내고
                    mSelect = which
                    Log.d("확인", "$mSelect, $which")
                }
                .setPositiveButton("선택") { _, which ->  //여기서 which 는 -1임, 즉 SingleChoiceItems 에서의 which 값과 다름.
                                                                //자세한건 아직 모르겠음. 그래서 items[which]하면 에러남
                    Toast.makeText(
                        applicationContext,
                        "$which, ${items[mSelect]}가 선택됨", Toast.LENGTH_SHORT
                    ).show()
                    Log.d("확인", "$mSelect, $which")
                }
                .setNegativeButton("취소",null)
                .show()      //이거 안하면 안보임 (Toast 의 show 생각)
        }
    }
}

