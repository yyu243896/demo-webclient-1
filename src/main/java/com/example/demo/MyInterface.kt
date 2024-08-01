package com.example.demo

interface MyInterface {
    var id:Int
    fun absMethod(): String
    fun doSomthing() {
        println("MyInterface doing some work")
    }
}

class InterfaceImp() : MyInterface {
    override var id: Int = 101
    override fun absMethod(): String {
        return "Implementing abstract method..."
    }
}


data class UserDetail(var name: String, var id: Int, var email: String)


fun main(args: Array<String>) {
    val u = UserDetail("Ashu", 101, "mydream77@mail.com")
    println(u)
    val obj = InterfaceImp()
    println("Calling overriding id value = ${obj.id}")
    obj.doSomthing()
    println(obj.absMethod())
}
