package com.hfad.pokercombV2.helpers

import android.util.Log
import com.hfad.pokercombV2.models.Card

class Sequences {

    var randomSuit = 0
    var randomRank1 = 0
    var randomRank2 = 0
    var c = 0
    var comboList = mutableListOf<String>()
    var tempList = mutableListOf<Int>()
    var tempCardLIst = mutableListOf<String>()
    lateinit var tempCard:Card

    fun royalFlush(cards: List<Card>): List<String> {
        randomSuit = (1..4).random()
        comboList.clear()

        for (i in cards) {
            if ((i.getSuit() == randomSuit) && ((i.getRank() == 10) || (i.getRank() == 11) || (i.getRank() == 12) || (i.getRank() == 13) || (i.getRank() == 14))) {

                comboList.add(i.getPic())

            }
        }
        return comboList
    }

    fun straightFlush(cards: List<Card>): List<String> {
        randomSuit = (1..4).random()
        randomRank1 = (1..9).random()

        comboList.clear()

        for (i in cards) {
            if ((i.getSuit() == randomSuit) && ((i.getRank() == randomRank1 + 1) || (i.getRank() == randomRank1 + 2) || (i.getRank() == randomRank1 + 3) || (i.getRank() == randomRank1 + 4) || (i.getRank() == randomRank1 + 5))) {

                comboList.add(i.getPic())

            }
        }
        return comboList
    }

    fun fourOfAKind(cards: List<Card>): List<String> {

        randomRank1 = (2..14).random()

        randomRank2 = if (randomRank1 < 10) {
            randomRank1 + 1
        } else {
            randomRank1 - 1
        }
        comboList.clear()

        for (i in cards) {
            if (i.getRank() == randomRank1) {
                comboList.add(i.getPic())
            }
        }
        comboList.add(cards[randomRank2-2].getPic())
        return comboList
    }

    fun fullHouse(cards: List<Card>): List<String> {
        randomRank1 = (2..14).random()

        randomRank2 = if (randomRank1 < 10) {
            randomRank1 + 1
        } else {
            randomRank1 - 1
        }

        c = 0
        comboList.clear()


        for (i in cards) {
            if ((i.getRank() == randomRank1) && (c<3)) {
                comboList.add(i.getPic())
                c++
            }
        }
        c = 0

        for (j in cards) {
            if ((j.getRank() == randomRank2) && (c<2)) {
                comboList.add(j.getPic())
                c++
            }
        }
        return comboList
    }

    fun flush(cards: List<Card>): List<String> {
        randomSuit = (1..4).random()
        comboList.clear()
        c = 0


        while (c != 5) {
            tempCard = cards[(0..51).random()]
            if ((tempCard.getSuit() == randomSuit) && !comboList.contains(tempCard.getPic())) {
                comboList.add(tempCard.getPic())
                c++
            }
        }

        return comboList
    }

    fun straight (cards: List<Card>): List<String> {
        randomRank1 = (1..9).random()

        comboList.clear()

        for (i in cards) {
            if ((i.getRank() == randomRank1 + 1) || (i.getRank() == randomRank1 + 2) || (i.getRank() == randomRank1 + 3) || (i.getRank() == randomRank1 + 4) || (i.getRank() == randomRank1 + 5)){
                comboList.add(i.getPic())
            }
        }
        return comboList
    }

    fun threeOfAKind(cards: List<Card>): List<String> {
        randomRank1 = (2..14).random()
        comboList.clear()
        c = 0
        tempList.clear()

        tempList.add(randomRank1)

        for (i in cards) {
            if ((i.getRank() == randomRank1) && (c<3)) {
                comboList.add(i.getPic())
                c++
            }
        }

        c = 0

        while (c!=2) {
            randomRank2 = (2..14).random()
            if (!tempList.contains(randomRank2)) {
                comboList.add(cards[randomRank2-2].getPic())
                tempList.add(randomRank2)
                c++
            }
            }
        return comboList
        }

    fun twoPair(cards: List<Card>): List<String> {
        randomRank1 = (2..14).random()
        tempList.clear()
        tempList.add(randomRank1)

        randomRank2 = if (randomRank1 < 10) {
            randomRank1 + 1
        } else {
            randomRank1 - 1
        }
        tempList.add(randomRank2)

        c = 0
        comboList.clear()


        for (i in cards) {
            if ((i.getRank() == randomRank1) && (c<2)) {
                comboList.add(i.getPic())
                c++
            }
        }
        c = 0

        for (j in cards) {
            if ((j.getRank() == randomRank2) && (c<2)) {
                comboList.add(j.getPic())
                c++
            }
        }

        c = 0

        while (c!=1) {
            randomRank1 = (2..14).random()
            if (!tempList.contains(randomRank1)) {
                comboList.add(cards[randomRank1-2].getPic())
                comboList.add(cards[randomRank1-2].getPic())
                c++
            }
        }
        return comboList
    }

    fun onePair(cards: List<Card>): List<String>{
        randomRank1 = (2..14).random()
        comboList.clear()
        c = 0
        tempList.clear()
        tempList.add(randomRank1)

        for (i in cards) {
            if ((i.getRank() == randomRank1) && (c<2)) {
                comboList.add(i.getPic())
                c++
            }
        }
        c = 0

        while (c!=3) {
            randomRank2 = (2..14).random()
            if (!tempList.contains(randomRank2)) {
                comboList.add(cards[randomRank2-2].getPic())
                tempList.add(randomRank2)
                c++
            }
        }
        return comboList
    }

    fun highestCard(cards: List<Card>): List<String> {
        comboList.clear()
        c = 0
        tempList.clear()

        while (c!=5) {
            randomRank2 = (2..14).random()
            if (!tempList.contains(randomRank2)) {
                comboList.add(cards[randomRank2].getPic())
                tempList.add(randomRank2)
                c++
            }
        }
        return comboList
    }

    fun addTwoCards(cards: List<String>, cardPics: List<String>): List<String> {
        comboList.clear()
        comboList.addAll(cards)
        tempCardLIst.clear()
        c = 0

        while (c!=2) {
            randomRank1 = (0..51).random()
            if (!comboList.contains(cardPics[randomRank1])) {
                tempCardLIst.add(cardPics[randomRank1])
                c++
            }
        }
        Log.d("addTwo", "$comboList")
        return tempCardLIst
    }
}