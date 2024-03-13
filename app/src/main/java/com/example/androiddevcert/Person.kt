package com.example.androiddevcert

class Person(private val name: String, private val age: Int, private val hobby: String?, private val referrer: Person?) {
    fun showProfile() {
        if (referrer != null){
        println("Name: $name\nAge: $age\nLikes to $hobby. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}")
        } else {
            println("Name: $name\nAge: $age\nLikes to $hobby. Doesn't have referrer")
        }
    }
}