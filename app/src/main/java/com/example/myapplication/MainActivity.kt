package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var wordTextView: TextView
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var radioButton4: RadioButton
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button

    private val wordBank = listOf<Word>(
        Word("부주의한, 소홀한", "degenerate", "unity", "inadvertent", "array", 3),
        Word("쇠약하게 하다", "vanity", "underhand", "enslave", "debilitate", 4),
        Word("(위험·곤란)제거하다", "artisan", "sadistic", "glossy", "obviate", 4),
        Word("우아한", "prostrate", "delude", "urbane", "renowned", 3),
        Word("활기있게 하다", "bereave", "enliven", "occult", "besiege", 2)
    )
    private var curIndex:Int = 0;       //단어 인덱스 초기값

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordTextView = findViewById(R.id.wordTextView)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        radioButton4 = findViewById(R.id.radioButton4)
        updateWordQuiz()

        nextButton = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            curIndex = (curIndex + 1) % wordBank.size
            updateWordQuiz()
        }
        prevButton = findViewById(R.id.prevButton)
        prevButton.setOnClickListener {
            if(curIndex == 0){
                curIndex = wordBank.size - 1
            }else{
                curIndex -= 1
            }
            updateWordQuiz()
        }

        radioButton1.setOnClickListener {
            checkAnswer(1)
        }
        radioButton2.setOnClickListener {
            checkAnswer(2)
        }
        radioButton3.setOnClickListener {
            checkAnswer(3)
        }
        radioButton4.setOnClickListener {
            checkAnswer(4)
        }
    }
    private fun updateWordQuiz(){
        wordTextView.text = wordBank[curIndex].question     //question 은 데이터 클래스 안에 프로퍼티
        radioButton1.text = wordBank[curIndex].number_1
        radioButton2.text = wordBank[curIndex].number_2
        radioButton3.text = wordBank[curIndex].number_3
        radioButton4.text = wordBank[curIndex].number_4
        checkInit()
    }
    private fun checkAnswer(userAns:Int){
        val correctAns = wordBank[curIndex].answer
        val message = if(userAns == correctAns){
            resources.getString(R.string.right_ans_msg)
        }else{
            resources.getString(R.string.wrong_ans_msg)
        }
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
    private fun checkInit(){
        radioButton1.isChecked = false
        radioButton2.isChecked = false
        radioButton3.isChecked = false
        radioButton4.isChecked = false
    }
}

