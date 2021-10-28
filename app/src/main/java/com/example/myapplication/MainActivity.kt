package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items:Array<String> = resources.getStringArray(R.array.colors)
        var checked:Array<Boolean> = arrayOf(false, false, false)

        val callButton: Button = findViewById(R.id.callButton)
        callButton.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("확인 메시지")
                .setIcon(R.drawable.ic_baseline_thumb_up_alt_24)

                //두번째 파라미터에 checked 넣으면 에러남. null 넣기
                //아래는 두번째 멀티초이스 파라미터에 대한 안드로이드 설명
                //checkedItems – 체크할 항목을 지정합니다. null 이어야 하며, 이 경우 체크된 항목이 없습니다.
                // null 이 아닌 경우 항목 배열과 길이가 같아야 합니다.
                .setMultiChoiceItems(items, null ,object: DialogInterface.OnMultiChoiceClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        checked[which] = isChecked       //선택된값 == which 를 체크여부표시 == isChecked
                    }
                })
                .setPositiveButton("선택"){ _, _ ->
                    var sb = StringBuilder()
                    //indices == 배열에 대해 유효한 인덱스 범위 반환
                    for (i in checked.indices){
                        if(checked[i]){
                            sb.append("${items[i]} ")
                        }
                    }
                    Toast.makeText(
                        applicationContext,
                        "$sb 가 선택됨", Toast.LENGTH_SHORT
                    ).show()
                }
                .setNegativeButton("취소",null)
                .show()      //이거 안하면 안보임 (Toast 의 show 생각)
        }
    }
}

