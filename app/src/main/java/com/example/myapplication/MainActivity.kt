package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity(){
    private val fruitViewModel: FruitViewModel by lazy{
        ViewModelProvider(this).get(FruitViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment  = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,FruitFragment())
                .commit()

        }
    }


}

