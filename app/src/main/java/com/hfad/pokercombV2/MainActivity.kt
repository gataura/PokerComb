package com.hfad.pokercombV2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.ads.MobileAds
import com.hfad.pokercombV2.adapter.CardsAdapter
import com.hfad.pokercombV2.helpers.Constants
import com.hfad.pokercombV2.models.Card
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var constants = Constants()


    private var deck = mutableListOf<Card>()
    private lateinit var cardsResyclerView: RecyclerView
    private lateinit var cardsAdapter: CardsAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private var iter = 0 //variable for iteration in cardPics array
    private lateinit var intent1: Intent
    private lateinit var configuration:YandexMetricaConfig
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        intent1 = Intent(this, GameActivity::class.java)

        metricInit()

        fab.setOnClickListener {
            deck.shuffle()
            cardsAdapter.notifyDataSetChanged()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        deckInit()
        recyclerInit()

    }


    private fun metricInit() {
        MobileAds.initialize(this, "ca-app-pub-9561253976720525~7609604274")

        configuration = YandexMetricaConfig.newConfigBuilder("666aa513-e527-4d59-8d69-c0d62ca1cdaa").build()
        YandexMetrica.activate(this, configuration)
        YandexMetrica.enableActivityAutoTracking(this.application)
    }

    private fun deckInit() {
        deck.clear()

        for (i in constants.cardSuit) {
            for (j in constants.cardRank) {
                deck.add(Card(constants.cardPics[iter],j,i))
                iter++
            }
        }
    }

    private fun recyclerInit() {
        cardsResyclerView = findViewById(R.id.combin_recycler_view)
        cardsResyclerView.isNestedScrollingEnabled = false
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cardsResyclerView.layoutManager = layoutManager
        cardsAdapter = CardsAdapter(constants.comboList, this, deck)
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



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_game -> {

                this.startActivity(intent1)

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
