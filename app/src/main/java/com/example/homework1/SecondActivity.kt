package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textView = TextView(this)
        textView.textSize = 26f
        textView.setPadding(16, 16, 16, 16)
        val arguments = intent.extras
        if (arguments != null) {
            val name = arguments["name"].toString()
            val company = arguments.getString("company")
            val age = arguments.getInt("age")
            textView.text = """
            Name: $name
            Company: $company
            Age: $age
            """.trimIndent()
        }
        setContentView(textView)
    }


    fun onClick(v: View?) {
        val nameText = findViewById<EditText>(R.id.name)
        val companyText = findViewById<EditText>(R.id.company)
        val ageText = findViewById<EditText>(R.id.age)
        val name = nameText.text.toString()
        val company = companyText.text.toString()
        val age = ageText.text.toString().toInt()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("company", company)
        intent.putExtra("age", age)
        startActivity(intent)
    }
}