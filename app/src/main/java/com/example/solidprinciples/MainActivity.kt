package com.example.solidprinciples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.solidprinciples.ui.theme.SolidPrinciplesTheme

/*** Design Principles

 * Software design principles are guidelines and best practices that help developers create software
   that is Robust, Scalable, Maintainable and easy to understand.

 * for ex: SOLID, Do not Repeat Yourself (DRY), You Are not Gonna Need It(YAGNI), Favor composition over inheritance,
           Separation of Concerns (SoC), Encapsulate what varies, Cohesion, Coupling etc.

 Concept   Good Means…                      Benefits
 --------  -------------------------------  ------------------------
 Cohesion  Class does one thing well        Easy to maintain & reuse
 Coupling  Classes/modules are independent  Flexible and testable

 * High cohesion and low coupling.

 ***/

/*** SOLID
 🔹 S — Single Responsibility Principle (SRP):- A class should have only one reason to change.
 🔹 O — Open/Closed Principle (OCP):- Software entities should be open for extension, but closed for modification.
 🔹 L — Liskov Substitution Principle (LSP):- Subtypes must be substitutable for their base types.
 🔹 I — Interface Segregation Principle (ISP):- Clients should not be forced to depend on methods they do not use.
 🔹 D — Dependency Inversion Principle (DIP):- Depend on abstractions, not on concretions.

Summary:
Principle	   Goal	                                 Android Example
SRP	           One reason to change	                 ViewModel handles logic
OCP	           Extend, don’t modify	                 Use sealed classes/interfaces
LSP	           Replace base with subclass	         BaseActivity vs MainActivity
ISP	           Small interfaces	                     Clickable vs LongClickable
DIP	           Depend on abstraction	             Inject interfaces via Hilt */

/***

 Program to an Interface, Not an Implementation.
 ex-code - file1

 Favor Composition over Inheritance
 ex-code - file2

 SOLID Principles
 ex-code - file3

***/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SolidPrinciplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { i ->
                    Text(text = "Lets Learn")
                    Spacer(modifier = Modifier.padding(i))
                    Text(text = "SOLID Principles!")
                }
            }
        }
    }
}