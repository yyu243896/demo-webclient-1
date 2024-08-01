package com.example.demo

class HelloWorld {
    fun print() {

        for (i in 1..3) {
            println("i = $i")
            if (i == 2) {
                continue
            }
            println("this is below if")
        }

        for (element in listOf("Ajay", "Vijay", "Prakash")) {
            println(element)
        }

        for (i in 5 downTo 2) print(i)
        println()
    }
}
