package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.reg)?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val duration = Toast.LENGTH_SHORT

        val arguments = intent.extras
        if (arguments != null) {

            val counter=arguments.getInt("counter")
            val textReg=arguments.getString("registration")
            val text =textReg+" "+counter.toString()
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }
}