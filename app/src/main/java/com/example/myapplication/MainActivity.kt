package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View.generateViewId
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //layout 객체
        val myLayout = ConstraintLayout(this)
        myLayout.id = generateViewId()

        val oval = ShapeDrawable(OvalShape())
        val px = convertUnitToPixel(200,TypedValue.COMPLEX_UNIT_DIP)
        oval.apply{
            intrinsicHeight = px
            intrinsicWidth = px
            paint.color = Color.BLUE
        }

        val myTextView = TextView(this)
        val spx = convertUnitToPixel(24,TypedValue.COMPLEX_UNIT_DIP)
        myTextView.apply {
            id = generateViewId()
            background = oval
            text = "My Text"
            textSize = spx.toFloat()
            setTextColor(Color.WHITE)
            isAllCaps = false
            gravity = Gravity.CENTER
        }
        myLayout.addView(myTextView)

        val set = ConstraintSet()
        set.apply {
            constrainHeight(myTextView.id, ConstraintSet.WRAP_CONTENT)
            constrainWidth(myTextView.id, ConstraintSet.WRAP_CONTENT)
            connect(myTextView.id, ConstraintSet.START,ConstraintSet.PARENT_ID, ConstraintSet.START, 0)
            connect(myTextView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0)
            connect(myTextView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
            connect(myTextView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        }

        set.applyTo(myLayout)
        setContentView(myLayout)
    }

    private fun convertUnitToPixel(value: Int, unit: Int): Int {
        return TypedValue.applyDimension(
            unit, value.toFloat(), resources.displayMetrics
        ).toInt()
    }
}