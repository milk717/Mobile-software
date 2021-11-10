package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //array 리소스 가져오는 법
        val planets = resources.getStringArray(R.array.planets_array)
        //array 리소스를 닫힌 스피너에 가져오는 아답터, 열린것도 가져오긴 하지만 엉성
        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, planets)
        //setDropDownViewResource 해야지 펼친것도 제대로 가져옴
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        val spinner:Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = SpinnerListener()
    }

    //이너를 생략하면 바깥에 있는 것 참조 못함
    inner class SpinnerListener : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //position 은 선택된 것의 인덱스
            var planet = parent?.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "선택한 행성은 $planet",Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            
        }
    }
}

