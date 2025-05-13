package com.example.solidprinciples.excode.file1

private interface Engine12{
    fun start()
}

class PetrolEngine: Engine12{
    override fun start() {
        println("Petrol Engine is Started!!")
    }
}

private class Car12(private val engine: Engine12) { // Dependency Injection

    fun drive() {
        engine.start()
        println("Car is Driving!!")
    }
}

fun main(){
    val car = Car12(PetrolEngine())
    car.drive()
}
