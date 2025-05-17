package com.example.solidprinciples.excode.file2

fun main(){

    val w = Warrior()
    w.move()
    w.attack()

    val m = Mage()
    m.move()
    m.castSpell()
}


// Problem: Rigid class hierarchy using inheritance
open class CCharacter {
    open fun move() = println("Character moves")
}

class Warrior : CCharacter() {
    fun attack() = println("Warrior attacks with sword")
}

class Mage : CCharacter() {
    fun castSpell() = println("Mage casts fireball")
}

// Limitations:
// 1. Can't easily make a Spell-casting Warrior
// 2. Changing Character affects all subclasses