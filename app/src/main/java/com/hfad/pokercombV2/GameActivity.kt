package com.hfad.pokercombV2

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.support.v7.widget.Toolbar
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.hfad.pokercombV2.helpers.Constants
import com.hfad.pokercombV2.helpers.Sequences
import com.hfad.pokercombV2.models.Card
import java.util.*
import java.util.concurrent.TimeUnit

class GameActivity : AppCompatActivity() {

    private var iter = 0 //variable for iteration in cardPics array
    private var cardDeck = mutableListOf<Card>()
    private var combos = ""
    private var constants = Constants()
    private var seq = Sequences()
    private var randCombo = 0
    private var listOfPics = mutableListOf<String>()
    private var picsViewList = arrayListOf(R.id.game_image1, R.id.game_image2, R.id.game_image3, R.id.game_image4, R.id.game_image5, R.id.game_image6, R.id.game_image7)
    private var buttonsViewList = arrayListOf(R.id.game_button1, R.id.game_button2, R.id.game_button3, R.id.game_button4)
    private var buttonsNamesList = mutableListOf<String>()
    private var resultDialogFragment = MyDialogFragment()
    private var manager = supportFragmentManager
    private lateinit var mPrefs: SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    private var rightAnswers = 0
    private var wrongAnswers = 0
    private var answersCombo = ""
    private var currentTime: Long = 0
    private var clickCounter = 0
    private var wholeTime:Long = 0
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var toolbar:Toolbar

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

    private fun adInit() {
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-9561253976720525/5433322480"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mInterstitialAd.adListener = object: AdListener() {

            override fun onAdClosed() {
                mInterstitialAd.loadAd(AdRequest.Builder().build())
            }

        }
    }

    fun initialize() {

        refresh()

        adInit()


        currentTime = Calendar.getInstance().timeInMillis

        mPrefs = getSharedPreferences("gameData", Context.MODE_PRIVATE)

        for (i in constants.cardSuit) {
            for (j in constants.cardRank) {
                cardDeck.add(Card(constants.cardPics[iter],j,i))
                iter++
            }
        }

        iter = 0

        listOfPics.clear()

        randCombo = (1..10).random()
        combos = ""

        makeCombo(randCombo)
        listOfPics.shuffle()

        for (i in picsViewList) {
            findViewById<ImageView>(i).setImageResource(this.resources.getIdentifier(listOfPics[iter], "drawable", this.packageName))
            iter++
        }

        iter = 0

        buttonsNamesList.add(combos)

        while (iter != 3) {
            randCombo = (0..9).random()
            if (!buttonsNamesList.contains(constants.cardCombos[randCombo])) {
                buttonsNamesList.add(constants.cardCombos[randCombo])
                iter++
            }
        }

        buttonsNamesList.shuffle()

        iter = 0

        for (i in buttonsViewList) {
            findViewById<Button>(i).text = buttonsNamesList[iter]
            iter++
        }
        iter = 0
    }

    private fun refresh() {
        randCombo = 0
        combos = ""
        listOfPics.clear()
        iter = 0
        buttonsNamesList.clear()
        cardDeck.clear()
        answersCombo = ""
        currentTime = Calendar.getInstance().timeInMillis
    }

    private fun showAd(clicks:Int) {
        if (clicks % 15 == 0) {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                //Toast.makeText(this, "Not yet", Toast.LENGTH_SHORT).show()
                Log.d("GameActivityAd", "The interstitial wasn't loaded yet.")
            }
        }
    }

    private fun openDialog() {
        editor = mPrefs.edit()
        editor.putString("combo", combos)
        editor.putInt("rightAns", rightAnswers)
        editor.putInt("wrongAns", wrongAnswers)
        editor.putString("ansCombo", answersCombo)
        editor.putString("timer", (TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)).toString())
        editor.putLong("allTime", wholeTime)
        editor.putInt("allClicks", clickCounter)
        editor.apply()

        resultDialogFragment.show(manager, "dialog")
    }

    fun onButton1Click(v:View) {
        val b = v as Button
        answersCombo = b.text.toString()
        clickCounter++
        showAd(clickCounter)
        wholeTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        if (b.text == combos) {
            rightAnswers++
            openDialog()
        } else {
            wrongAnswers++
            openDialog()
        }
    }

    fun onButton2Click(v:View) {
        val b = v as Button
        answersCombo = b.text.toString()
        clickCounter++
        showAd(clickCounter)
        wholeTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        if (b.text == combos) {
            rightAnswers++
            openDialog()
        } else {
            wrongAnswers++
            openDialog()
        }
    }

    fun onButton3Click(v:View) {
        val b = v as Button
        answersCombo = b.text.toString()
        clickCounter++
        showAd(clickCounter)
        wholeTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        if (b.text == combos) {
            rightAnswers++
            openDialog()
        } else {
            wrongAnswers++
            openDialog()
        }
    }

    fun onButton4Click(v:View) {
        val b = v as Button
        answersCombo = b.text.toString()
        clickCounter++
        showAd(clickCounter)
        wholeTime += TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - currentTime)
        if (b.text == combos) {
            rightAnswers++
            openDialog()
        } else {
            wrongAnswers++
            openDialog()
        }
    }

    private fun makeCombo(randCombo: Int) {
        when (randCombo) {

            1 -> {
                listOfPics.addAll(seq.royalFlush(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Флеш рояль"
            }
            2 -> {
                listOfPics.addAll(seq.straightFlush(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Стрит флеш"
            }
            3 -> {
                listOfPics.addAll(seq.fourOfAKind(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Каре"
            }
            4 -> {
                listOfPics.addAll(seq.fullHouse(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Фулл хауз"
            }
            5 -> {
                listOfPics.addAll(seq.flush(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Флеш"
            }
            6 -> {
                listOfPics.addAll(seq.straight(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Стрит"
            }
            7 -> {
                listOfPics.addAll(seq.threeOfAKind(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Тройка (трипс)"
            }
            8 -> {
                listOfPics.addAll(seq.twoPair(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Две пары"
            }
            9 -> {
                listOfPics.addAll(seq.onePair(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Пара"
            }
            10 -> {
                listOfPics.addAll(seq.highestCard(cardDeck))
                listOfPics.addAll(seq.addTwoCards(listOfPics, constants.cardPics)) //adding two more cards
                combos = "Старшая карта"
            }
        }
    }
}
