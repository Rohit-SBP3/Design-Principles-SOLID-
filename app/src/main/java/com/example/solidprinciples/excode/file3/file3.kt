package com.example.solidprinciples.excode.file3

/*** SOLID Principles:-

 SOLID is a set of five object-oriented design principles that make software
 more maintainable, scalable, and robust.

 1. Single Responsibility Principle (SRP)
    "A class should have only one reason to change."
    → Each class should do one thing and do it well.

 2. Open/Closed Principle (OCP)
    "Software should be open for extension but closed for modification."
    → Extend behavior without changing existing code (use interfaces/abstractions).

 3. Liskov Substitution Principle (LSP)
    "Subclasses should be substitutable for their parent class."
    → Child classes must not break parent class behavior.

 4. Interface Segregation Principle (ISP)
    "Clients shouldn’t depend on interfaces they don’t use."
    → Prefer small, focused interfaces over large monolithic ones.

 5. Dependency Inversion Principle (DIP)
    "Depend on abstractions, not concrete implementations."
    → High-level modules should not depend on low-level details.

 Principle	                  Key Idea	                            Kotlin Solution
 Single Responsibility	      One class = One job	                Split into UserRepo, EmailService
 Open/Closed	              Extend without modifying	            Use interfaces (PaymentMethod)
 Liskov Substitution	      Subclasses shouldn’t break parents	Penguin doesn’t extend FlyingBird
 Interface Segregation	      Avoid "fat" interfaces	            Workable, Eatable (small interfaces)
 Dependency Inversion	      Depend on abstractions	            Switch depends on Switchable

 ***/

// Single Responsibility Principle's ❌ Violation
class User {
    fun saveToDb(user: User) { /* DB logic */ }
    fun sendEmail(user: User) { /* Email logic */ }
    fun validate(user: User) { /* Validation logic */ }
}

// Open/Closed Principle's ❌ Violation
class PaymentProcessor {
    fun processPayment(type: String) {
        when (type) {
            "credit" -> processCreditCard()
            "paypal" -> processPayPal()
            else -> throw Error("Unsupported")
        }
    }

    private fun processCreditCard() = println("Processing")

    private fun processPayPal() = println("Processing")
}

// Liskov Substitution Principle's ❌ Violation
open class Bird {
    open fun fly() = println("Flying")
}

class Penguin : Bird() {
    override fun fly() = throw Error("Penguins can't fly!") // Breaks LSP!
}

// Interface Segregation Principle's ❌ Violation
interface Worker {
    fun work()
    fun eat()
    fun sleep()
}

class Robot : Worker {  // Robot doesn’t need eat() or sleep()!
    override fun work() = println("Working")
    override fun eat() = throw Error("Robots don’t eat!")
    override fun sleep() = throw Error("Robots don’t sleep!")
}

// Dependency Inversion Principle's ❌ Violation
class LightBulb {
    fun turnOn() = println("Bulb on")
}

class Switch {
    private val bulb = LightBulb()  // Direct dependency
    fun operate() = bulb.turnOn()
}
