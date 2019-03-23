package com.hfad.pokercombV2.models



class Card (

        private var pic: String,
        private var rank: Int,
        private var suit: Int

) {

    fun getPic(): String {
        return pic
    }

    fun getRank(): Int {
        return rank
    }

    fun getSuit(): Int {
        return suit
    }

}