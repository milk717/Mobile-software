package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

const val EXTRA_MESSAGE = "com.example.myapplication.message"
const val RETURN_CHECK = "com.example.myapplication.returnMessage"

class MainActivity : AppCompatActivity() {
    private var hintCheck = 0
    private lateinit var wordTextView:TextView
    private lateinit var radioButton1:RadioButton
    private lateinit var radioButton2:RadioButton
    private lateinit var radioButton3:RadioButton
    private lateinit var radioButton4:RadioButton
    private lateinit var hintTextView:TextView

    private val movieViewModel: WordViewModel by lazy{
        ViewModelProvider(this).get(WordViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val prevButton: Button = findViewById(R.id.prevButton)
        val nextButton: Button = findViewById(R.id.nextButton)
        val hintButton: Button = findViewById(R.id.hintButton)
        hintTextView = findViewById(R.id.hintTextView)

        wordTextView = findViewById(R.id.textView)
        radioButton1= findViewById(R.id.radioButton1)
        radioButton2= findViewById(R.id.radioButton2)
        radioButton3= findViewById(R.id.radioButton3)
        radioButton4= findViewById(R.id.radioButton4)

        question()

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            var id = 1
            when(checkedId){
                R.id.radioButton1-> id = 1
                R.id.radioButton2-> id = 2
                R.id.radioButton3-> id = 3
                R.id.radioButton4-> id = 4
                else -> 1
            }
            if(id == movieViewModel.wordA){
                Toast.makeText(applicationContext,"정답입니다",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,"오답입니다",Toast.LENGTH_SHORT).show()
            }
        }
        prevButton.setOnClickListener{
            movieViewModel.previous()
            hintTextView.visibility = View.INVISIBLE
            question()
        }
        nextButton.setOnClickListener {
            movieViewModel.next()
            hintTextView.visibility = View.INVISIBLE
            question()
        }

        hintButton.setOnClickListener {
            var i: Intent = HintActivity.newIntent(this,movieViewModel.curIndex)
            startForResult.launch((i))
        }
    }
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {      //엑티비티 결과값이 ok이고
            if (result.data != null) {  //인텐트 자체도 null 이 아닐 때
                val extras: Bundle? = result.data?.extras
                //Elvis 연산자 사용
                hintCheck = extras?.getInt(RETURN_CHECK,0)?:0
                if(hintCheck == 1){
                    hintTextView.visibility = View.VISIBLE
                }
                else{
                    hintTextView.visibility = View.INVISIBLE
                }
            }
        }
    }
    private fun question(){
        wordTextView.text = movieViewModel.wordQ
        radioButton1.text = (movieViewModel.word1)
        radioButton2.text = (movieViewModel.word2)
        radioButton3.text = (movieViewModel.word3)
        radioButton4.text = (movieViewModel.word4)
        radioButton1.isChecked = false
        radioButton2.isChecked = false
        radioButton3.isChecked = false
        radioButton4.isChecked = false
    }
}