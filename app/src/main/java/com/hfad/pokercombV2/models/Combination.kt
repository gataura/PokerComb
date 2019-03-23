package com.hfad.pokercombV2.models

class Combination (

        private var comboName:String = "",
        private var comboDesc: String = "",
        private var probability: String = "",
        private var pics: String = ""

) {

    fun getComboName(): String {
        return comboName
    }

    fun getComboDesc(): String {
        return comboDesc
    }

    fun getProbability(): String {
        return probability
    }

    fun getPics(): String {
        return pics
    }

}