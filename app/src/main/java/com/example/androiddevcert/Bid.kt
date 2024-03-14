package com.example.androiddevcert

class Bid (val amount: Int, val bidder: String) {

}
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}