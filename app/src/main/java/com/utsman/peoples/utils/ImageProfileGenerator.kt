package com.utsman.peoples.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.util.*
import kotlin.math.roundToInt

object ImageProfileGenerator {

    private fun darker(color: Int): Int {
        val factor = 0.8f
        val a = Color.alpha(color)
        val r = (Color.red(color) * factor).roundToInt()
        val g = (Color.green(color) * factor).roundToInt()
        val b = (Color.blue(color) * factor).roundToInt()
        return Color.argb(
            a,
            r.coerceAtMost(255),
            g.coerceAtMost(255),
            b.coerceAtMost(255)
        )
    }

    private fun randomColor(): Int {
        val random = Random()
        val color = Color.argb(
            255,
            random.nextInt(),
            random.nextInt(256),
            random.nextInt(256)
        )

        return darker(color)
    }

    fun generate(name: String): Bitmap {
        val text = name.first().toString().lowercase()
        val height = 200
        val width = 200
        val newBitmap = Bitmap.createBitmap(
            width,
            height, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(newBitmap)
        canvas.drawColor(randomColor())
        val fontHeight = canvas.height / 2f
        val pText = Paint()
        pText.color = Color.WHITE
        pText.textSize = fontHeight
        val x = (newBitmap.width - pText.measureText(text)) / 2f
        val y = (height / 2f) + ((fontHeight / 2f) / 1.5f)
        canvas.drawText(text, x, y, pText)
        canvas.drawBitmap(newBitmap, 0f, 0f, null)

        return newBitmap

    }
}