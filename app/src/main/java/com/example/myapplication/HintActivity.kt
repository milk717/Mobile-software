package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

const val EXTRA_HINT_SHOWN = "com.example.wordquiz.extra_hint_shown"

class HintActivity : AppCompatActivity() {

    private val wordDictViewModel:WordDictViewModel by lazy{
        ViewModelProvider(this).get(WordDictViewModel::class.java)
    }

    companion object{
        fun newIntent(packageContext: Context, curDictIndex:Int): Intent {
            return Intent(packageContext,HintActivity::class.java).apply{
                putExtra(EXTRA_CUR_INDEX, curDictIndex)
            }
        }
    }
    private lateinit var word1TextView: TextView
    private lateinit var word1MeaningTextView: TextView
    private lateinit var word2TextView: TextView
    private lateinit var word2MeaningTextView: TextView
    private lateinit var word3TextView: TextView
    private lateinit var word3MeaningTextView: TextView
    private lateinit var word4TextView: TextView
    private lateinit var word4MeaningTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)

        word1TextView = findViewById(R.id.word1TextView)
        word1MeaningTextView = findViewById(R.id.word1MeaningTextView)
        word2TextView = findViewById(R.id.word2TextView)
        word2MeaningTextView = findViewById(R.id.word2MeaningTextView)
        word3TextView = findViewById(R.id.word3TextView)
        word3MeaningTextView = findViewById(R.id.word3MeaningTextView)
        word4TextView = findViewById(R.id.word4TextView)
        word4MeaningTextView = findViewById(R.id.word4MeaningTextView)
        backButton = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val data = Intent().apply {
                putExtra(EXTRA_HINT_SHOWN, true)
            }
            setResult(Activity.RESULT_OK, data)
            finish()
        }

        //현재 보고있는 페이지의 인덱스값을   전달받은 인텐트 객체가 가져온 현재 인덱스 값으로 설정
        //(패키지명, 디폴트값) 디폴트값은 전달된 값이 없는 경우를 말함
        wordDictViewModel.curIndexDict = intent.getIntExtra(EXTRA_CUR_INDEX, 0)
        updateWordDict()
    }
    private fun updateWordDict() {
        word1TextView.text = wordDictViewModel.curWord1
        word1MeaningTextView.text = wordDictViewModel.curWord1Meaning
        word2TextView.text = wordDictViewModel.curWord2
        word2MeaningTextView.text = wordDictViewModel.curWord2Meaning
        word3TextView.text = wordDictViewModel.curWord3
        word3MeaningTextView.text = wordDictViewModel.curWord3Meaning
        word4TextView.text = wordDictViewModel.curWord4
        word4MeaningTextView.text = wordDictViewModel.curWord4Meaning
    }
}