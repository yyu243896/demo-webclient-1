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


fun addNumber(a:Int, b:Int, mylambda:(Int) -> Unit) {
    val sum = a + b
    mylambda(sum)
}

fun main(args: Array<String>)
{
    val mylambda: (Int) -> Unit = {s:Int -> println(s)}
    addNumber(5,10, mylambda)


//    Stringar number = 44
//    var numberProvided = when(number) {
//        1->"One"
//        2->"Two"
//        3->"Three"
//        4->"Four"
//        5->"Five"
//        else -> "invalid number"
//    }
//
//    println("You provide $numberProvided")
//
//
//
//    val u = UserDetail("Ashu", 101, "mydream77@mail.com")
//    println(u)
//    val obj = InterfaceImp()
//    println("Calling overriding id value = ${obj.id}")
//    obj.doSomthing()
//    println(obj.absMethod())
}
