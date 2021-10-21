package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework1.model.AppContract
import com.example.homework1.model.FakeObject
import com.example.homework1.model.FakeService

class MainActivity : AppCompatActivity(), AppContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.fragment_container,
                    AFragment()
                )
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override val fakeService: FakeService
        get() = (applicationContext as App).fakeService

    override fun fakeLastName(fakeObject: FakeObject) {
        val fragment = BFragment.newInstance(fakeObject)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}