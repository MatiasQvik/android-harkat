package com.example.androiddevcert

open class Phone(var isScreenLightOn: Boolean = false){

    var switchedOn: Boolean = true

    open fun switchOn() {
        switchedOn = true
        isScreenLightOn = true
    }

    open fun switchOff() {
        switchedOn = false
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn && switchedOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(private var isFolded : Boolean = true) : Phone() {

    override fun switchOn() {
        if (!isFolded) isScreenLightOn = true
        switchedOn = true
    }

    fun fold() {
        isFolded = true
        isScreenLightOn = false
        switchedOn = false
    }

    fun unfold() {
        isFolded = false
        isScreenLightOn = true
    }
}