package com.example.myapplication

import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.btnName.setOnClickListener{

            //백그라운드 색상 설정
            //val color = ContextCompat.getColor(this,R.color.custom)
            //binding.background.setBackgroundColor(color)

            val dollarsInput = binding.dollarsInput
            val resultText = binding.resultText
            val str = getString(R.string.exchange_won)

            val dp = resources.getDimension(R.dimen.textSize)


            if(dollarsInput.text.isNotEmpty()){     //비어있지 않을 때
                resultText.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20f)
                var dollar = dollarsInput.text.toString().toFloat()
                var won = dollar*1136
                resultText.text = "$str: $won 원"
            }
            else{
                resultText.setTextSize(TypedValue.COMPLEX_UNIT_PX,dp)
                resultText.text = "No Value"
                //텍스트 사이즈 설정

            }
        }
    }

}