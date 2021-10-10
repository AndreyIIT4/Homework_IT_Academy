package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        findViewById<Button>(R.id.gotovo)?.setOnClickListener {
            val name = findViewById<EditText>(R.id.editName)
            val nameString = name.text.toString()
            print(nameString)
            intent = Intent()
            intent.putExtra("nameS", nameString)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}