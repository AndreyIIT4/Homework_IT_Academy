package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val arguments = intent.extras
        if (arguments != null) {
            val name = arguments["name"].toString()
            val company = arguments.getString("company")
            val age = arguments.getInt("age")
            val registration = name + " " + company + " " + age.toString()

            findViewById<Button>(R.id.gotomain)?.setOnClickListener {
                val counterText = findViewById<EditText>(R.id.count)
                val counter = counterText.text.toString().toInt()
                Intent(this, MainActivity::class.java).apply {
                    putExtra("counter", counter)
                    putExtra("registration", registration)
                }.let { startActivity(it) }
            }
        }
    }
}