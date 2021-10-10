package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.button)?.setOnClickListener {
            val nameText = findViewById<EditText>(R.id.name)
            val companyText = findViewById<EditText>(R.id.company)
            val ageText = findViewById<EditText>(R.id.age)
            val name = nameText.text.toString()
            val company = companyText.text.toString()
            val age = ageText.text.toString().toInt()

            Intent(this, ThirdActivity::class.java).apply {
                putExtra("name", name)
                putExtra("company", company)
                putExtra("age", age)
            }.let {
                startActivity(it)
            }
        }
    }

}