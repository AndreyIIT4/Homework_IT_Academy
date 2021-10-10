package com.example.homework1

import java.lang.Exception
import java.util.*

open class Calculator {
    var a: Double? = null
    var b: Double? = null
    var c: Double? = null
    var command: String? = ""
    var z = false

    fun entryA() {
        try {
            val scan = Scanner(System.`in`)
            println("Enter the number A:")
            a = scan.nextDouble()
        } catch (e: Exception) {
            System.err.println("Error input numbers A")
            System.exit(0)
        }
    }

    fun entryB() {
        try {
            val scan = Scanner(System.`in`)
            println("Enter the number B:")
            b = scan.nextDouble()
        } catch (e1: Exception) {
            System.err.println("Error input numbers B")
            System.exit(0)
        }
    }

    fun addition() {
        entryA()
        entryB()
        c = a!! + b!!
        println(a.toString() + "+" + b + "=" + c)
    }

    fun subtraction() {
        entryA()
        entryB()
        c = a!! - b!!
        println(a.toString() + "-" + b + "=" + c)
    }

    fun multiplication() {
        entryA()
        entryB()
        c = a!! * b!!
        println(a.toString() + "*" + b + "=" + c)
    }

    fun division() {
        entryA()
        entryB()
        c = a!! / b!!
        println(a.toString() + "/" + b + "=" + c)
    }

    fun involution() {
        entryA()
        entryB()
        c = Math.pow(a!!, b!!)
        println(a.toString() + "^" + b + "=" + c)
    }

    fun commands() {
        val com = Scanner(System.`in`)
        println("Please enter command:")
        command = com.nextLine()
    }

    fun main() {
        val calc = Calculator()
        calc.body()
    }

    fun body() {
        println("A list of available commands:")
        println("addition(A+B)")
        println("subtraction(A-B)")
        println("multiplication(A*B)")
        println("division(A/B)")
        println("involution(A^B)")
        println("exit")
        val calc = Calculator()
        while (true.also { calc.z = it }) {
            calc.commands()
            when (calc.command) {
                "addition" -> calc.addition()
                "subtraction" -> calc.subtraction()
                "multiplication" -> calc.multiplication()
                "division" -> calc.division()
                "involution" -> calc.involution()
                "exit" -> System.exit(0)
                else -> println("Error!Such commands do not exist!")
            }
        }
    }
}