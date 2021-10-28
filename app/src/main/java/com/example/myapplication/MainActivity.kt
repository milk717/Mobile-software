package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callbackButton: Button = findViewById(R.id.callbackButton)
        //View 는 제일 상위 layout
        val mainLayout: View = findViewById(R.id.main_layout_id)
        callbackButton.setOnClickListener {
            showSnackbar(mainLayout)
        }
    }
    private fun showSnackbar(view:View){
        val mySnackbar:Snackbar = Snackbar.make(view,
        "메시지를 삭제할까요?",Snackbar.LENGTH_SHORT)
        mySnackbar.setAction("취소"){
            mySnackbar.dismiss()        //스낵바 사라지게
        }
        mySnackbar.show()
    }
}

