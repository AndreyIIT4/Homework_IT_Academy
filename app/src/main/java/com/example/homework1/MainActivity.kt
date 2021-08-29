package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.reg)?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)


            //setResult(RESULT_OK, Intent().putExtra(EXTRA_MESSAGE, getString(R.string.app_name)))
            //finish()
        }
    }
}