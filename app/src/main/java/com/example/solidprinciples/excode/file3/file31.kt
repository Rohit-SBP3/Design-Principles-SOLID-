package com.example.solidprinciples.excode.file3


fun main(){

    /*val flyingBird = FlyingBird()
    flyingBird.fly()
    flyingBird.eat()

    val swimmingBirds = SwimmingBirds()
    swimmingBirds.swim()
    swimmingBirds.eat()
    swimmingBirds.hasFeathers()*/

    val c = CeilingFan()
    val l = LightBulb()
    val s1 = Switch(c)
    val s2 = Switch(l)
    s1.operate()
    s2.operate()
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
interface Excretion { fun excrete() }
interface Chargeable { fun charge() }

class Human : Workable, Eatable, Sleepable, Excretion { /* Implements all */
    override fun work() {
        println("Human is Working")
    }

    override fun eat() {
        println("Human is Eating")
    }

    override fun sleep() {
        println("Human is Sleeping")
    }

    override fun excrete() {
        println("Human is Excreting")
    }
}
class Robot : Workable, Chargeable {
    
    override fun work() {
        println("Robot is Working")
    }

    override fun charge() {
        println("Robot is being Charged!")
    }
}

// Dependency Inversion Principle's ✅ Solution
interface Switchable {
    fun turnOn()
}

class LightBulb : Switchable {
    override fun turnOn() = println("Bulb on")
}

class CeilingFan: Switchable {
    override fun turnOn() {
        println("Fan is on")
    }
}

class Switch(private val device: Switchable) {  // Depends on abstraction
    fun operate() = device.turnOn()
}