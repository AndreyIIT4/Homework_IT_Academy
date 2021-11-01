package com.example.homework1

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.blackButton).setOnClickListener {
        }
        findViewById<ImageButton>(R.id.redButton).setOnClickListener {}
        findViewById<ImageButton>(R.id.blueButton).setOnClickListener {}
        findViewById<ImageButton>(R.id.yellowButton).setOnClickListener {}
        findViewById<ImageButton>(R.id.orangeButton).setOnClickListener {}
        findViewById<ImageButton>(R.id.greenButton).setOnClickListener {}
        findViewById<ImageButton>(R.id.pinkButton).setOnClickListener {}
        findViewById<ImageButton>(R.id.purpleButton).setOnClickListener {}
        val ds =findViewById<Button>(R.id.clear)

            ds.setOnClickListener {
        }
    }
}

