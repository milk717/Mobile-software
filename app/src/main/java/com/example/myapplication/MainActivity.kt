package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //setContentView(MyView(this))

        //비트맵을 만들고
        val myBitmap = Bitmap.createBitmap(
            800,600,Bitmap.Config.ARGB_8888)
        //그 비트맵을 캔버스 객체에 할당한다.
        val myCanvas = Canvas(myBitmap)
        myCanvas.drawColor(Color.argb(255, 0, 0, 255))

        val paint = Paint()
        paint.textSize = 100f
        paint.color = Color.argb(255, 255, 255, 255)
        myCanvas.drawText("Hello World!", 100f, 100f, paint)

        paint.color = Color.argb(255, 255, 255, 0)
        myCanvas.drawCircle(400f, 300f, 100f, paint)

        val myImageView = ImageView(this)
        myImageView.setImageBitmap(myBitmap)    //비트맵 공간을 이미지 뷰에 할당?
        setContentView(myImageView)
    }

}