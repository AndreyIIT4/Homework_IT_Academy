package com.example.homework1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.*
import android.graphics.drawable.Drawable

import android.graphics.Bitmap


class PainterView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
    View(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        -1
    )

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, -1, -1)

    constructor(context: Context?) : this(context, null, -1, -1)

    private var isDrawingStarted: Boolean = false
    private val drawingPointList: MutableList<PointF> = LinkedList()
    private val paint = Paint().apply {
        color = Color.BLACK
    }
    private var bitmap: Bitmap? = null

    override fun onDraw(canvas: Canvas?) {
        if (canvas != null) {
            bitmap?.let {
                canvas.drawBitmap(it, this.x, this.y, paint)
            }
            if (isDrawingStarted && drawingPointList.size >= 2) {
                val lastPoint = drawingPointList.last()
                val preLastPoint = drawingPointList[drawingPointList.size - 2]
                canvas.drawLine(preLastPoint.x, preLastPoint.y, lastPoint.x, lastPoint.y, paint)
                drawingPointList.clear()
                drawingPointList.add(lastPoint)
            }
        }

        super.onDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_UP -> handleActionUp(it)
                MotionEvent.ACTION_DOWN -> handleActionDown(it)
                MotionEvent.ACTION_MOVE -> handleActionMove(it)
            }
        }
        return isDrawingStarted || super.onTouchEvent(event)
    }

    private fun handleActionMove(event: MotionEvent) {
        if (isDrawingStarted) {
            drawingPointList.add(PointF(event.x, event.y))
            bitmap = getBitmapFromView(this)
            invalidate()
        }
    }

    private fun handleActionDown(event: MotionEvent) {
        if (!isDrawingStarted) {
            isDrawingStarted = true
            drawingPointList.add(PointF(event.x, event.y))
        }

    }

    private fun handleActionUp(event: MotionEvent) {
        if (isDrawingStarted) {
            isDrawingStarted = false
            drawingPointList.add(PointF(event.x, event.y))
            bitmap = getBitmapFromView(this)
            invalidate()
        }
    }

    private fun getBitmapFromView(view: View): Bitmap {
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        view.draw(canvas)

        return returnedBitmap
    }
}