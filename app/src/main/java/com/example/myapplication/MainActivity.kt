package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE_STR = "com.example.myapplication.message"
const val RETURN_MESSAGE_STR = "com.example.myapplication.return"

class MainActivity : AppCompatActivity() {
    //당장 초기화 할 수 없을 때 lateinit 사용
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        button.setOnClickListener {
            var str = editText.text.toString()
            var i = Intent(this, SubActivity::class.java)
            i.putExtra(EXTRA_MESSAGE_STR, str)
            startForResult.launch((i))
        }
    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if(result.resultCode == Activity.RESULT_OK){
                if(result.data != null){
                    result.data?.let{
                        val extras:Bundle? = it.extras
                        val returnString = extras?.getString(RETURN_MESSAGE_STR) ?: null
                        editText.setText(returnString)
                    }
                }
            }
    }

}

