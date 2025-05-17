package com.example.solidprinciples.excode.file2

/***

 Composition over Inheritance means:
 Prefer using objects (composition) instead of parent-child class hierarchies (inheritance) for code reuse.
 Why? Inheritance can lead to tight coupling, while composition offers flexibility and easier maintenance.

 When to Use Each:
 Inheritance: Only for true "is-a" relationships (e.g., Player is a Character)
 Composition: For "has-a" capabilities (e.g., Character has movement behavior)

 ***/

// Solution: Flexible composition with interfaces
interface Movable {
    fun move()
}

interface Attacker {
    fun attack()
}

interface SpellCaster {
    fun castSpell()
}

// Behavior implementations
class WalkMovement : Movable {
    override fun move() = println("Walking normally")
}

class TeleportMovement : Movable {
    override fun move() = println("Teleporting magically")
}

class SwordAttack : Attacker {
    override fun attack() = println("Swinging sword")
}

class FireballSpell : SpellCaster {
    override fun castSpell() = println("Casting fireball")
}

// Character composed of behaviors
class Character(
    private val movable: Movable,
    private val attacker: Attacker? = null,
    private val spellCaster: SpellCaster? = null
) {
    fun move() = movable.move()
    fun attack() = attacker?.attack() ?: println("Cannot attack")
    fun castSpell() = spellCaster?.castSpell() ?: println("Cannot cast spells")
}

// Usage Examples
fun main() {

    // Standard Warrior
    val warrior = Character(
        movable = WalkMovement(),
        attacker = SwordAttack()
    )

    // Standard Mage
    val mage = Character(
        movable = TeleportMovement(),
        spellCaster = FireballSpell()
    )

    // Hybrid Character (composition shines!)
    val spellsword = Character(
        movable = WalkMovement(),
        attacker = SwordAttack(),
        spellCaster = FireballSpell()
    )

    println("Warrior:")
    warrior.move()
    warrior.attack()
    warrior.castSpell()  // Gracefully handles missing capability

    println("\nMage:")
    mage.move()
    mage.attack()        // Gracefully handles missing capability
    mage.castSpell()

    println("\nSpellsword:")
    spellsword.move()
    spellsword.attack()
    spellsword.castSpell()
}
