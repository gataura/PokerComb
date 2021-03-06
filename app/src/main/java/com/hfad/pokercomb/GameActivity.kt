package com.hfad.pokercomb

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.support.v7.widget.Toolbar
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.hfad.pokercomb.helper.Constants
import com.hfad.pokercomb.helper.Sequences
import com.hfad.pokercomb.models.Card
import org.ocpsoft.prettytime.PrettyTime
import java.util.*
import java.util.concurrent.TimeUnit

class GameActivity : AppCompatActivity() {

    var iter = 0 //variable for iteration in cardPics array
    var deck = mutableListOf<Card>()
    var comb = ""
    var constants = Constants()
    var seq = Sequences()
    var randCombo = 0
    var picList = mutableListOf<String>()
    var imageViewList = arrayListOf(R.id.image1, R.id.image2, R.id.image3, R.id.image4, R.id.image5, R.id.image6, R.id.image7)
    var buttonViewList = arrayListOf(R.id.button1, R.id.button2, R.id.button3, R.id.button4)
    var buttonNamesList = mutableListOf<String>()
    var myDialogFragment = MyDialogFragment()
    var manager = supportFragmentManager
    lateinit var mPrefs: SharedPreferences
    lateinit var editor:SharedPreferences.Editor
    var rightAns = 0
    var wrongAns = 0
    var ansCombo = ""
    var currentTime: Long = 0
    var clickCounter = 0
    var allTime:Long = 0
    var counter = 0
    lateinit var toolbar:Toolbar
    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        toolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)



        initialize()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun initialize() {

        refresh()

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().addTestDevice("F9629AB0617288FDF96BEF70E9154EAD").build())


        currentTime = Calendar.getInstance().timeInMillis

        mPrefs = getSharedPreferences("gameData", Context.MODE_PRIVATE)

        for (i in constants.cardSuit) {
            for (j in constants.cardRank) {
                deck.add(Card(constants.cardPics[iter],j,i))
                iter++
            }
        }

        iter = 0

        picList.clear()

        randCombo = (1..10).random()
        comb = ""

        makeCombo(randCombo)
        picList.shuffle()

        for (i in imageViewList) {
            findViewById<ImageView>(i).setImageResource(this.resources.getIdentifier(picList[iter], "drawable", this.packageName))
            iter++
        }

        iter = 0

        buttonNamesList.add(comb)

        while (iter != 3) {
            randCombo = (0..9).random()
            if (!buttonNamesList.contains(constants.cardCombos[randCombo])) {
                buttonNamesList.add(constants.cardCombos[randCombo])
                iter++
            }
        }

        buttonNamesList.shuffle()

        iter = 0

        for (i in buttonViewList) {
            findViewById<Button>(i).text = buttonNamesList[iter]
            iter++
        }
        iter = 0
    }

    fun refresh() {
        randCombo = 0
        comb = ""
        picList.clear()
        iter = 0
        buttonNamesList.clear()
        deck.clear()
        ansCombo = ""
        currentTime = Calendar.getInstance().timeInMillis
    }

    fun openDialog() {
        editor = mPrefs.edit()
        editor.putString("combo", comb)
        editor.putInt("rightAns", rightAns)
        editor.putInt("wrongAns", wrongAns)
        editor.putString("ansCombo", ansCombo)
        editor.putString("timer", (TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)).toString())
        editor.putLong("allTime", allTime)
        editor.putInt("allClicks", clickCounter)
        editor.commit()

        myDialogFragment.show(manager, "dialog")
    }

    fun onButton1Click(v:View) {
        var b = v as Button
        ansCombo = b.text.toString()
        clickCounter++
        allTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        counter++
        if (counter % 5 == 0) {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }
        }
        if (b.text == comb) {
            rightAns++
            openDialog()
        } else {
            wrongAns++
            openDialog()
        }
    }

    fun onButton2Click(v:View) {
        var b = v as Button
        ansCombo = b.text.toString()
        clickCounter++
        allTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        counter++
        if (counter % 5 == 0) {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }
        }
        if (b.text == comb) {
            rightAns++
            openDialog()
        } else {
            wrongAns++
            openDialog()
        }
    }

    fun onButton3Click(v:View) {
        var b = v as Button
        ansCombo = b.text.toString()
        clickCounter++
        allTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        counter++
        if (counter % 5 == 0) {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }
        }
        if (b.text == comb) {
            rightAns++
            openDialog()
        } else {
            wrongAns++
            openDialog()
        }
    }

    fun onButton4Click(v:View) {
        var b = v as Button
        ansCombo = b.text.toString()
        clickCounter++
        allTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        counter++
        if (counter % 5 == 0) {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }
        }
        if (b.text == comb) {
            rightAns++
            openDialog()
        } else {
            wrongAns++
            openDialog()
        }
    }

    fun makeCombo(randCombo: Int) {
        when (randCombo) {

            1 -> {
                picList.addAll(seq.royalFlush(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Royal Flush"
            }
            2 -> {
                picList.addAll(seq.straightFlush(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Straight Flush"
            }
            3 -> {
                picList.addAll(seq.fourOfAKind(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Four of a kind"
            }
            4 -> {
                picList.addAll(seq.fullHouse(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Full house"
            }
            5 -> {
                picList.addAll(seq.flush(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Flush"
            }
            6 -> {
                picList.addAll(seq.straight(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Straight"
            }
            7 -> {
                picList.addAll(seq.threeOfAKind(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Three of a kind"
            }
            8 -> {
                picList.addAll(seq.twoPair(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "Two pair"
            }
            9 -> {
                picList.addAll(seq.onePair(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "One pair"
            }
            10 -> {
                picList.addAll(seq.highestCard(deck))
                picList.addAll(seq.addTwoCards(picList, constants.cardPics)) //adding two more cards
                comb = "High card"
            }
        }
    }
}
