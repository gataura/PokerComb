package com.hfad.pokercomb.helper

import android.content.Context
import com.hfad.pokercomb.Adapter.CardsAdapter
import com.hfad.pokercomb.models.Card
import com.hfad.pokercomb.models.Combination
import kotlin.math.sqrt

class CardsHelper {

    var seq = Sequences()

    var res1: Int = 0
    var res2: Int = 0
    var res3: Int = 0
    var res4: Int = 0
    var res5: Int = 0

    var l = mutableListOf<String>()

    fun takePics(name:String, deck: List<Card>): List<String> {

        l.clear()

        when (name) {

            "RF" -> l.addAll(seq.royalFlush(deck))
            "SF" -> l.addAll(seq.straightFlush(deck))
            "FK" -> l.addAll(seq.fourOfAKind(deck))
            "FH" -> l.addAll(seq.fullHouse(deck))
            "F" -> l.addAll(seq.flush(deck))
            "S" -> l.addAll(seq.straight(deck))
            "TK" -> l.addAll(seq.threeOfAKind(deck))
            "TP" -> l.addAll(seq.twoPair(deck))
            "OP" -> l.addAll(seq.onePair(deck))
            "HC" -> l.addAll(seq.highestCard(deck))
        }

        return l
    }

    fun setPics(holder: CardsAdapter.CardsViewHolder, item: List<String>, context: Context) {

        res1 = context.resources.getIdentifier(item[0], "drawable", context.packageName)
        res2 = context.resources.getIdentifier(item[1], "drawable", context.packageName)
        res3 = context.resources.getIdentifier(item[2], "drawable", context.packageName)
        res4 = context.resources.getIdentifier(item[3], "drawable", context.packageName)
        res5 = context.resources.getIdentifier(item[4], "drawable", context.packageName)

        holder.pic1.setImageResource(res1)
        holder.pic2.setImageResource(res2)
        holder.pic3.setImageResource(res3)
        holder.pic4.setImageResource(res4)
        holder.pic5.setImageResource(res5)

    }

}