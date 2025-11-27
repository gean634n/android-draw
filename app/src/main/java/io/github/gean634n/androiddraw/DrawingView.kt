package io.github.gean634n.androiddraw

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 8f
        isAntiAlias = true
    }

    private val points = mutableListOf<Pair<Float, Float>>()

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        points.add(x to y)
        invalidate()

        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (i in 1 until points.size) {
            val  (x1, y1) = points[i -1]
            val  (x2, y2) = points[i]
            canvas.drawLine(x1, y1, x2, y2, paint)
        }
    }
}