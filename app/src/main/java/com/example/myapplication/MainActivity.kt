package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkAmericano:CheckBox = findViewById(R.id.checkAmericano)
        val checkLatte:CheckBox = findViewById(R.id.checkBoxLatte)
        val checkDecaf:CheckBox = findViewById(R.id.checkDecaf)

        val buttonPay: Button = findViewById(R.id.button)
        buttonPay.setOnClickListener{
            var sb = StringBuilder()
            if (checkAmericano.isChecked)sb.append(" Americano ")
            if (checkLatte.isChecked)sb.append(" Latte ")
            if (checkDecaf.isChecked)sb.append(" Decaf ")
            sb.append(" are order. Thanks!")

            Toast.makeText(applicationContext,
                sb.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}