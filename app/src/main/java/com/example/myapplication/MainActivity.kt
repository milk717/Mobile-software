package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val  TAG = "Orientation"
class MainActivity : AppCompatActivity(){

    private lateinit var nameEditText: EditText
    private val KEY_NAME = "first_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        Log.d(TAG, "onCreate()호출")

        if(savedInstanceState != null){
            var strName = savedInstanceState.getString(KEY_NAME)
            nameEditText.setText(strName)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState()호출")

        var strName:String = nameEditText.text.toString()
        outState.putString(KEY_NAME, strName)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState()호출")
        var s = savedInstanceState.getString(KEY_NAME)
        Toast.makeText(applicationContext,"복원한 문자열은 $s",Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()호출")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()호출")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()호출")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()호출")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()호출")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()호출")
    }
}
