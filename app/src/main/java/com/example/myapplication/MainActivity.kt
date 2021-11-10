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


        //array 리소스의 스타일을 적용해서 불러오는 방법
        val adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        val spinner:Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //position 은 선택된 것의 인덱스
                var planet = parent?.getItemAtPosition(position).toString()
                //parent?.context -> 부모는 메인 엑티비티
                Toast.makeText(parent?.context, "선택한 행성은 $planet",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}

