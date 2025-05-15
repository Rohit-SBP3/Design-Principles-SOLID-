package com.example.solidprinciples.excode.file1

class Engine1 {
    fun start() {
        println("Engine is started!!!")
    }
}

class Car1 {

    private val engine = Engine1() // Tight coupling

    fun drive() {
        engine.start()
        println("Car is Driving!!")
    }
}
