package com.anwesh.uiprojects.blackcolorfillbarview

/**
 * Created by anweshmishra on 06/10/19.
 */

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Color

val colors : Array<String> = arrayOf("#4CAF50", "#f44336", "#3F51B5", "#E65100", "#1A237E")
val scGap : Float = 0.01f
val sizeFactor : Float = 2.9f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20
