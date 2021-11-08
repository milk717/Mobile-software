package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var layoutView: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutView = findViewById(R.id.layoutView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when(item.itemId){
            R.id.menu_apple->{
                layoutView.setBackgroundColor(Color.RED)
                item.isChecked = false
                showToast(item.title.toString())
                true
            }
            R.id.menu_graph->{
                layoutView.setBackgroundColor(Color.MAGENTA)
                item.isChecked = false
                showToast(item.title.toString())
                true
            }
            R.id.menu_banana->{
                layoutView.setBackgroundColor(Color.YELLOW)
                item.isChecked = false
                showToast(item.title.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun showToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}

