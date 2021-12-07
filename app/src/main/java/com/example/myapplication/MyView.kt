package com.example.myapplication

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator

const val RADIUS = 100f
class MyView(context: Context):View(context){
  private var my:Float = RADIUS
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.YELLOW) //배경색 지정

        val paint = Paint()
        paint.color = Color.RED
        canvas?.drawCircle(550f,my,RADIUS,paint)        //원 그리기
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_DOWN){   //터치 눌렸을 때
            val valueAnim = ValueAnimator.ofFloat(RADIUS, height-RADIUS)
            valueAnim.apply {
                duration = 2000     //애니메이션이 진행되는 속도
                interpolator = AccelerateInterpolator()
                start()
            }
            valueAnim.addUpdateListener { animation ->
                my = animation?.animatedValue as Float
                invalidate()
            }
            return true
        }
        return super.onTouchEvent(event)
    }
}