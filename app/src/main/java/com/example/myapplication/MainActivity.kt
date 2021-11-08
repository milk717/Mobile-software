package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        registerForContextMenu(textView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_main,menu)
    }

    override fun onContextItemSelected(item: MenuItem)=
        when (item.itemId){
            R.id.menu_yellow->{
                textView.setBackgroundColor(Color.YELLOW)
                true
            }
            R.id.menu_green->{
                textView.setBackgroundColor(Color.GREEN)
                true
            }
            R.id.menu_blue->{
                textView.setBackgroundColor(Color.BLUE)
                true
            }
            else->super.onContextItemSelected(item)
        }


}

