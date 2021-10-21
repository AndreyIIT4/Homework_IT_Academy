package com.example.homework1.model

import java.io.Serializable

data class FakeObject(
    val id: Int,
    val firstName: String,
    val lastName: String,
) : Serializable {
    override fun toString(): String {
        return firstName
    }
}