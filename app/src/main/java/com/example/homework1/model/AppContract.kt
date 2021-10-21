package com.example.homework1.model

import androidx.fragment.app.Fragment

fun Fragment.contract(): AppContract = requireActivity() as AppContract

interface AppContract {
    val fakeService: FakeService
    fun fakeLastName(fakeObject: FakeObject)
}