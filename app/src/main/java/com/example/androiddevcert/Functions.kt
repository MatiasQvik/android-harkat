package com.example.androiddevcert

class Functions {

    fun starterFunction() {
        val amanda = Person("Amanda", 33, "play tennis", null)
        val atiqah = Person("Atiqah", 28, "climb", amanda)

        amanda.showProfile()
        atiqah.showProfile()


        val newFoldablePhone = FoldablePhone()

        newFoldablePhone.switchOn()
        newFoldablePhone.checkPhoneScreenLight()
        newFoldablePhone.unfold()
        newFoldablePhone.switchOn()
        newFoldablePhone.checkPhoneScreenLight()
        newFoldablePhone.switchOff()
        newFoldablePhone.checkPhoneScreenLight()
        newFoldablePhone.unfold()
        newFoldablePhone.checkPhoneScreenLight()
        newFoldablePhone.switchOn()
        newFoldablePhone.fold()
        newFoldablePhone.checkPhoneScreenLight()
        newFoldablePhone.unfold()
        newFoldablePhone.switchOn()
        newFoldablePhone.checkPhoneScreenLight()

        val winningBid = Bid(5000, "Private Collector")
        println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
        println("Item B is sold at ${auctionPrice(null, 3000)}.")
    }
    
    fun notifStarter() {
        val mNotif = 51
        val eNotif = 135

        printNotifSummary(mNotif)
        printNotifSummary(eNotif)
    }

    private fun printNotifSummary(notifAmount: Int) {
        if (notifAmount >= 99) {
            println("MATU: Your phone is blowing up! You have 99+ notifications")
        }   else {
            println("MATU: You have $notifAmount notifications")
        }
    }

    fun tempCalculator(degrees: Double, initialUnit: String) {

        when (initialUnit) {
            "C" -> printFinalTemperature(degrees, initialUnit, "F") {it * 9.0 / 5.0 + 32}
            "F" -> printFinalTemperature(degrees, initialUnit, "K") {(it -32) * 5.0 / 9.0 + 273.15}
            "K" -> printFinalTemperature(degrees, initialUnit, "C") {it - 273.15}
            else -> error("Invalid unit in tempCalculator")
        }
    }


    private fun printFinalTemperature(
        initialMeasurement: Double,
        initialUnit: String,
        finalUnit: String,
        conversionFormula: (Double) -> Double
    ) {
        val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
        println("MATU: $initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
    }

}