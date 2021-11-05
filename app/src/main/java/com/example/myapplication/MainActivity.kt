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

            //서브엑티비티로부터 값을 전달받기 위해서는 아래와 같이 서브 엑티비티를 불러와야함
            //아래 메소드가 결과가 있어야지만 엑티비티 콜백 메소드 호출됨
            startForResult.launch((i))
            //예전에는 서브엑티비티의 값 전달을 무작정 기다림 but 오류나는 일 있어서
            //ActivityResultContracts 에 의해서 동작하고
            //엑티비티와 콜백 메소드가 분리돼서 동작하도록 변경됨
            //제대로 전달 받았으면 콜백 메소드를 실행해라 이렇게됨
            //registerForActivityResult 는 서브엑티비티에서 결과를 돌려줄 때 필요한 메소드
        }
    }

    //registerForActivityResult 서브 엑티비티에서 결과를 전달받았을 때 실행됨됨
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->   //파라미터를 하나 전달받음, 그 안에 엑티비티 결과가 담겨있음
            if(result.resultCode == Activity.RESULT_OK){
                //인텐트 자체도 null 이 아닐 때
                if(result.data != null){
                    //result.data 까지가 인텐트 객체임. 따라서 null-safety 처리하기
                    //val t:Intent? = result.data
                    val extras:Bundle? = result.data?.extras
                    //Elvis 연산자 사용
                    val returnString = extras?.getString(RETURN_MESSAGE_STR) ?: null
                    editText.setText(returnString)
                }
            }
    }

}

