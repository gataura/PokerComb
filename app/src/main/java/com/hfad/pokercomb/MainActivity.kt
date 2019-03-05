package com.hfad.pokercomb

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.hfad.pokercomb.Adapter.CardsAdapter
import com.hfad.pokercomb.helper.Constants
import com.hfad.pokercomb.models.Card
import com.hfad.pokercomb.models.Combination
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var constants = Constants()

    var cardPics = arrayListOf(
            "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "jh", "qh", "kh", "ah",
            "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "jd", "qd", "kd", "ad",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "js", "qs", "ks", "as",
            "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "jc", "qc", "kc", "ac"
            )

    val comboList = arrayListOf(
            Combination(constants.rfName,constants.rfDesc, constants.rfProbability, constants.rfPics),
            Combination(constants.sfName,constants.sfDesc, constants.sfProbability, constants.sfPics),
            Combination(constants.fkName,constants.fkDesc, constants.fkProbability, constants.fkPics),
            Combination(constants.fhName,constants.fhDesc, constants.fhProbability, constants.fhPics),
            Combination(constants.fName,constants.fDesc, constants.fProbability, constants.fPics),
            Combination(constants.sName,constants.sDesc, constants.sProbability, constants.sPics),
            Combination(constants.tkName,constants.tkDesc, constants.tkProbability, constants.tkPics),
            Combination(constants.tpName,constants.tpDesc, constants.tpProbability, constants.tpPics),
            Combination(constants.opName,constants.opDesc, constants.opProbability, constants.opPics),
            Combination(constants.hkName,constants.hkDesc, constants.hkProbability, constants.hkPics)
    )

    var cardRank = arrayListOf(2,3,4,5,6,7,8,9,10,11,12,13,14) //каждая цифра - определенная карта, 2 - двойка, 14 - туз
    var cardSuit = arrayListOf(1,2,3,4) //каждая цифра - опредленная масть, 1 - сердце, 2 - бубны, 3 - пики, 4 - трефы сделано для дальнейшего удобства

    var deck = mutableListOf<Card>()
    lateinit var cardsResyclerView: RecyclerView
    lateinit var cardsAdapter: CardsAdapter
    lateinit var layoutManager: LinearLayoutManager
    var iter = 0 //variable for iteration in cardPics array

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        for (i in cardSuit) {
            for (j in cardRank) {
                deck.add(Card(cardPics[iter],j,i))
                iter++
            }
        }




        cardsResyclerView = findViewById(R.id.combo_recycler_view)
        cardsResyclerView.isNestedScrollingEnabled = false
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cardsResyclerView.layoutManager = layoutManager
        cardsAdapter = CardsAdapter(comboList, this, deck)
        cardsResyclerView.adapter = cardsAdapter
        cardsAdapter.notifyDataSetChanged()

    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
