package com.example.homework1.model
import  com.github.javafaker.Faker

class FakeService {
    val fakes: List<FakeObject> = (1..50).map {FakeObject(
            id = it,
            firstName = Faker.instance().name().firstName(),
            lastName = Faker.instance().name().lastName()
        )
    }
}