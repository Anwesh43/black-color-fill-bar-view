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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Int.red(sc: Float) : Int = (Color.red(this) * sc).toInt()
fun Int.green(sc: Float) : Int = (Color.green(this) * sc).toInt()
fun Int.blue(sc: Float) : Int = (Color.blue(this) * sc).toInt()
fun Int.update(sc : Float) : Int = Color.argb(255, red(sc), green(sc), blue(sc))

fun Canvas.drawBlackColorFillBar(color : Int, sc : Float, size : Float, w : Float, paint : Paint) {
    val sc1 : Float = sc.divideScale(0, 2)
    val sc2 : Float = sc.divideScale(1, 2)
    val wBar : Float = size + (w - size) * sc2
    paint.color = color.update(sc1)
    drawRect(RectF(-wBar, -size, wBar, size), paint)
}

fun Canvas.drawBCFBNode(i : Int, sc : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (colors.size + 1)
    val size : Float = gap / sizeFactor
    save()
    translate(w / 2, gap * (i + 1))
    drawBlackColorFillBar(Color.parseColor(colors[i]), sc, size, w / 2, paint)
    restore()
}

class BlackColorFillBarView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }

    data class State(var scale : Float = 0f, var dir : Float = 0f, var prevScale : Float = 0f) {

        fun update(cb : (Float) -> Unit) {
            scale += scGap * dir
            if (Math.abs(scale - prevScale) > 1) {
                scale = prevScale + dir
                dir = 0f
                prevScale = scale
                cb(prevScale)
            }
        }

        fun startUpdating(cb : () -> Unit) {
            if (dir == 0f) {
                dir = 1f - 2 * prevScale
                cb()
            }
        }
    }
}