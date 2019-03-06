package com.hfad.pokercomb.helper

import android.content.SharedPreferences
import com.hfad.pokercomb.models.Combination

class Constants {


    var rfName = "Royal flush"
    var rfDesc: String = "Five cards of the same suit in sequence 10 to Ace."
    var rfProbability: String = "Probability: 4 out of 2,6 million 0.0002%"
    var rfPics: String = "RF"

    var sfName = "Straight flush"
    var sfDesc: String = "Five cards in sequence of the same suit."
    var sfProbability: String = "Probability: 36 out of 2,6 million 0.0014%"
    var sfPics: String = "SF"

    var fkName = "Four of a kind"
    var fkDesc: String = "Four cards of the same rank."
    var fkProbability: String = "Probability: 624 out of 2,6 million 0.02%"
    var fkPics: String = "FK"

    var fhName = "Full house"
    var fhDesc: String = "Three matching cards of one rank and two matching cards of another rank."
    var fhProbability: String = "Probability: 3744 out of 2,6 million 0.14%"
    var fhPics: String = "FH"

    var fName = "Flush"
    var fDesc: String = "Five cards of the same suit."
    var fProbability: String = "Probability: 5108 out of 2,6 million 0.2%"
    var fPics: String = "F"

    var sName = "Straight"
    var sDesc: String = "Five cards in sequence of ranks."
    var sProbability: String = "Probability: 10200 out of 2,6 million 0.39%"
    var sPics: String = "S"

    var tkName = "Three of a kind"
    var tkDesc: String = "Three cards of the same rank."
    var tkProbability: String = "Probability: 54912 out of 2,6 million 2.11%"
    var tkPics: String = "TK"

    var tpName = "Two pair"
    var tpDesc: String = "Two pairs of matching cards by rank."
    var tpProbability: String = "Probability: 123552 out of 2,6 million 4.75%"
    var tpPics: String = "TP"

    var opName = "One pair"
    var opDesc: String = "Two cards of the same rank."
    var opProbability: String = "Probability: 1098240 out of 2,6 million 42.26%"
    var opPics: String = "OP"

    var hkName = "High card"
    var hkDesc: String = "The card with the highest rank."
    var hkProbability: String = "Probability: 1302540 out of 2,6 million 50.12%"
    var hkPics: String = "HC"

    var cardPics = arrayListOf(
            "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "jh", "qh", "kh", "ah",
            "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "jd", "qd", "kd", "ad",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "js", "qs", "ks", "as",
            "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "jc", "qc", "kc", "ac"
    )

    var cardCombos = arrayListOf("Royal flush","Straight flush","Four of a kind","Full house","Full house", "Flush","Straight","Three of a kind","Two pair","One pair","High card")

    val comboList = arrayListOf(
            Combination(rfName,rfDesc, rfProbability, rfPics),
            Combination(sfName,sfDesc, sfProbability, sfPics),
            Combination(fkName,fkDesc, fkProbability, fkPics),
            Combination(fhName,fhDesc, fhProbability, fhPics),
            Combination(fName,fDesc, fProbability, fPics),
            Combination(sName,sDesc, sProbability, sPics),
            Combination(tkName,tkDesc, tkProbability, tkPics),
            Combination(tpName,tpDesc, tpProbability, tpPics),
            Combination(opName,opDesc, opProbability, opPics),
            Combination(hkName,hkDesc, hkProbability, hkPics)
    )

    var cardRank = arrayListOf(2,3,4,5,6,7,8,9,10,11,12,13,14) //каждая цифра - определенная карта, 2 - двойка, 14 - туз
    var cardSuit = arrayListOf(1,2,3,4) //каждая цифра - опредленная масть, 1 - сердце, 2 - бубны, 3 - пики, 4 - трефы сделано для дальнейшего удобства




}