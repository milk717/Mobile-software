package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

const val EXTRA_CUR_INDEX = "com.example.wordquiz.extra_cur_index"

class MainActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by lazy {
        ViewModelProvider(this).get(WordViewModel::class.java)
    }

    private lateinit var wordTextView: TextView
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var radioButton4: RadioButton
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button
    private lateinit var hintButton: Button
    private lateinit var hintTextView: TextView
    private var hintReferred: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordTextView = findViewById(R.id.wordTextView)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        radioButton4 = findViewById(R.id.radioButton4)
        nextButton = findViewById(R.id.nextButton)
        prevButton = findViewById(R.id.prevButton)
        hintButton = findViewById(R.id.hintButton)
        hintTextView = findViewById(R.id.hintTextView)
        updateWordQuiz()

        //힌트 엑티비티 열기
        hintButton.setOnClickListener {
            val intent = HintActivity.newIntent(this@MainActivity, wordViewModel.curIndex)
            startForResult.launch(intent)
        }

        nextButton.setOnClickListener {
            wordViewModel.moveToNext()
            updateWordQuiz()
        }
        prevButton.setOnClickListener {
            wordViewModel.moveToPrevious()
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

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    )
    { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            hintReferred = result.data?.getBooleanExtra(EXTRA_HINT_SHOWN, false) ?: false
            if (hintReferred) {
                hintTextView.setText(R.string.hint_message)
            } else {
                hintTextView.text = ""
            }
        }
    }

    private fun updateWordQuiz() {
        wordTextView.text = wordViewModel.curQuestion
        radioButton1.text = wordViewModel.curNumber1
        radioButton2.text = wordViewModel.curNumber2
        radioButton3.text = wordViewModel.curNumber3
        radioButton4.text = wordViewModel.curNumber4
        checkInit()
    }

    private fun checkAnswer(userAns: Int) {
        val correctAns = wordViewModel.curAnswer
        val message = if (userAns == correctAns) {
            resources.getString(R.string.right_ans_msg)
        } else {
            resources.getString(R.string.wrong_ans_msg)
        }
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun checkInit() {
        radioButton1.isChecked = false
        radioButton2.isChecked = false
        radioButton3.isChecked = false
        radioButton4.isChecked = false
    }
}

