package com.example.solidprinciples.excode.file3


fun main(){

    val flyingBird = FlyingBird()
    flyingBird.fly()
    flyingBird.eat()

    val swimmingBirds = SwimmingBirds()
    swimmingBirds.swim()
    swimmingBirds.eat()
    swimmingBirds.hasFeathers()
}


// Single Responsibility Principle's ✅ Solution
class UserRepository {
    fun saveToDb(user: User) { println("Saved to Db!!!") }
}

class EmailService {
    fun sendEmail(user: User) { println("Email Sent!!!") }
}

class UserValidator {
    fun validate(user: User) { println("Validating!!!") }
}


// Open/Close Principle's ✅ Solution
interface PaymentMethod {
    fun process()
}

class CreditCard : PaymentMethod {
    override fun process() { println("Processing Payment using Credit Card!") }
}

class PayPal : PaymentMethod {
    override fun process() = println("Processing Payment using Paypal!")
}

class UPI: PaymentMethod {
    override fun process() =  println("Processing Payment using UPI!")
}

class PaymentProcessor {
    fun processPayment(method: PaymentMethod) {
        method.process()  // No changes needed for new methods!
    }
}

// Liskov Substitution Principle's ✅ Solution
open class MBird {
    fun hasFeathers(): Boolean = true
    fun eat() = println("Eating")
}

open class FlyingBird : MBird() {
    fun fly() = println("Flying")
}

open class SwimmingBirds: MBird() {
    fun swim() = println("Swimming")
}

class Penguin : SwimmingBirds()  // No fly() method, so no violation


// Interface Segregation Principle's ✅ Solution
interface Workable { fun work() }
interface Eatable { fun eat() }
interface Sleepable { fun sleep() }

class Human : Workable, Eatable, Sleepable { /* Implements all */
    override fun work() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }
}
class Robot : Workable { /* Only implements work() */
    override fun work() {
        TODO("Not yet implemented")
    }
}

// Dependency Inversion Principle's ✅ Solution
interface Switchable {
    fun turnOn()
}

class LightBulb : Switchable {
    override fun turnOn() = println("Bulb on")
}

class Switch(private val device: Switchable) {  // Depends on abstraction
    fun operate() = device.turnOn()
}

// Usage:
val bulb = LightBulb()
val switch = Switch(bulb)  // Can switch ANY Switchable device