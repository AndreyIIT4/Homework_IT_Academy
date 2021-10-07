package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.reg)?.setOnClickListener {
            Intent(this, SecondActivity::class.java).let {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.nextact)?.setOnClickListener {
            Intent(this, ResultActivity::class.java).let {
                startActivityForResult(it, 1)
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        this.intent = intent
    }

    override fun onResume() {
        super.onResume()
        val arguments = intent.extras
        if (arguments != null) {
            val counter = arguments.getInt("counter")
            val textReg = arguments.getString("registration")
            val text = textReg + " " + counter.toString()
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            Toast.makeText(applicationContext, data.getStringExtra("nameS"), Toast.LENGTH_SHORT)
                .show()
        }
    }
}