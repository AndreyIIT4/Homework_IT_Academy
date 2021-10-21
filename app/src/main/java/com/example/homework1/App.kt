package com.example.homework1

import android.app.Application
import com.example.homework1.model.FakeService

class App:Application () {
    val fakeService=FakeService()
}