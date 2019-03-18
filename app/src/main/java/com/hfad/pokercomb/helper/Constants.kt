package com.hfad.pokercomb.helper

import android.content.SharedPreferences
import com.hfad.pokercomb.models.Combination

class Constants {


    var rfName = "Флеш рояль"
    var rfDesc: String = "Туз, король, дама, валет и десятка одной масти."
    var rfProbability: String = "Вероятность: 4 из 2,6 миллионов 0.0002%"
    var rfPics: String = "RF"

    var sfName = "Стрит флеш"
    var sfDesc: String = "5 последовательных одномастных карт."
    var sfProbability: String = "Вероятность: 36 из 2,6 миллионов 0.0014%"
    var sfPics: String = "SF"

    var fkName = "Каре"
    var fkDesc: String = "4 карты одного ранга."
    var fkProbability: String = "Вероятность: 624 из 2,6 миллионов 0.02%"
    var fkPics: String = "FK"

    var fhName = "Фулл хауз"
    var fhDesc: String = "Три карты одного ранга и две карты другого ранга."
    var fhProbability: String = "Вероятность: 3744 из 2,6 миллионов 0.14%"
    var fhPics: String = "FH"

    var fName = "Флеш"
    var fDesc: String = "Пять карт одной масти."
    var fProbability: String = "Вероятность: 5108 из 2,6 миллионов 0.2%"
    var fPics: String = "F"

    var sName = "Стрит"
    var sDesc: String = "Пять последовательных по рангу карт."
    var sProbability: String = "Вероятность: 10200 из 2,6 миллионов 0.39%"
    var sPics: String = "S"

    var tkName = "Тройка (трипс)"
    var tkDesc: String = "Три карты одного ранга."
    var tkProbability: String = "Вероятность: 54912 из 2,6 миллионов 2.11%"
    var tkPics: String = "TK"

    var tpName = "Две пары"
    var tpDesc: String = "Две карты одного ранга + две карты другого ранга."
    var tpProbability: String = "Вероятность: 123552 из 2,6 миллионов 4.75%"
    var tpPics: String = "TP"

    var opName = "Пара"
    var opDesc: String = "Две карты одного ранга."
    var opProbability: String = "Вероятность: 1098240 из 2,6 миллионов 42.26%"
    var opPics: String = "OP"

    var hkName = "Старшая карта"
    var hkDesc: String = "Карта старшего ранга."
    var hkProbability: String = "Вероятность: 1302540 из 2,6 миллионов 50.12%"
    var hkPics: String = "HC"

    var cardPics = arrayListOf(
            "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "jh", "qh", "kh", "ah",
            "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "jd", "qd", "kd", "ad",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "js", "qs", "ks", "as",
            "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "jc", "qc", "kc", "ac"
    )

    var cardCombos = arrayListOf("Флеш рояль","Стрит флеш","Каре","Full house","Фулл хауз", "Флеш","Стрит","Тройка (трипс)","Две пары","Пара","Старшая карта")

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