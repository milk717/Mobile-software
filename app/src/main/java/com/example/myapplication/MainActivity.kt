package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //동적 교체할때는 필요한 코드지만 그냥 하나만 띄워줄땐 이거 없어도 실행은 됨. 왜냐면 xml 파일에서 넣어줬기때문
        val currentFragment  = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment == null){    //현재 프래그먼트가 비어 있을 때
            supportFragmentManager      //프래그먼트를 호출하는 매니저
                .beginTransaction()                             //일련의 과정을 실행하라
                .add(R.id.fragment_container,MovieFragment())   //프래그먼트 들어갈곳 == 컨테이너에 생성한 객체 ==MovieFragment 넣어줘라
                .commit()                                       //마무리?
        }
    }
    fun showToast(text: String){
        Toast.makeText(applicationContext,text, Toast.LENGTH_SHORT).show()
    }

}

